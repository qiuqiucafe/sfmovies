package com.connie.sfmovies.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

import com.connie.sfmovies.common.DynamicDataSource;
import com.connie.sfmovies.page.PageCondition;
import com.connie.sfmovies.util.DialectUtil;

/**
 * 通过拦截<code>StatementHandler</code>的<code>prepare</code>方法，重写sql语句实现物理分页。
 * 老规矩，签名里要拦截的类型只能是接口。.
 *
 * @author 湖畔微风
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class PageInterceptor implements Interceptor {

    /** The Constant logger. */
    private static Logger logger = Logger.getLogger(PageInterceptor.class);

    /** The Constant DEFAULT_OBJECT_FACTORY. */
    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();

    /** The Constant DEFAULT_OBJECT_WRAPPER_FACTORY. */
    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();

    /** The default dialect. default:sybase support sqlserver,IQ */
    private static String defaultDialect = DialectUtil.SYBASE;

    /** The default page sql id. */
    private static String defaultPageSqlId = ".*Page$";

    /** The dialect. */
    private static String dialect = "";

    /** The page sql id. */
    private static String pageSqlId = "";

    /**
     * Intercept.
     *
     * @param invocation
     *            the invocation
     * @return the object
     * @throws Throwable
     *             the throwable
     * @version
     */
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY,
                DEFAULT_OBJECT_WRAPPER_FACTORY);
        // 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环可以分离出最原始的的目标类)
        while (metaStatementHandler.hasGetter("h")) {
            Object object = metaStatementHandler.getValue("h");
            metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
        }
        // 分离最后一个代理对象的目标类
        while (metaStatementHandler.hasGetter("target")) {
            Object object = metaStatementHandler.getValue("target");
            metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
        }
        Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
        dialect = DynamicDataSource.getDbType();
        if (null == dialect || "".equals(dialect)) {
            dialect = configuration.getVariables().getProperty("dialect");
        }
        if (null == dialect || "".equals(dialect)) {
            logger.warn("Property dialect is not setted,use default 'sybase' ");
            dialect = defaultDialect;
        }

        pageSqlId = configuration.getVariables().getProperty("pageSqlId");
        if (null == pageSqlId || "".equals(pageSqlId)) {
            logger.warn("Property pageSqlId is not setted,use default '.*Page$' ");
            pageSqlId = defaultPageSqlId;
        }
        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
        // 只重写需要分页的sql语句。通过MappedStatement的ID匹配，默认重写以Page结尾的MappedStatement的sql
        if (mappedStatement.getId().matches(pageSqlId)) {
            BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
            Object parameterObject = boundSql.getParameterObject();
            if (parameterObject == null) {
                throw new NullPointerException("parameterObject is null!");
            } else {
                PageCondition page = (PageCondition) metaStatementHandler
                        .getValue("delegate.boundSql.parameterObject.page");
                if (page == null) {
                    page = new PageCondition();
                }
                String sql = boundSql.getSql();
                // 重写sql
                String pageSql = buildPageSql(sql, page);
                metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
                // 采用物理分页后，就不需要mybatis的内存分页了，所以重置下面的两个参数
                metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
                metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
                Connection connection = (Connection) invocation.getArgs()[0];
                // 重设分页参数里的总页数等
                setPageParameter(sql, connection, mappedStatement, boundSql, page);
            }
        }
        // 将执行权交给下一个拦截器
        return invocation.proceed();
    }

    /**
     * 从数据库里查询总的记录数并计算总页数，回写进分页参数<code>PageParameter</code>,这样调用者就可用通过 分页参数
     * <code>PageParameter</code>获得相关信息。.
     *
     * @param sql
     *            the sql
     * @param connection
     *            the connection
     * @param mappedStatement
     *            the mapped statement
     * @param boundSql
     *            the bound sql
     * @param page
     *            the page
     * 
     * @throws IllegalAccessException
     *             IllegalAccessException.
     * @throws IllegalArgumentException
     *             IllegalArgumentException.
     * @throws NoSuchFieldException
     *             NoSuchFieldException.`
     * @throws SecurityException
     *             SecurityException.
     */
    private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement, BoundSql boundSql,
            PageCondition page)
                    throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        // 查询总数的时候需要去掉asc desc排序内容

        int index = sql.lastIndexOf("order by");
        if (index > 0) {
            sql = sql.substring(0, index - 1);
        }

        // 记录总记录数
        String countSql = "select count(0) as total from (" + sql + ") t";
        PreparedStatement countStmt = null;
        ResultSet rs = null;
        try {
            countStmt = connection.prepareStatement(countSql);
            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
                    boundSql.getParameterMappings(), boundSql.getParameterObject());

            setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());
            rs = countStmt.executeQuery();
            int totalCount = 0;
            if (rs.next()) {
                totalCount = rs.getInt(1);
            }

            page.setTotalCount(totalCount);
            int totalPage = totalCount / page.getPageSize() + ((totalCount % page.getPageSize() == 0) ? 0 : 1);
            page.setTotalPage(totalPage);

        } catch (SQLException e) {
            logger.error("Ignore this exception", e);
        } finally {
            try {
                if (null != rs) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error("Ignore this exception", e);
            }
            try {
                if (null != countStmt) {
                    countStmt.close();
                }
            } catch (SQLException e) {
                logger.error("Ignore this exception", e);
            }
        }

    }

    /**
     * 对SQL参数(?)设值.
     *
     * @param ps
     *            the ps
     * @param mappedStatement
     *            the mapped statement
     * @param boundSql
     *            the bound sql
     * @param parameterObject
     *            the parameter object
     * @throws SQLException
     *             the sQL exception
     * 
     */
    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
            Object parameterObject) throws SQLException {
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
        parameterHandler.setParameters(ps);
    }

    /**
     * 根据数据库类型，生成特定的分页sql.
     *
     * @param sql
     *            the sql
     * @param page
     *            the page
     * @return the string
     * 
     */
    private String buildPageSql(String sql, PageCondition page) {
        if (page != null) {
            StringBuilder pageSql = new StringBuilder();
            if (DialectUtil.MYSQL.equals(dialect)) {
                pageSql = buildPageSqlForMysql(sql, page);
            } else if (DialectUtil.ORACLE.equals(dialect)) {
                pageSql = buildPageSqlForOracle(sql, page);
            } else if (DialectUtil.SYBASE.equals(dialect)) {
                pageSql = buildPageSqlForSybase(sql, page);
            } else {
                pageSql = buildPageSqlForSybase(sql, page);
            }
            return pageSql.toString();
        } else {
            return sql;
        }
    }

    /**
     * mysql的分页语句.
     *
     * @param sql
     *            the sql
     * @param page
     *            the page
     * @return String
     * 
     */
    public StringBuilder buildPageSqlForMysql(String sql, PageCondition page) {

        StringBuilder pageSql = new StringBuilder(100);
        String beginrow = String.valueOf((page.getCurrentPage() - 1) * page.getPageSize());
        pageSql.append(sql);
        pageSql.append(" limit " + beginrow + "," + page.getPageSize());
        return pageSql;
    }

    /**
     * 使用临时表完成分页.为防止临时表数据过大，当查询的数据起始数超过总数的一半后，
     * 采用逆序的方式查询数据，并在临时表里再采用相反的顺序将数据重新排序。 因此在使用 sybase分页查询时，必须显示的指定排序字段和排序顺序。
     *
     * @param sql
     *            the sql
     * @param page
     *            the page
     * @return String
     * 
     */
    public StringBuilder buildPageSqlForSybase(String sql, PageCondition page) {
        StringBuilder pageSql = new StringBuilder(100);
        int beginrow = (page.getCurrentPage() - 1) * page.getPageSize();
        int endrow = page.getCurrentPage() * page.getPageSize();

        // 临时表随机命名，防止名称冲突
        sql = sql.toLowerCase();
        String temp = "#temp" + new Random().nextInt(1000000);
        String fromSql = sql.substring(sql.indexOf("from"));

        String selectsqlcontext = sql.substring(sql.indexOf("select") + 6, sql.indexOf("from"));
        // String order = "";
        String tempOrder = "asc";
        /*
         * if (beginrow * 2 > page.getTotalCount()) { if
         * (fromSql.lastIndexOf("desc") > 0) { // order = "asc"; order = "desc";
         * fromSql = fromSql.substring(0, fromSql.lastIndexOf("desc")) + order;
         * } else if (fromSql.lastIndexOf("asc") > 0) { // order = "desc"; order
         * = "asc"; fromSql = fromSql.substring(0, fromSql.lastIndexOf("asc")) +
         * order; } // tempOrder = "desc"; tempOrder = "asc"; }
         */
        pageSql.append("rollback  set chained off   ").append(" ");
        pageSql.append("select top ").append(endrow).append(selectsqlcontext).append(",rownum=identity(int) into ")
                .append(temp).append(" ");
        pageSql.append(fromSql).append(" ");
        pageSql.append("select * from ").append(temp).append(" where rownum > ").append(beginrow)
                .append(" order by rownum ").append(tempOrder).append(" ");
        pageSql.append("drop table " + temp);

        return pageSql;
    }

    /**
     * 参考hibernate的实现完成oracle的分页.
     *
     * @param sql
     *            the sql
     * @param page
     *            the page
     * @return String
     * 
     */
    public StringBuilder buildPageSqlForOracle(String sql, PageCondition page) {
        StringBuilder pageSql = new StringBuilder(100);
        String beginrow = String.valueOf((page.getCurrentPage() - 1) * page.getPageSize());
        String endrow = String.valueOf(page.getCurrentPage() * page.getPageSize());

        pageSql.append("select * from ( select temp.*, rownum row_id from ( ");
        pageSql.append(sql);
        pageSql.append(" ) temp where rownum <= ").append(endrow);
        pageSql.append(") where row_id > ").append(beginrow);
        return pageSql;
    }

    /**
     * Plugin.
     *
     * @param target
     *            the target
     * @return the object
     * @version
     */
    public Object plugin(Object target) {
        // 当目标类是StatementHandler类型时，才包装目标类，否者直接返回目标本身,减少目标被代理的次数
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    /**
     * Sets the properties.
     *
     * @param properties
     *            the new properties
     */
    public void setProperties(Properties properties) {
    }

}
