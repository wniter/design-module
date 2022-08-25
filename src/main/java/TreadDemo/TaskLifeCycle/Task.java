package TreadDemo.TaskLifeCycle;

/**
 * 我们要运行的核心任务接口
 */
public interface Task<T> {
    public T task();
}
