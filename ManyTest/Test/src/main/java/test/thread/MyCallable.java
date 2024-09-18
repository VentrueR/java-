package test.thread;

import java.util.concurrent.Callable;

/**
 * @Author: 韩睿
 * @Description: 创建线程的方法 三 ： Callable
 * @DateTime: 2024/9/2 10:29
 **/
public class MyCallable implements Callable<String> {
    private int n;

    public MyCallable(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        return "和为" + sum;
    }
}
