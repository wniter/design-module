package TreadDemo.Balking;

import java.io.IOException;
import java.util.Scanner;

/**
 * document编辑环境
 *
 */
public class DocumentEditThread extends Thread{
    private String name;
    private String path;
    private Scanner scanner = new Scanner(System.in);

    public DocumentEditThread(String name, String path) {
        super("手动保存");
        this.name = name;
        this.path = path;
    }

    @Override
    public void run() {
        Document doc = null;
        try {
            doc = Document.create(path,name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int time = 0;
        //模拟键盘输入
        while(true) {

            if(scanner.hasNext()) {
                String s = scanner.next();
                try {
                    if ("quit".equals(s)) {
                        doc.close();
                        break;
                    }
                    doc.edit(s);
                    if (time == 5) {
                        doc.save();
                        time = 0;
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                time++;
            }

        }
    }
}