package TreadDemo.threadpool;

/**
 * 线程池的接口
 */
public interface ThreadPool {
    /*
	 * 提交任务到线程池
	 */
    public void execute(Runnable runnable) throws Exception;

    /**
     * 关闭线程池
     */
    public void shutdown();

    /**
     * 判断当前线程池是否被关闭
     * @return 线程池的关闭状态
     */
    public boolean isShutdown();

    /**
     * 获取线程池的最大数
     * @return 线程池的最大数
     */

    public int getMaxSize();

    /**
     * 获取线程池的初始化大小
     * @return 线程池的初始化大小
     */
    public int getInitSize();
    /**
     * 获取线程池的核心线程数
     * @return 获取线程池的核心线程数
     */
    public int getCoreSize();
    /**
     * 获取线程池的活跃线程数
     * @return 获取线程池的活跃线程数
     */
    public int getActiveSize();

    /**
     * 获取任务队列的大小
     * @return 任务队列的大小
     */
    public int getQueueSize();


}
