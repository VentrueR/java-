package test.thread;

import java.util.concurrent.FutureTask;

/**
 * @Author: 韩睿
 * @Description:
 * @DateTime: 2024/9/2 10:31
 **/
public class ThreadTestCallable {
    public static void main(String[] args) throws Exception{
        MyCallable myCallable = new MyCallable(10);
        FutureTask futureTask = new FutureTask<>(myCallable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

        MyCallable myCallable1 = new MyCallable(20);
        FutureTask futureTask1 = new FutureTask<>(myCallable1);
        new Thread(futureTask1).start();

        System.out.println(futureTask1.get());
    }
}
