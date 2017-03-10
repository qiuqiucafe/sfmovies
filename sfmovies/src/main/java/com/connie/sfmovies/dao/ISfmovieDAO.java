package com.connie.sfmovies.dao;

import com.connie.sfmovies.dto.Sfmovie;
import com.connie.sfmovies.page.PageCondition;
import com.connie.sfmovies.page.PageDataSet;

/**
 * ISfmovieDAO
 * 
 * @author hyq
 *
 */
public interface ISfmovieDAO {

    /**
     * query by page
     * 
     * @param info
     *            Sfmovie
     * @param page
     *            PageCondition
     * @return PageDataSet
     */
    PageDataSet query(Sfmovie info, PageCondition page);
}
