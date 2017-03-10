'use strict';
// get page data
function getPageData(currentPage, pageSize) {
	var title = $("#title").val();
	var location = $("#location").val();
	var result = $.ajax({
		url : "sfmovie/list/",
		contentType : "application/json; charset=utf-8",
		async : false,
		type : "post",
		data : '{"title":"' + title + '", "locations":"' + location
				+ '", "currentPage":"' + currentPage + '", "pageSize":"'
				+ pageSize + '"}',
		dataType : "json"
	});
	return $.parseJSON(result.responseText);
}

// refresh data
function refreshTableData(data) {
	var computeActors = function(property, record) {
		var actors = "";
		var actor1 = record['actor1'];
		var actor2 = record['actor2'];
		var actor3 = record['actor3'];
		if (actor1 != null && actor1.length > 0) {
			actors = actor1;
		}
		if (actor2 != null && actor2.length > 0) {
			actors = actors + "," + actor2;
		}
		if (actor3 != null && actor3.length > 0) {
			actors = actors + "," + actor3;
		}
		return actors;
	};
	var config = {
		style : 'bootstrap',
		cols : [ {
			property : "title",
			header : "Title",
			sortable : true
		}, {
			property : "releaseyear",
			header : "release Year"
		}, {
			property : "locations",
			header : "Locations"
		}, {
			property : "actors",
			path : computeActors,
			header : "Actors"
		} ]
	};

	RDT.render({
		data : data,
		config : config
	}, "content");
}

// refresh pagetool
function refreshPageTool(pageCondition) {
	$("#pagetool").html("");
	ReactDOM.render(React.createElement(PageTool, {
		pageSize : pageCondition["pageSize"],
		currentPage : pageCondition["currentPage"],
		totalPage : pageCondition["totalPage"]
	}), document.getElementById('pagetool'));
}

// refresh table
function refreshTable(pageData) {
	var data = pageData["dataset"];
	refreshTableData(data);
	var pageCondition = pageData["pageCondition"];
	refreshPageTool(pageCondition);
	$("#totalCount").text(pageCondition["totalCount"]);
}

// pagetool
var PageTool = React.createClass({
	getInitialState : function() {
		return {
			pageSize : this.props.pageSize,
			currentPage : this.props.currentPage,
			totalPage : this.props.totalPage,
			totalCount : this.props.totalCount
		};
	},
	gotoPage : function(event) {
		var _currentPage = parseInt(this.state.currentPage);
		if (event != null) {
			var index = event.target.text;
			if (index == "<") {
				_currentPage = _currentPage - 1;
			} else if (index == ">") {
				_currentPage = _currentPage + 1;
			} else {
				_currentPage = parseInt(index);
			}
		}
		var pageData = getPageData(_currentPage, this.state.pageSize);
		refreshTable(pageData);
		var totalPage = pageData["pageCondition"].totalPage;
		var totalCount = pageData["pageCondition"].totalCount;
		this.setState({
			currentPage : _currentPage
		});
		this.setState({
			totalPage : totalPage
		});
		this.setState({
			totalCount : totalCount
		});
	},
	render : function() {
		var pagedom = function() {
			var _pageDom = [];
			// when totalpage > 5, show front and bottom
			var minpage = 1;
			var maxpage = this.state.totalPage;
			if (this.state.currentPage > 3) {
				minpage = this.state.currentPage - 2;
			}
			if (this.state.totalPage - minpage > 4) {
				maxpage = minpage + 4;
			}
			if (minpage > 1) {
				_pageDom.push(React.createElement("li", {
					id : "page_pre"
				}, React.createElement("a", {
					href : "javascript:void(0)",
					title : "Previous",
					onClick : this.gotoPage
				}, "<")));
			}
			for (var i = minpage; i <= maxpage; i++) {
				if (i == this.state.currentPage) {
					_pageDom.push(React.createElement("li", {
						id : "page_" + i,
						className : "active"
					}, React.createElement("a", {
						href : "javascript:void(0)",
						onClick : this.gotoPage
					}, i)));
				} else {
					_pageDom.push(React.createElement("li", {
						id : "page_" + i
					}, React.createElement("a", {
						href : "javascript:void(0)",
						onClick : this.gotoPage
					}, i)));
				}
			}
			if (maxpage < this.state.totalPage) {
				_pageDom.push(React.createElement("li", {
					id : "page_next"
				}, React.createElement("a", {
					href : "javascript:void(0)",
					title : "Next",
					onClick : this.gotoPage
				}, ">")));
			}
			return _pageDom;
		}.bind(this);
		return (React.createElement("ul", {
			className : "pagination"
		}, pagedom()));
	}
});

function queryMovies() {
	var title = $("#title").val();
	var location = $("#location").val();
	var queryflag = true;
	if (title != null && title.length > 100) {
		$("#content").html("");
		$("#pagetool").html("");
		$("#totalCount").text("0");
		queryflag = false;
		alert("Please enter no more than 100 characters of Title.");
	}
	if (location != null && location.length > 100) {
		$("#content").html("");
		$("#pagetool").html("");
		$("#totalCount").text("0");
		queryflag = false;
		alert("Please enter no more than 100 characters of Location.");
	}
	if (queryflag) {
		var pageData = getPageData(1, 10);
		refreshTable(pageData);
	}
}

$(function() {
	var pageData = getPageData(1, 10);
	refreshTable(pageData);
});
