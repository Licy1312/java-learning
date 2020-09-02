package com.java.learning.abc;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lee
 * @description:
 * @date:2019-08-23
 */
public class Weekend {
    public static void main(String[] args) {
        String year = "2020";
        Calendar begin = Calendar.getInstance();
        begin.set(Integer.parseInt(year), 0, 1);

        Calendar end = Calendar.getInstance();
        end.set(Integer.parseInt(year), 12, 1);

        int count = 0;
        while (begin.compareTo(end) < 0) {
            String startDate = "",endDate="";
            if (begin.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                startDate = new DateTime( begin.getTime()).toString("yyyy-MM-dd", Locale.SIMPLIFIED_CHINESE);
                startDate +=" 00:00:00";

                begin.add(Calendar.DATE, 1);
                endDate = new DateTime( begin.getTime()).toString("yyyy-MM-dd", Locale.SIMPLIFIED_CHINESE);
                endDate +=" 23:59:59";
//                System.out.println("开始时间:"+startDate+",结束时间:"+endDate);
                generateSql(startDate,endDate);
            }else{
                begin.add(Calendar.DATE, 1);
            }
        }
    }

    public static void generateSql(String startDate,String endDate){
        String sqlTemplate ="";

        System.out.println(sqlTemplate);
    }
}
