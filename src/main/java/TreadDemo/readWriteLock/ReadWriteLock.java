package TreadDemo.readWriteLock;

/**
 * Created by qd on 2019/1/5.
 */
public interface ReadWriteLock {
    //创建reader锁
    Lock readLock();
    //创建writer锁
    Lock writeLock();
    //获取当前有多少线程执行写操作
    int getWritingWriters();
    //获取当前有多少线程等在等待获取写锁
    int getWaittingWriters();
    //获取当前有多少线程正在等待获取reader锁
    int getReadingReaders();

    //工厂方法，创建ReadWriteLock
    static ReadWriteLock readWriteLock() {
        return new ReadWriteLockImpl();
    }

    /**
     * 工厂方法,创建ReadWriteLock,并且传入preferWriter
     * @param preferWriter 是否有偏向读或写先执行
     * @return
     */
    static ReadWriteLock readWriteLock(boolean preferWriter) {
        return new ReadWriteLockImpl(preferWriter);
    }
}
