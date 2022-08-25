package TreadDemo.readWriteLock;

/**
 * Created by qd on 2019/1/5.
 */
public class ReadWriteLockImpl implements ReadWriteLock {
    private final Object MUTEX = new Object();
    //当前有多少个线程正在写入
    private int writtingWriters = 0;
    //当前有多少个线程正在等待写入
    private  int waittingWriters = 0;
    //当前有多少个线程正在read
    private int readingRreaders = 0;
    //read或write的偏好设置
    private boolean preferWirter;

    public ReadWriteLockImpl() {
        this(true);
    }

    public ReadWriteLockImpl(boolean preferWirter) {
        this.preferWirter = preferWirter;
    }

    @Override
    public Lock readLock() {
        return new ReadLock(this);
    }

    @Override
    public Lock writeLock() {
        return new WriteLock(this);
    }
    //使写线程数量增加
    void incrementWritingWriters() {
        this.writtingWriters ++;
    }
    //使等待线程数量增加
    void incrementWaittingWriters() {
        this.waittingWriters ++;
    }
    //使读取线程数量增加
    void increamentReadingReaders() {
        this.readingRreaders ++;
    }
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
    //使写线程数量增加
    void decrementWritingWriters() {
        this.writtingWriters --;
    }
    //使等待线程数量增加
    void decrementWaittingWriters() {
        this.waittingWriters --;
    }
    //使读取线程数量增加
    void decreamentReadingReaders() {
        this.readingRreaders --;
    }

    @Override
    public int getWritingWriters() {
        return this.writtingWriters;
    }

    @Override
    public int getWaittingWriters() {
        return this.waittingWriters;
    }

    @Override
    public int getReadingReaders() {
        return this.readingRreaders;
    }
    //获取对象锁
    Object getMUTEX() {
        return this.MUTEX;
    }
    //设置和获取偏好锁
    public boolean isPreferWirter() {
        return preferWirter;
    }

    public void setPreferWirter(boolean preferWirter) {
        this.preferWirter = preferWirter;
    }
}
