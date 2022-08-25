package TreadDemo.readWriteLock;

/**
 * 我们真正的锁的接口
 */
public interface Lock {
    //加锁
    void lock() throws InterruptedException;
    //释放锁
    void unlock();
}
