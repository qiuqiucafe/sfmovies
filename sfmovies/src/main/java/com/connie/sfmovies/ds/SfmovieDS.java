/**
 * 
 */
package com.connie.sfmovies.ds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connie.sfmovies.dao.SfmovieDAO;
import com.connie.sfmovies.dto.Sfmovie;
import com.connie.sfmovies.page.PageCondition;
import com.connie.sfmovies.page.PageDataSet;

/**
 * @author Administrator
 *
 */
@Service("sfmovieDS")
public class SfmovieDS implements ISfmovieDS {
    @Autowired
    private SfmovieDAO sfmovieDAO;

    /**
     * query
     * 
     * @param info
     *            Sfmovie
     * @param page
     *            PageCondition
     * @return PageDataSet
     */
    public PageDataSet query(Sfmovie info, PageCondition page) throws RuntimeException {
        return sfmovieDAO.query(info, page);
    }

}
