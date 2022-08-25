package TreadDemo.readWriteLock;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 测试读写锁
 *
 */
public class Demo {

    static String text = "abcdefghigklmnopqrstuvwxyz";
    static ShareDate date = new ShareDate();
    public static void main(String[] args) throws InterruptedException {
        //写的线程
        IntStream.range(0,2).mapToObj(i -> new Thread(() -> {
            //
            char[] chars = text.toCharArray();

            for (char aChar : chars) {
                try {
                    date.writeDate(aChar);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        })).forEach(thread -> thread.start());

        //读的线程
        IntStream.range(0,5).mapToObj(i -> new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(date.readDate());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        })).forEach(thread -> thread.start());
    }
}
