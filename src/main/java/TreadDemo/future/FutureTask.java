package TreadDemo.future;

/**
 * Created by qd on 2019/1/6.
 */
public class FutureTask<T> implements Future<T> {
    //计算结果
    private T value;
    //任务是否完成
    private boolean isDone = false;
    //定义对象锁
    private final Object lock = new Object();

    //获取返回值,如果还没有执行完成就等待
    @Override
    public T get() throws InterruptedException {
        synchronized (lock) {
            //如果任务没有完成就进入等待
            while (isDone == false) {
                lock.wait();
            }
            return this.value;
        }

    }
    //判断任务是否完成,因为只有一个线程需要修改他所以没有并发的问题
    @Override
    public boolean done() {
        return this.isDone;
    }

    //自定义方法 用来设置结果到该对象中
    protected void finish(T  result) {
        synchronized (lock) {
            //  如果已经执行完成了，再次调用就直接返回
            if (this.isDone) {
                return;
            }
            this.isDone = true;
            this.value = result;
            //唤醒所有等待
            this.lock.notifyAll();
        }
    }

}
