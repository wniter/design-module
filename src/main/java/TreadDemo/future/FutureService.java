package TreadDemo.future;


/**
 * 用于提交任务，提交任务有两种，一种不需要返回值，一种需要返回值
 */
public interface FutureService<IN,OUT> {
    //不需要返回值,他会返回一个future.get() == null 的结果对象
    Future<?> submit(Runnable runnable);
    //需要返回值
    Future<OUT> submit(Task<IN, OUT> task, IN args);

    //工厂方法
    static <IN,OUT> FutureService<IN,OUT> newFutureService() {
        return  new FutureServiceImpl<IN,OUT>();
    }
}
