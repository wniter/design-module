package TreadDemo.singleton;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 单例设计模式的测试工作
 */
public class Demo {
    //饿汉式
    @Test
    public void demo01() {
        IntStream.range(0,10).mapToObj(i -> new Thread( () -> {
            Singletion1 singletion1 = Singletion1.get();
            singletion1.sout();
        }
        )).forEach(thread -> thread.start());
    }
    //懒汉式
    @Test
    public void demo02() throws InterruptedException {

        IntStream.range(0,100).mapToObj(i -> new Thread( () -> {
            Singletion2 singletion2 = Singletion2.get();
            singletion2.sout();
        }
        )).forEach(thread -> thread.start());

        TimeUnit.SECONDS.sleep(10);
    }

    //懒汉式+方法同步
    @Test
    public void demo03() throws InterruptedException {

        IntStream.range(0,10).mapToObj(i -> new Thread( () -> {
            Singletion2 singletion2 = Singletion2.get();
            singletion2.sout();
        }
        )).forEach(thread -> thread.start());

        TimeUnit.SECONDS.sleep(3);
    }


    //懒汉式+ 有问题的优化
    @Test
    public void demo04() throws InterruptedException {

        IntStream.range(0,100000).mapToObj(i -> new Thread( () -> {
            Singletion3 singletion3 = Singletion3.get();
            singletion3.sout();
        }
        )).forEach(thread -> thread.start());

        TimeUnit.SECONDS.sleep(3);


    }

    //采用类加载机制实现懒汉式
    @Test
    public void demo05() throws InterruptedException {

        IntStream.range(0, 100000).mapToObj(i -> new Thread(() -> {
            Singletion4 singletion4 = Singletion4.get();
            singletion4.sout();
        }
        )).forEach(thread -> thread.start());

        TimeUnit.SECONDS.sleep(3);
    }
}
