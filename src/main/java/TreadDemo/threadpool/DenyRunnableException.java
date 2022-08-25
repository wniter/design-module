package TreadDemo.threadpool;

/**
 * Created by qd on 2019/1/6.
 */
public class DenyRunnableException  extends RuntimeException {
    public DenyRunnableException(String message) {
        super(message);
    }
}
