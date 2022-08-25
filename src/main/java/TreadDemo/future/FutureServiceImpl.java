package TreadDemo.future;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 任务的提交
 */
public class FutureServiceImpl<IN,OUT> implements FutureService<IN,OUT> {
    //为执行的线程指定名字前缀（为线程起一个特殊的名字是一个非常好的编程习惯）
    //前缀
    private final static String FUTURE_THREAD_PREFIX = "FUTURE-";
    private final AtomicInteger nextCounter = new AtomicInteger(0);

    //返回下一个线程的完整名字
    private String getNextName() {
        return FUTURE_THREAD_PREFIX + nextCounter.getAndIncrement();
    }

    //调用一个线程去执行任务，我们在当前线程中可以得到他是否执行完成的状态

    /**
     *
     * @param runnable 核心业务
     * @return 仅仅是单纯的监控任务的执行状态
     */
    @Override
    public Future<?> submit(Runnable runnable) {

        FutureTask<Object> futureTask = new FutureTask<>();
        new Thread(() -> {
            //执行核心业务
            runnable.run();
            //任务执行完成调用finsh
            futureTask.finish(null);

        },this.getNextName()).start();
        return futureTask;
    }
    //调用一个线程去执行任务，我们在当前线程中可以得到他是否执行完成的状态

    /**
     *
     * @param task 执行的核心任务
     * @param args 输入参数
     * @return 获取任务执行状态和结果的数据结构
     */
    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN args) {
        FutureTask<OUT> futureTask = new FutureTask<>();
        new Thread(() -> {
            OUT out = task.get(args);
            futureTask.finish(out);
        },this.getNextName()).start();
        return futureTask;
    }
}
