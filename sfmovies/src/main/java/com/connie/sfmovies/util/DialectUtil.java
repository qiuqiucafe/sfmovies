package com.connie.sfmovies.util;

import org.springframework.stereotype.Component;

@Component("dialectUtil")
public class DialectUtil {

    public static final String SYBASE = "sybaes";

    public static final String MYSQL = "mysql";

    public static final String ORACLE = "oracle";


    public static String getDbDriver(String dialect) {
        String dbDriver;
        if ( ORACLE.equals(dialect)) {
            dbDriver = "oracle.jdbc.OracleDriver";
        } else if (SYBASE.equals(dialect)) {
            dbDriver = "net.sourceforge.jtds.jdbc.Driver";
        } else {
            dbDriver = "net.sourceforge.jtds.jdbc.Driver";
        }
        return dbDriver;
    }



}
