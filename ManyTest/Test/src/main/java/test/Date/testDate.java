package test.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: 韩睿
 * @Description: date类显示、差值时间日期
 * @DateTime: 2024/8/28 13:24
 **/
public class testDate {
    public static void main(String[] args) {
        //1970 年 1 月 1 日
        Date date = new Date(2024, 9,1);
        Date date1 = new Date(2024,12,1);
        long ms = date1.getTime()-date.getTime();
        long ans = ms/(1000*60*60*24);
        System.out.println(ans);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat.format(date));
        System.out.println(date.toString());
    }
}
