package test.thread;

/**
 * @Author: 韩睿
 * @Description:
 * @DateTime: 2024/9/2 10:16
 **/
public class ThreadTestRunnable {
    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();
        new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("t2->" + i);
                    }
                }
        ).start();
    }
}
