package TreadDemo.threadpool;

import java.util.LinkedList;

/**
 * Created by qd on 2019/1/6.
 */
public class LinkedRunnableQueue implements RunnableQueue {
    //任务添加策略
    private DenyPolicy denyPolicy;
    //存放任务的容器
    private LinkedList<Runnable> queue;
    //存放任务的最大个数
    private int limit;
    //供我们的任务添加策略使用
    private ThreadPool pool;

    public LinkedRunnableQueue(DenyPolicy denyPolicy ,int limit ,ThreadPool pool) {
        super();
        this.denyPolicy = denyPolicy;
        this.queue = new LinkedList<>();
        this.limit = limit;
        this.pool = pool;
    }

    @Override
    public void offer(Runnable runnable) {
        synchronized (queue) {
            if(queue.size() >= limit) {
                denyPolicy.reject(runnable, pool);
            }
            else {
                queue.addLast(runnable);
                queue.notifyAll();

            }
        }
    }

    @Override
    public Runnable take() throws InterruptedException {
        synchronized (queue) {
            while (queue.size() ==0) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            Runnable first = queue.removeFirst();
            return first;
        }
    }

    @Override
    public int size() {
        synchronized (queue) {
            return queue.size();
        }
    }


}
