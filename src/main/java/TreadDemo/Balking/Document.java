package TreadDemo.Balking;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 文档类
 */
public class Document {
    //与磁盘进行交互
    private FileWriter fileWriter;
    //是否编辑
    private boolean changed = false;
    //缓存中的内容
    private List<String> content = new ArrayList<String>();

    static private AutoSaveThread autoSaveThread ;

    public Document(String path , String name) throws IOException {
        this.fileWriter = new FileWriter(new File(path,name));
    }

    //创建文档
    public static Document create(String path , String name) throws IOException {
        Document document = new Document(path, name);
        autoSaveThread = new AutoSaveThread(document);
        autoSaveThread.start();
        return document;
    }



    //保存内容
    public void save() throws IOException {
        synchronized (this) {
            //////////////////////////Balking的核心思想就在这/////////////////////////
            /////////////////////////一个简单的if语句包含了一切///////////////////////////
            //如果没有编辑就return
            if(!changed) {
                return ;
            }
            System.out.println(Thread.currentThread().getName() + "execute the save action");
            //核心业务
            {
                for (String s : content) {
                    fileWriter.write(s);
                    fileWriter.write("\r\n");
                }
                fileWriter.flush();
                content.clear();
                this.changed = false;
            }
        }
    }
    //编辑内容
    public void edit(String value) {
        synchronized (this) {
            changed = true;
            content.add(value);
        }

    }
    //关闭文档
    public void close() throws IOException {
        //对自动保存线程进行打断
        autoSaveThread.interrupt();
        fileWriter.close();
    }
}
