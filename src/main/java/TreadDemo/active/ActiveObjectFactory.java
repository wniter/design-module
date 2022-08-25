/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ActiveObjectFactory
 * Author:   Administrator
 * Date:     2020/3/20 11:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package TreadDemo.active;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/20
 * @since 1.0.0
 */
public class ActiveObjectFactory {
    private static  ActiveObjectProxy activeObjectProxy;

    static {
        createActiveObject();
    }
    private ActiveObjectFactory(){

    }
    public static void createActiveObject() {
        //将各个组件组织起来
        ActivationQueue activeQueue = new ActivationQueue();
        SchedulerThread schedulerThread = new SchedulerThread(activeQueue);
        //开启线程
        schedulerThread.start();


        Servant servant = new Servant();

        activeObjectProxy = new ActiveObjectProxy(schedulerThread, servant);

    }

    public static ActiveObject getActiveObject() {
        return activeObjectProxy;
    }


}
