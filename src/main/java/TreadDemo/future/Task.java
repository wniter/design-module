package TreadDemo.future;

/**
 * 我们的具体业务接口
 * @param <IN> 输入数据类型
 * @param <OUT> 输出数据类型
 */
public interface Task<IN,OUT> {
 public OUT get(IN arg);
}
