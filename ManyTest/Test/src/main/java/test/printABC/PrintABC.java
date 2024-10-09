package test.printABC;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 韩睿
 * @Description:实现ABC交替打印10
 * @DateTime: 2024/9/19 21:01
 **/

public class PrintABC {

    private static final Object lock = new Object();
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static int sum = 0;

    public static void main(String[] args) {
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);

        Runnable[] task = new Runnable[3];

        for(int i = 0; i < 3; i ++) {
            final int index = i;
            task[i] = ()->{

            for(int j = 0; j < 100; j++) {
                synchronized (lock) {
                    try {
                        while (sum % 3 != index) {
                            lock.wait();
                        }
                        for (int p = 0; p < 3; p++)
                        System.out.print((char) ('A' + index));
                        sum++;
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                }
            };
        }

        Thread[] threads = new Thread[3];
        for(int i = 0; i < 3; i++) {
            threads[i] = new Thread(task[i]);
            threads[i].start();
        }

        for(int i = 0; i < 3; i ++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        System.out.println(sum);
    }
}

/**
 * Atomic
 *
 *
 *
 *import java.util.concurrent.atomic.AtomicInteger;
 *
 * public class PrintABC {
 *
 *     private static final Object lock = new Object();
 *     private static AtomicInteger sum = new AtomicInteger(0);
 *
 *     public static void main(String[] args) {
 *
 *         Runnable[] task = new Runnable[3];
 *         for (int i = 0; i < 3; i++) {
 *             final int index = i;
 *             task[i] = () -> {
 *                 for (int j = 0; j < 100; j++) {
 *                     synchronized (lock) {
 *                         while (sum.get() % 3 != index) {
 *                             try {
 *                                 lock.wait();
 *                             } catch (InterruptedException e) {
 *                                 Thread.currentThread().interrupt();
 *                                 return;
 *                             }
 *                         }
 *                         System.out.print((char) ('A' + index));
 *                         sum.incrementAndGet();
 *                         lock.notifyAll();
 *                     }
 *                 }
 *             };
 *         }
 *
 *         Thread[] threads = new Thread[3];
 *         for (int i = 0; i < 3; i++) {
 *             threads[i] = new Thread(task[i]);
 *             threads[i].start();
 *         }
 *
 *         // 等待所有线程完成
 *         for (int i = 0; i < 3; i++) {
 *             try {
 *                 threads[i].join();
 *             } catch (InterruptedException e) {
 *                 Thread.currentThread().interrupt();
 *             }
 *         }
 *
 *         System.out.println("Main thread finished.");
 *     }
 * }
 *
 */
/**
 * ReentrantLock
 * import java.util.concurrent.locks.Condition;
 * import java.util.concurrent.locks.ReentrantLock;
 *
 * public class PrintABC {
 *
 *     private static final ReentrantLock lock = new ReentrantLock();
 *     private static final Condition[] conditions = new Condition[3];
 *     private static int sum = 0;
 *
 *     static {
 *         for (int i = 0; i < 3; i++) {
 *             conditions[i] = lock.newCondition();
 *         }
 *     }
 *
 *     public static void main(String[] args) {
 *
 *         Runnable[] task = new Runnable[3];
 *         for (int i = 0; i < 3; i++) {
 *             final int index = i;
 *             task[i] = () -> {
 *                 for (int j = 0; j < 100; j++) {
 *                     lock.lock();
 *                     try {
 *                         while (sum % 3 != index) {
 *                             conditions[index].await();
 *                         }
 *                         System.out.print((char) ('A' + index));
 *                         sum++;
 *                         if (sum % 3 == 0) {
 *                             conditions[(index + 1) % 3].signal();
 *                         }
 *                     } catch (InterruptedException e) {
 *                         Thread.currentThread().interrupt();
 *                     } finally {
 *                         lock.unlock();
 *                     }
 *                 }
 *             };
 *         }
 *
 *         Thread[] threads = new Thread[3];
 *         for (int i = 0; i < 3; i++) {
 *             threads[i] = new Thread(task[i]);
 *             threads[i].start();
 *         }
 *
 *         // 唤醒第一个线程开始执行
 *         lock.lock();
 *         try {
 *             conditions[0].signal();
 *         } finally {
 *             lock.unlock();
 *         }
 *
 *         // 等待所有线程完成
 *         for (int i = 0; i < 3; i++) {
 *             try {
 *                 threads[i].join();
 *             } catch (InterruptedException e) {
 *                 Thread.currentThread().interrupt();
 *             }
 *         }
 *
 *         System.out.println("Main thread finished.");
 *     }
 * }
 */
