package TreadDemo.singleThreadExecution;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class EatNoodleThread extends Thread {
    private String name;
    private TableWarePair tableWarePair;

    public EatNoodleThread(TableWarePair tableWarePair, String name) {
        super();
        this.tableWarePair = tableWarePair;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            eat();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void eat() {
        synchronized (tableWarePair) {
                System.out.println(name + tableWarePair.getLeft().toString() + tableWarePair.getReight().toString() + "吃饭喽");
        }
    }
}
