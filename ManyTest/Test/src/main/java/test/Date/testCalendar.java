package test.Date;

import java.util.Calendar;

/**
 * @Author: 韩睿
 * @Description: 计算操作加减日期，月从0开始
 * @DateTime: 2024/8/28 13:49
 **/
public class testCalendar {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();

        calendar.set(2024, 9, 1);
        calendar1.set(2025,0, 1);
        calendar.add(Calendar.MONTH,3);
        System.out.println(calendar.get(Calendar.MONTH) +" " + calendar.get(Calendar.YEAR));

        System.out.println(calendar.getTime());
        System.out.println(calendar.getTime().getTime());
        System.out.println(calendar1.getTime().getTime());

    }
}
