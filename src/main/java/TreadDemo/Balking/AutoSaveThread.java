package TreadDemo.Balking;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 自动保存的线程
 */
public class AutoSaveThread extends Thread {
    private Document document;

    public AutoSaveThread(Document document) {
        super("自动保存");
        this.document = document;
    }

    @Override
    public void run() {
        while (true) {
            //定时保存
            try {
                document.save();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}