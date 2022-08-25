package TreadDemo.readWriteLock;

/**
 * Created by qd on 2019/1/5.
 */
public class WriteLock implements Lock {
    private ReadWriteLockImpl readWriteLock;

    public WriteLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        //如果当前有读的或者有等待的写 则等待
        synchronized (readWriteLock.getMUTEX()) {
            //等待写++
            readWriteLock.incrementWaittingWriters();
            try {

                while (readWriteLock.getReadingReaders() > 0 || readWriteLock.getWritingWriters() > 0) {
                    System.out.println("------------------------");
                    System.out.println("ReadingReaders  " + readWriteLock.getReadingReaders());
                    System.out.println("WaittingWriters  " + readWriteLock.getWaittingWriters());
                    System.out.println("WritingWriters  " + readWriteLock.getWritingWriters());
                    System.out.println("------------------------");
                    readWriteLock.getMUTEX().wait();
                }
            }finally {
                //如果成功获取锁的话我们进行--
                readWriteLock.decrementWaittingWriters();
            }
            readWriteLock.incrementWritingWriters();

        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMUTEX()) {

            readWriteLock.decrementWritingWriters();
            readWriteLock.setPreferWirter(false);
            readWriteLock.getMUTEX().notifyAll();
        }
    }
}
