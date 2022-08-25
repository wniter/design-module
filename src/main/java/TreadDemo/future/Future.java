package TreadDemo.future;

/**
 *任务的监控
 */
public interface Future<T> {
    //返回计算结果，如果没有就等待
    public T get() throws InterruptedException;

    //判断任务是否已经执行完成
    public boolean done();
}
