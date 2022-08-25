/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Main
 * Author:   Administrator
 * Date:     2020/3/21 16:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package TreadDemo.activeobject;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/21
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {

        //创建10个线程执行
        new Thread(new Runnable() {

            public void run() {
                ActiveObject activeObject = ActiveObjectFactory.getActiveObject();
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "displayString");
                    activeObject.displayString("weijinhao");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {

            public void run() {
                ActiveObject activeObject = ActiveObjectFactory.getActiveObject();
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "displayString");
                    activeObject.displayString("weijinhao");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {

            public void run() {
                System.out.println(Thread.currentThread().getName() + "makeString");
                ActiveObject activeObject = ActiveObjectFactory.getActiveObject();
                while (true) {
                    Result w = activeObject.makeString(10, 'w');
                    System.out.println(w.getResultValue());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
 
            public void run() {
                ActiveObject activeObject = ActiveObjectFactory.getActiveObject();
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "makeString");
                    Result w = activeObject.makeString(10, 'w');
                    System.out.println(w.getResultValue());

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
