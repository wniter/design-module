package TreadDemo.threadpool;

/**
 * Created by qd on 2019/1/6.
 */
public class InternalTask implements Runnable {
    private final RunnableQueue runnableQueue;

    private boolean running = true;

    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    public void stop() {
        this.running = false;
    }
    //他的作用就是不断的从任务队列中进行取出，并执行任务的run方法
    @Override
    public void run() {
        while(running != false && Thread.currentThread().isInterrupted() != true) {
            try {
                Runnable runnable = runnableQueue.take();
                runnable.run();
            }catch ( InterruptedException e) {
                this.running = false;
                break;
            }
        }
    }


}
