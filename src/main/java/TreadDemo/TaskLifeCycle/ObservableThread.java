package TreadDemo.TaskLifeCycle;

/**
 * 一个完整的 带有监控的线程
 */
public class ObservableThread<T> extends Thread implements  Observable {
    //成员变量
    private Cycle cycle;
    private Task<T> task;
    private TaskLifecycle<T> taskLifecycle;//生命周期函数

    /**
     *
     * @param task 我们要运行的任务
     */
    public ObservableThread(Task<T> task) {
        //使用我们默认的监听函数
        new ObservableThread(task,new TaskLifecycle.EmptyTaskLifecycle<T>());
    }

    /**
     *
     * @param task 我们要运行的任务
     * @param taskLifecycle 我们的监控函数
     */
    public ObservableThread(Task<T> task, TaskLifecycle<T> taskLifecycle) {
        super();
        this.task = task;
        this.taskLifecycle = taskLifecycle;
        this.cycle = Cycle.ready;
    }

    /**
     *
     * @return 获取当前线程的状态
     */
    @Override
    public Cycle getCycle() {
        return cycle;
    }

    @Override
    public void run() {
        //开始
        update(Cycle.start,null,null);
        try {
            //运行
            update(Cycle.run,null,null);
            T ret = this.task.task();
            //结束
            update(Cycle.end,ret,null);
        }catch (Exception e) {
            //抛异常
            update(Cycle.run,null,e);
        }
    }

    /**
     * 调用我们的监控函数
     * @param cycle 处在生命阶段
     * @param ret 返回值
     * @param e 异常
     */
    private void update(Cycle cycle, T ret, Exception e) {
        //首先判断cycle函数是否为空
        if(taskLifecycle == null) {
            return ;
        }
        switch (cycle) {
            case start:
                this.cycle = Cycle.start;
                this.taskLifecycle.start(currentThread());
                break;
            case run:
                this.cycle = Cycle.run;
                this.taskLifecycle.run(currentThread());
                break;
            case end:
                this.cycle = Cycle.end;
                this.taskLifecycle.end(currentThread(),ret);
                break;
            case error:
                this.cycle = Cycle.error;
                this.taskLifecycle.error(currentThread(),e);
        }
    }
}
