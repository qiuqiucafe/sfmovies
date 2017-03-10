package com.connie.sfmovies.ds;

import com.connie.sfmovies.dto.Sfmovie;
import com.connie.sfmovies.page.PageCondition;
import com.connie.sfmovies.page.PageDataSet;

/**
 * sf movies service
 * 
 * @author Administrator
 *
 */
public interface ISfmovieDS {

    /**
     * query
     * 
     * @param info
     *            Sfmovie
     * @param page
     *            PageCondition
     * @return PageDataSet
     */
    PageDataSet query(Sfmovie info, PageCondition page);
}
