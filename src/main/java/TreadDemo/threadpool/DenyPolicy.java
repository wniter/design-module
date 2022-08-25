package TreadDemo.threadpool;

/**
 * Created by qd on 2019/1/6.
 */
public interface DenyPolicy {
    public void reject(Runnable runnable, ThreadPool pool);

    //该拒绝策略将会直接丢弃任务
    class DiscardDenyPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool pool) {

        }
    }
    //该拒绝策略会抛出异常
    class AbortDenyPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool pool) {
            throw new DenyRunnableException("the runnable" + runnable + "will be abort.");
        }
    }
    //该拒绝策略会在用户的工作线程中执行任务
    class RunnerDenyPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool pool) {
            if(pool.isShutdown() != true) {
                runnable.run();
            }
        }
    }


}
