package TreadDemo.threadpool;

/**
 * 构造线程的工厂
 */
public interface ThreadFactory {
    /**
     * 根据runnable去创建线程
     * @param runnable 根据他去创建线程
     * @return 创建的线程
     */
    Thread createThread(Runnable runnable);
}
