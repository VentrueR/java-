package test.util;

import java.util.Random;

/**
 * @Author: 韩睿
 * @Description:
 * @DateTime: 2024/9/1 16:18
 **/
public class testRandom {
    public static  void main(String[] args) {
        Random random = new Random();
        int a = 5;
        int b = 10;
        int val = b-a;
        //a~b
        System.out.println(random.nextInt(val) + a);
        //0~1 nextDouble()
        //a~b
        double ans = random.nextDouble()*(b-a) + a;
        System.out.println(String.format("%.4f",ans));
    }
}
