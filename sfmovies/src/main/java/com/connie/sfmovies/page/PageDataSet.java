package com.connie.sfmovies.page;

import java.util.List;

/**
 * @author 10075673.
 *
 */
public class PageDataSet {

    PageCondition pageCondition;

    @SuppressWarnings("rawtypes")
    // 数据
    List dataset;

    public PageDataSet() {
        super();
    }

    /**
     * @return the pageCondition.
     */
    public PageCondition getPageCondition() {
        return pageCondition;
    }

    /**
     * @param pageCondition
     *            the pageCondition to set.
     */
    public void setPageCondition(PageCondition pageCondition) {
        this.pageCondition = pageCondition;
    }

    /**
     * @return the dataset.
     * 
     */
    public List getDataset() {
        return dataset;
    }

    /**
     * @param dataset
     *            the dataset to set.
     */
    public void setDataset(List dataset) {
        this.dataset = dataset;
    }

}
