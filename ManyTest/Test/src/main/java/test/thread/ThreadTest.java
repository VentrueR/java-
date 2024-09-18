package test.thread;

/**
 * @Author: 韩睿
 * @Description:
 * @DateTime: 2024/9/2 10:01
 **/
public class ThreadTest {
    public static void main (String[] args) {
        Thread thread = new MyThread();
        thread.start();
        for(int i = 1; i< 10; i++)
        System.out.println("m" + i);
    }
}
