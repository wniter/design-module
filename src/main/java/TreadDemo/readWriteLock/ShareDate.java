package TreadDemo.readWriteLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 我们用来共享的数据
 */
public class ShareDate {
    //数据的存放点
    private List<Character> list = new ArrayList<>();
    private ReadWriteLockImpl readWriteLock = new ReadWriteLockImpl();
    //读锁
    Lock readLock = readWriteLock.readLock();
    //写锁
    Lock writeLock = readWriteLock.writeLock();

    //读取
    public char[] readDate() throws InterruptedException {
        try {
            //加锁
            readLock.lock();
            char[] c = new char[list.size()];
            for (int i = 0; i < list.size(); i++) {
                c[i] = list.get(i);
            }
            sleep(1);
            return c;
        }finally {
            readLock.unlock();
        }

    }

    //写入
    public void writeDate(char a) throws InterruptedException {
        try {
            //加锁
            writeLock.lock();
            this.list.add(a);
            sleep(2);

        }finally {
            writeLock.unlock();
        }
    }

    private void sleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
