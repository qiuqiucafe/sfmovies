package com.connie.sfmovies.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author administrator.
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> DbKey = new ThreadLocal<String>();

    private static final ThreadLocal<String> DbType = new ThreadLocal<String>();

    public DynamicDataSource() {
        super();
    }

    public static void setDbKey(String dataSource) {
        DbKey.set(dataSource);
    }

    public static String getDbKey() {
        return DbKey.get();
    }

    public static void setDbType(String dbType) {
        DbType.set(dbType);
    }

    public static String getDbType() {
        return DbType.get();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#
     * determineCurrentLookupKey()
     */
    @Override
    protected Object determineCurrentLookupKey() {

        return DbKey.get();
    }

}
