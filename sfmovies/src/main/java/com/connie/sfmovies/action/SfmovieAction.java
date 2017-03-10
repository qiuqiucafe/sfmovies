package com.connie.sfmovies.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.connie.sfmovies.common.CommonAction;
import com.connie.sfmovies.ds.ISfmovieDS;
import com.connie.sfmovies.dto.Sfmovie;
import com.connie.sfmovies.form.SfmovieForm;
import com.connie.sfmovies.page.PageCondition;
import com.connie.sfmovies.page.PageDataSet;

@RestController
@Scope("prototype")
@RequestMapping(value = "/sfmovie")
public class SfmovieAction extends CommonAction {
    /** The Constant logger. */
    private static Logger logger = Logger.getLogger(SfmovieAction.class);
    @Autowired
    ISfmovieDS SfmovieDS;

    @RequestMapping(value = "/list/", method = RequestMethod.POST)
    public ResponseEntity<PageDataSet> list(@RequestBody SfmovieForm form) {
        String jsonString = JSON.toJSONString(form);
        logger.info("receive request: " + jsonString);
        Sfmovie sfmovie = new Sfmovie();
        sfmovie.setTitle(form.getTitle());
        sfmovie.setLocations(form.getLocations());
        sfmovie.setDirector(form.getDirector());
        PageCondition pageCondition = this.getPageCondition(form);
        PageDataSet pageDataSet = SfmovieDS.query(sfmovie, pageCondition);
        jsonString = JSON.toJSONString(pageDataSet);
        logger.info("send response: " + jsonString);
        return new ResponseEntity<PageDataSet>(pageDataSet, HttpStatus.OK);
    }
}
