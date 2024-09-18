package test.thread;

import java.util.concurrent.*;

/**
 * @Author: 韩睿
 * @Description:
 * @DateTime: 2024/9/2 22:59
 **/
public class ThreadPoolTest {
//    public ThreadPoolExecutor(int corePoolSize,
//                              int maximumPoolSize,
//                              long keepAliveTime,
//                              TimeUnit unit,
//                              BlockingQueue<Runnable> workQueue) {
//        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
//                Executors.defaultThreadFactory(), defaultHandler);
//    }
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(3,5,10,TimeUnit.SECONDS,new ArrayBlockingQueue<>(2),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        Runnable t = new MyRunnable();
        pool.execute(t);
        pool.execute(t);
        pool.execute(t);
        pool.execute(t);
        pool.execute(t);
        pool.execute(t);
        pool.execute(t);
        pool.execute(t);

    }
}
