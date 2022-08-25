package TreadDemo.TaskLifeCycle;

/**
 * 生命周期函数，来执行我们特定生命周期所需要执行的操作
 */
public interface TaskLifecycle<T> {
    //线程开始时的监控函数接口
    public void start(Thread thread);
    //线程运行d时的监控函数接口
    public void run(Thread thread);
    //线程结束时的监控函数
    public void end(Thread thread, T ret);
    //线程异常时的监控函数
    public void error(Thread thread, Exception e);

    public static class  EmptyTaskLifecycle<T> implements TaskLifecycle<T>{

        @Override
        public void start(Thread thread) {

        }

        @Override
        public void run(Thread thread) {

        }

        @Override
        public void end(Thread thread, T ret) {

        }

        @Override
        public void error(Thread thread, Exception e) {

        }
    }
}
