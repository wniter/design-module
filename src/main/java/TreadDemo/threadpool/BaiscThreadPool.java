package TreadDemo.threadpool;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * Created by qd on 2019/1/6.
 */
public class BaiscThreadPool extends Thread implements ThreadPool {
    private int maxSize;
    private int coreSize;
    private int initSize;
    private int activeAccount;
    private boolean shutdown = false;
    private RunnableQueue runnableQueue;
    private Queue<ThreadTask> queue;
    private DenyPolicy denyPolicy;
    private ThreadFactory threadFactory;
    private long keepAliveTime;
    private TimeUnit timeUnit;

    private static DenyPolicy DEFAULT_DENYPOLICY = new DenyPolicy.DiscardDenyPolicy();
    private static ThreadFactory DEFAULT_THREADFACTORY = new DefaultThreadFactory();

    //因为线程池的构造函数过于复杂所以我们就从抽取出了几个重要的参数进行用户设定，剩下的使用默认
    //值
    public BaiscThreadPool(int maxSize, int coreSize, int initSize,int queueSize) {
        this(maxSize,coreSize,initSize,10, TimeUnit.SECONDS,queueSize);
    }

    private BaiscThreadPool(int maxSize, int coreSize, int initSize,
                            long keepAliveTime, TimeUnit timeUnit, int queueSize) {
        super();
        this.maxSize = maxSize;
        this.coreSize = coreSize;
        this.initSize = initSize;
        this.runnableQueue = new LinkedRunnableQueue(DEFAULT_DENYPOLICY,queueSize,this);
        this.queue = new ArrayDeque<>();
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
        this.threadFactory=this.DEFAULT_THREADFACTORY;
//调用init函数开启维护线程池线程的线程，并先初始化一定数量的线程
        this.init();
    }
    private void init() {
        //开启线程池的维护线程
        start();
        //初始化一定数量的线程
        for(int i = 0;i < this.initSize;i++) {
            newThread();
        }

    }
    //在线程池中创建工作线程
    private void newThread() {
        //这是一个Runnable的实现类，他的run方法就是不断的从this.runnableQueue 任务队列中读取任
        //务，并执行run
        InternalTask internalTask = new InternalTask(this.runnableQueue);
        Thread thread = this.threadFactory.createThread(internalTask);
        ThreadTask threadTask = new ThreadTask(thread,internalTask);
        queue.offer(threadTask);
        this.activeAccount ++;
        //开启线程
        thread.start();
    }
    //从线程池中删除工作线程
    private void removeThread() {
        ThreadTask threadTask = queue.remove();
        threadTask.internalTask.stop();
        this.activeAccount --;
    }
    //这是我们的thread的run方法，他的作用是当维护线程池的稳定，当线程不够使用时创建线程，当线程
    //空闲数多时回收线程
    @Override
    public void run() {

        while(this.shutdown != true && !this.isInterrupted()) {
            try {
                timeUnit.sleep(keepAliveTime);
            } catch (InterruptedException e) {
                this.shutdown = true;
                break;
            }
            synchronized (this) {
                if(this.shutdown) {
                    break;
                }
                //当前任务中有任务没有处理,并且当前线程数没有达到核心线程数,创建线程
                if(this.runnableQueue.size() >0 && this.activeAccount < this.coreSize) {
                    for (int i = this.activeAccount; i < this.coreSize; i++) {
                        newThread();
                    }
                    continue;
                }
                //当前任务中有任务没有处理，并且当前线程数没有达到上限,创建线程
                if(this.runnableQueue.size() > 0 && this.activeAccount < this.maxSize) {
                    for (int i = this.activeAccount; i < this.maxSize; i++) {
                        newThread();
                    }
                }

                //当前任务队列中没有任务要处理，进行线程的回收，回收到核心线程数即可
                if(this.runnableQueue.size() == 0 && this.activeAccount > this.coreSize) {
                    for (int i = this.coreSize; i < this.activeAccount; i++) {
                        removeThread();
                    }
                }
            }
        }
    }
    //将我们要执行的任务添加到任务队列中去
    @Override
    public void execute(Runnable runnable) throws Exception {
        if(this.shutdown ==false) {
            this.runnableQueue.offer(runnable);
        }else {
            throw new Exception("thread pool is destory.");
        }

    }
    //关闭线程池
    @Override
    public void shutdown() {
        synchronized (this) {
            if(this.shutdown) {
                return ;
            }
            this.shutdown = true;
            this.queue.forEach((threadTask) -> {
                threadTask.internalTask.stop();
                threadTask.thread.interrupt();
            });
            this.interrupt();
        }
    }

    @Override
    public boolean isShutdown() {
        return this.shutdown;
    }

    @Override
    public int getMaxSize() {
        return this.maxSize;
    }

    @Override
    public int getInitSize() {
        return this.initSize;
    }

    @Override
    public int getCoreSize() {
        return this.coreSize;
    }

    @Override
    public int getActiveSize() {
        return this.activeAccount;
    }

    @Override
    public int getQueueSize() {
        return this.runnableQueue.size();
    }

    public  class ThreadTask {
        private Thread thread;
        private InternalTask internalTask;
        public ThreadTask(Thread thread, InternalTask internalTask) {
            super();
            this.thread = thread;
            this.internalTask = internalTask;
        }

    }
    //我们自定义的创建线程的工厂，实际上new Thread（）函数会更为复杂
    static public class DefaultThreadFactory implements ThreadFactory{

        @Override
        public Thread createThread(Runnable runnable) {
            return new Thread(runnable);
        }

    }
}
