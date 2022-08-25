package TreadDemo.nochang;



import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 测试不可变对象是否有并发问题
 */
public class Demo {
    private static final IntegerAccumulator accumulator = new IntegerAccumulator(0);
    public static void main(String[] args) {
        IntStream.range(0,10).mapToObj(i -> new Thread(() -> {
            //我们的业务实现
            int acc = 0;

            while (true) {
               //......

            }

        })).forEach(thread -> thread.start());
    }

    static public void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
