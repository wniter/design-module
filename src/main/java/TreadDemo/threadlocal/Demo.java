package TreadDemo.threadlocal;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * ThreadLocal的简单实用
 */
public class Demo {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        IntStream.range(0,10).mapToObj(i -> new Thread(() -> {
            threadLocal.set(i);
            System.out.println(Thread.currentThread() + "set i    " + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "get i    " + threadLocal.get());

        })).forEach(thread -> thread.start());
    }
}
