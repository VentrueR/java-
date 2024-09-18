package test.thread;

/**
 * @Author: 韩睿
 * @Description: 创建线程的方法一：继承Thread
 * @DateTime: 2024/9/2 10:00
 **/
public class MyThread extends Thread{
    @Override
    public void run() {
        for(int i = 1; i< 10; i++)
        System.out.println("t"  + i);
    }
}
