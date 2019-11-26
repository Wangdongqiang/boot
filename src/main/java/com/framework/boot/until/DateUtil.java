package com.example.demo.until;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String dateToString(Date date,String dateFormat) throws Exception{
        SimpleDateFormat format=new SimpleDateFormat(dateFormat);
        return format.format(date);
    }

    public static Date strToDate(String str, String dateFormat) throws Exception{
        SimpleDateFormat format=new SimpleDateFormat(dateFormat);
        return format.parse(str);
    }

}