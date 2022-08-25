package TreadDemo.future;

import java.util.concurrent.TimeUnit;

/**
 * 测试 future 设计模式
 */
public class Demo {
    //使用无返回值的任务提交
    public static void main1(String[] args) throws InterruptedException {
        FutureService<Object, Object> service = FutureService.newFutureService();
        Future<?> submit = service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        submit.get();
        System.out.println("任务的执行状态:" + submit.done());

    }
    //使用有返回值的任务提交
    public static void main(String[] args) throws InterruptedException {
        FutureService<Integer, Integer> service = FutureService.<Integer, Integer>newFutureService();
        Future<Integer> future = service.submit((arg) -> {
            //累加10次
            for (int i = 0; i < 10; i++) {
                arg++;
                sleep();
            }
            return arg;
        }, 0);
        Integer integer = future.get();
        System.out.println(integer);
    }

    //睡觉
    public static void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 }
