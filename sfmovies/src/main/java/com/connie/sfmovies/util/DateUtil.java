package com.connie.sfmovies.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class DateUtil.
 */
public class DateUtil {

    /** The date format. */
    public static String dateFormat = "yyyy-MM-dd HH:mm:ss";

    /** The db date format. */
    public static String dbDateFormat = "yyyy-mm-dd HH24:MI:SS";

    /** The DEFAUL t_ pattern. */
    public static final String FORMAT_YMDHMS = "yyyyMMddHHmmss";

    /** The DEFAUL t_ pattern. */
    public static String DEFAULT_PATTERN = "yyyy.MM.dd HH:mm:ss";

    public static String DATE_PATTERN = "yyyy.MM.dd";

    /**
     * 日期相加，加的单位为分钟.
     * 
     * @param date
     *            the date
     * @param minute
     *            the minute
     * @return the java.util. date
     * @return
     */
    public static java.util.Date addDate(java.util.Date date, int minute) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) + ((long) minute) * 60 * 1000);
        return c.getTime();
    }

    /**
     * Adds the date month.
     * 
     * @param date
     *            the date
     * @param month
     *            the month
     * @return the java.util. date
     * @version
     */
    public static java.util.Date addDateMonth(java.util.Date date, int month) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.add(c.MONTH, month);
        return c.getTime();
    }

    /**
     * 描述信息:.
     * 
     * @param date
     *            the date
     * @param second
     *            the second
     * @return the java.util. date
     * @return
     * @author David
     * 
     *         完成日期: 2011-9-20
     */
    public static java.util.Date addDateSecond(java.util.Date date, int second) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) + second * 1000);
        // c.add(c.SECOND, second);
        return c.getTime();
    }

    /**
     * 当前时间加xx秒, 返回字符型日期时间，格式为yyyy.MM.dd HH:mm:ss.
     * 
     *
     * @param second
     *            the second
     * @return 增加xx秒后的时间
     * @author David
     * 
     *         完成日期: 2011-9-20
     */
    public static String addSecondToCurrent(int second) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        java.util.Date date = new java.util.Date();
        c.setTimeInMillis(getMillis(date) + second * 1000);
        date = c.getTime();
        return format(date, "yyyy.MM.dd HH:mm:ss");
    }

    /**
     * 日期相减，返回相差的分钟数.
     * 
     * @param date
     *            the date
     * @param date1
     *            the date1
     * @return long
     * @version
     */
    public static long diffDate(java.util.Date date, java.util.Date date1) {
        if (date.after(date1)) {
            return (getMillis(date) - getMillis(date1)) / (1000 * 60);
        } else {
            return (getMillis(date1) - getMillis(date)) / (1000 * 60);
        }
    }

    /**
     * 返回毫秒.
     * 
     * @param date
     *            the date
     * @return the millis
     * @return
     */
    public static long getMillis(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }

    /**
     * 返回字符型日期时间，格式为yyyy-MM-dd HH:mm:ss.
     * 
     * @return the date time
     * @return
     */
    public static String getDateTime() {
        java.util.Date date = new java.util.Date();
        return format(date, "yyyy-MM-dd HH:mm:ss:ms");
    }

    /**
     * 返回字符型日期时间，格式为yyyy-MM-dd HH:mm:ss.
     * 
     * @param format
     *            the format
     * @return the date time
     * @return
     */
    public static String getDateTime(String format) {
        java.util.Date date = new java.util.Date();
        return format(date, format);
    }

    /**
     * 返回字符型日期时间，格式为yyyy-MM-dd HH:mm:ss.
     * 
     * @param date
     *            the date
     * @return the date time
     * @return
     */
    public static String getDateTime(java.util.Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * Gets the date time.
     * 
     * @param date
     *            the date
     * @param partten
     *            the partten
     * @return the date time
     */
    public static String getDateTime(java.util.Date date, String partten) {
        return format(date, partten);
    }

    /**
     * 返回字符型日期，格式为yyyy-MM-dd.
     * 
     * @return the date
     * @return
     */
    public static String getDate() {
        java.util.Date date = new java.util.Date();
        return format(date, "yyyy-MM-dd");
    }

    /**
     * 返回字符型日期号数，比如今天是3月13日，这个方法返回13.
     * 
     * @return the day
     * @return
     */
    public static String getDay() {
        String date = getDate();
        return date.substring(date.lastIndexOf("-") + 1);
    }

    /**
     * 返回字符型日期，格式为yyyy-MM-dd.
     * 
     * @param date
     *            the date
     * @return the date
     * @return
     */
    public static String getDate(java.util.Date date) {
        return format(date, "yyyy-MM-dd");
    }

    /**
     * 返回字符型日期，格式根据传入的第二个参数决定.
     * 
     * @param date
     *            the date
     * @param format
     *            the format
     * @return the date
     * @return
     */
    public static String getDate(java.util.Date date, String format) {
        return format(date, format);
    }

    /**
     * 格式化输出日期.
     * 
     * @param date
     *            the date
     * @param format
     *            the format
     * @return the string
     * @return
     */
    public static String format(java.util.Date date, String format) {
        String result = "";
        try {
            if (date != null) {
                java.text.DateFormat df = new java.text.SimpleDateFormat(format);
                result = df.format(date);
            }
        } catch (Exception e) {
        }
        return result;
    }

    /**
     * 把java.util.Date转换成java.sql.Date
     * 
     * @param utildate
     *            the utildate
     * @return the sql date
     * @return
     */
    public static java.sql.Date getSqlDate(java.util.Date utildate) {
        java.sql.Date sqldate = null;
        try {
            sqldate = new java.sql.Date(utildate.getTime());
        } catch (Exception e) {
        }
        return sqldate;
    }

    /**
     * 把java.sql.Date转换成java.util.Date
     * 
     * @param sqldate
     *            the sqldate
     * @return the util date
     * @return
     */
    public static java.util.Date getUtilDate(java.sql.Date sqldate) {
        java.util.Date utildate = null;
        try {
            utildate = new java.util.Date(DateUtil.getMillis(sqldate));
        } catch (Exception e) {
        }
        return utildate;
    }

    /**
     * 描述信息:.
     * 
     * @param value
     *            the value
     * @param pattern
     *            the pattern
     * @return the java.util. date
     * @return
     * @author David
     * 
     *         完成日期: 2011-9-20
     */
    public static java.util.Date formatStrToDate(String value, String pattern) {
        java.text.SimpleDateFormat format = null;
        if (null == pattern) {
            format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else {
            format = new java.text.SimpleDateFormat(pattern);
        }
        try {
            return format.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 字符串按某种格式转成日期.
     * 
     * @param value
     *            String
     * @param pattern
     *            String
     * @return Date
     * @version
     */
    public static java.sql.Date strToDate(String value, String pattern) {
        if (value.length() <= 10) {
            value = value + " 00:00:00";
        }
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(pattern);
        java.text.ParsePosition pos = new java.text.ParsePosition(0);
        return new java.sql.Date(format.parse(value, pos).getTime());
    }

    /**
     * 字符串按某种格式转成时间戳.
     * 
     * @param value
     *            String
     * @param pattern
     *            String
     * @return Date
     * @version
     */
    public static java.sql.Timestamp strToTimestamp(String value, String pattern) {

        if (value.length() <= 10) {
            value = value + " 00:00:00";
        }
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(pattern);
        java.text.ParsePosition pos = new java.text.ParsePosition(0);
        java.util.Date date = format.parse(value, pos);
        return new java.sql.Timestamp(date.getTime());
    }

    /**
     * 比较时间串大小
     * 
     * @param date1
     * @param date2
     * @return >0 dat1大于dat2, =0 date1等于date2 <0 date1小于date2
     */
    public static int compareDatetime(String datetimestring1, String datetimestring2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        try {
            java.util.Date datetime1 = df.parse(datetimestring1);
            java.util.Date datetime2 = df.parse(datetimestring2);
            return (int) (datetime1.getTime() - datetime2.getTime());
        } catch (Exception e) {

        }
        return 0;

    }

    /**
     * yyyy-mm-dd HH:mm:ss 转换成 yyyy.mm.dd HH:mm:ss 格式时间
     * 
     * @param souredatestring
     * @return
     */
    public static String convertToformatDate(String souredatestring) {

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date date = format.parse(souredatestring);
            format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            return format.format(date);
        } catch (ParseException e) {
            return "";
        }

    }

    /**
     * 描述信息:去掉时间字符串的分割字符.
     * 
     * @param time
     *            the time
     * @return the string
     * @author David
     */
    public static String timeToStr(String time) {
        // List timeList = new ArrayList();
        char[] timeArray = time.toCharArray();
        char[] timeList = new char[timeArray.length];
        int j = 0;
        for (int i = 0; i < timeArray.length; i++) {
            if (timeArray[i] == '-' || timeArray[i] == ' ' || timeArray[i] == ':') {
                continue;
            } else {
                timeList[j] = timeArray[i];
                j++;
            }
        }
        String thinTime = new String(timeList);
        return thinTime.trim();
    }

    /**
     * 描述信息:从计算机时间纪元得到当前时间(参数单位：秒).
     * 
     * @param time
     *            the time
     * @return the date since epoch
     * @author David
     * @since 2011-10-28
     */
    public static Date getDateSinceEpoch(long time) {
        Date currentTime = new Date(time * 1000);
        return currentTime;

    }

    /**
     * 描述信息:获取从计算机时间纪元开始到指定时间的秒数.
     * 
     * @param date
     *            the date
     * @return the seconds since epoch
     * @author David
     * @since: 2011-10-28
     */
    public static long getSecondsSinceEpoch(Date date) {
        return date.getTime() / 1000;
    }

    /**
     * 
     * 功能描述：计算在给定的日期加上或减去 n 天后的日期
     * 
     * @param datestr
     *            给定的日期
     * @param days
     *            正数增加，反之减少
     * @return String
     * @author wangshanfang
     * @date 2008-11-24 @修改日志：
     */
    public static Date addByDay(Date date, int days) {
        Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    /**
     * 
     * 功能描述：计算在给定的日期加上或减去 n 天后的日期
     * 
     * @param datestr
     *            给定的日期
     * @param days
     *            正数增加，反之减少
     * @return String
     * @author wangshanfang
     * @date 2008-11-24 @修改日志：
     */
    public static int getBetweenDays(String date_s, String date_b, String formate) {
        int tem = 0;
        try {
            long datanumber = 0;
            SimpleDateFormat df = new SimpleDateFormat(formate);
            long l_end;
            long l_begin;
            l_begin = df.parse(date_s).getTime();
            l_end = df.parse(date_b).getTime();

            long temp = l_end - l_begin;
            datanumber = temp / (1000L * 60L * 60L * 24L);
            if (datanumber <= 0) {
                datanumber = 0;
            }
            tem = Integer.valueOf(String.valueOf(datanumber));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tem;
    }

    /**
     * 获取当前时间字符串 默认格式为: yyyy/MM/dd HH:mm:ss
     * 
     * @param pattern
     *            时间格式
     * @param date
     *            时间对象
     * @return String
     */
    public static String getTimeString(String pattern, Date date) {
        if (null == pattern || pattern.equals("")) {
            pattern = DateUtil.dateFormat;
        }
        if (null == date) {
            date = new Date();
        }
        String nowtime = "";
        try {
            nowtime = new SimpleDateFormat(pattern).format(date);
        } catch (Exception e) {
            // 异常时,使用默认格式返回
            nowtime = new SimpleDateFormat(DateUtil.dateFormat).format(date);
        }
        return nowtime;
    }

    /**
     * 获取当前时间对象
     * 
     * @param pattern
     *            时间格式 默认格式为: yyyy/MM/dd HH:mm:ss
     * @param source
     *            时间字符串
     * @return String
     */
    public static Date getDateOBJ(String pattern, String source) {
        if (null == pattern || pattern.trim().length() == 0) {
            pattern = DEFAULT_PATTERN;
        }
        if (null == source) {
            source = getFormatDateStrOwn(DEFAULT_PATTERN);
        }
        Date date;
        try {
            date = new SimpleDateFormat(pattern).parse(source);
        } catch (Exception e) {
            date = new Date();
        }
        return date;
    }

    /**
     * 内部条用方法
     * 
     */
    private static String getFormatDateStrOwn(String pattern) {

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String dateStr = sdf.format(new Date());
        return dateStr;
    }

    /**
     * 获取格式化的时间字符串.
     * 
     * @param pattern
     *            the pattern
     * @param date
     *            the date
     * @return the format date str
     * @return
     */
    public static String getFormatDateStr(String pattern, Date date) {
        if (null == pattern || pattern.trim().length() == 0) {
            pattern = DEFAULT_PATTERN;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        if (null == date) {
            date = new Date();
        }
        String dateStr = sdf.format(date);
        return dateStr;
    }

    /**
     * 获取当前时间的格式化的时间字符串.
     * 
     */
    public static String getFormatDateStr(Date date) {
        if (null == date) {
            date = new Date();
        }

        String pattern = DEFAULT_PATTERN;

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        String dateStr = sdf.format(date);
        return dateStr;
    }

    /**
     * The main method.
     * 
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
        // System.out.print(getRFC399DateStr(new Date()));
    }

}
