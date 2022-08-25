package TreadDemo.TaskLifeCycle;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class Demo {
    @Test
    public void demo01() throws InterruptedException {
        new ObservableThread(new Task<Integer>() {
            @Override
            public Integer task()  {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hehhah");
                return 10 / 2;

            }
        },
                new TaskLifecycle<Integer>() {
                    @Override
                    public void start(Thread thread) {
                        System.out.println(thread.getId() + "is start");
                    }

                    @Override
                    public void run(Thread thread) {
                        System.out.println(thread.getId() + "is run");
                    }

                    @Override
                    public void end(Thread thread, Integer ret) {
                        System.out.println(thread.getId() + "is end" + "ret is" + ret);
                    }

                    @Override
                    public void error(Thread thread, Exception e) {
                        System.out.println(thread.getId() + "is error" + "e is" + e.getMessage());
                    }
                }
        ).start();
        TimeUnit.SECONDS.sleep(10);

    }
}
