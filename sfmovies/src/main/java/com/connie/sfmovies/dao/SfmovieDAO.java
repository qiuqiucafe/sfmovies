/**
 * 
 */
package com.connie.sfmovies.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.connie.sfmovies.dao.mapper.SfmovieMapper;
import com.connie.sfmovies.dto.Sfmovie;
import com.connie.sfmovies.page.PageCondition;
import com.connie.sfmovies.page.PageDataSet;

/**
 * @author hyq
 */
@Repository("sfmovieDAO")
public class SfmovieDAO implements ISfmovieDAO {
    @Autowired
    private SfmovieMapper sfmovieMapper;

    /**
     * query by page
     * 
     * @param info
     *            Sfmovie
     * @param page
     *            PageCondition
     * @return PageDataSet
     */
    public PageDataSet query(Sfmovie info, PageCondition page) {
        PageDataSet pageDataSet = new PageDataSet();
        List<Sfmovie> sfmovieList = sfmovieMapper.queryByPage(info, page);
        pageDataSet.setDataset(sfmovieList);
        pageDataSet.setPageCondition(page);
        return pageDataSet;
    }
}
