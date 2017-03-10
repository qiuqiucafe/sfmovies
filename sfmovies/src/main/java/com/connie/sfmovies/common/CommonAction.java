/**
 * 
 */
package com.connie.sfmovies.common;

import org.springframework.beans.BeanUtils;

import com.connie.sfmovies.page.PageCondition;

/**
 * @author Administrator
 *
 */
public class CommonAction {
    
    /**
     * getPageCondition
     * 
     * @param pageCondition
     *            PageCondition
     * @return PageCondition
     */
    protected PageCondition getPageCondition(PageCondition formPageCondition) {
        PageCondition pageCondition = new PageCondition();
        BeanUtils.copyProperties(formPageCondition, pageCondition);
        return pageCondition;
    };
}
