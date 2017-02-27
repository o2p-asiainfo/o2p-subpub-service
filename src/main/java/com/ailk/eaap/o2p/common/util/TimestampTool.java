package com.ailk.eaap.o2p.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by david on 15/1/2.
 */
public final class TimestampTool {
	
    private TimestampTool(){
		
	}
	
    /**
     * 获得当前时间
     *
     * @return
     */
    public static Date getDate() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 获得当前时间
     *
     * @param format
     * @return
     */
    public static String getDate(String format) {
        return new SimpleDateFormat(format).format(getDate());
    }

    /**
     * 获得当前时间戳
     *
     * @return
     */
    public static String getTimeStamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    /**
     * 根据入参时间转换类型
     *
     * @param time
     * @param format
     * @return
     */
    public static String getDate(long time, String format) {
        return new SimpleDateFormat(format).format(time);
    }

    /**
     * 获得标准UTC时间字符串
     *
     * @return
     */
    public static String getUTCStr() {
        return getUTCDate().toString();
    }

    /**
     * 获得标准UTC时间
     * @return
     */
    public static Date getUTCDate() {
        return getUTCCalendar().getTime();
    }

    /**
     * 获得标准UTC日历, 以英国时区为标准
     *
     * @return
     */
    public static Calendar getUTCCalendar() {
        Calendar calendar = Calendar.getInstance();
        // 获得时间偏量
        int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);
        // 取得夏令时差
        int dstOffset = calendar.get(Calendar.DST_OFFSET);
        // 从本地时间里扣除这些差量, 取得UTC时间
        calendar.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        return calendar;
    }
}
