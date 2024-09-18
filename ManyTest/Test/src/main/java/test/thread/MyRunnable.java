package test.thread;

/**
 * @Author: 韩睿
 * @Description: 创建线程的方法 二: 实现Runnable
 * @DateTime: 2024/9/2 10:15
 **/
public class MyRunnable implements Runnable{

    @Override
    public void run() {
//        for (int i = 0; i < 10; i++) {
//
//        System.out.println(Thread.currentThread().getName() + i);
//        }
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
