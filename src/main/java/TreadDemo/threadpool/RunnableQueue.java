package TreadDemo.threadpool;

/**
 * 任务队列
 */
public interface RunnableQueue {
    /**
     * 将任务提交到任务队列中
     * @param runnable 用户提交的任务
     */
    public void offer(Runnable runnable);
    /**
     * 供工作线程使用从队列中获取Runnable
     * @return 从队列中获取Runnable
     * @throws InterruptedException
     */
    public Runnable take() throws InterruptedException;
    /**
     * 获取任务队列中任务的数量
     * @return 任务队列中任务的数量
     */
    public int size();

}
