package TreadDemo.readWriteLock;

/**
 * Created by qd on 2019/1/5.
 */
public class ReadLock  implements Lock{
    private ReadWriteLockImpl readWriteLock;

    public ReadLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }


    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMUTEX()) {
            //如果当前写的人数>0 或者 当前等待写的人数>0并且优先写的话就进行等待
            while (readWriteLock.getWritingWriters() > 0 || (readWriteLock.getWritingWriters() > 0 && readWriteLock.isPreferWirter())) {

                readWriteLock.getMUTEX().wait();
            }
            //进行增加
            readWriteLock.increamentReadingReaders();
        }
    }

    @Override
    public void unlock() {
        //
        synchronized (readWriteLock.getMUTEX()) {
            readWriteLock.decreamentReadingReaders();
            readWriteLock.setPreferWirter(true);
            readWriteLock.getMUTEX().notifyAll();
        }
    }
}
