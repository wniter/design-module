/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SchedulerThread
 * Author:   Administrator
 * Date:     2020/3/20 11:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package TreadDemo.active;

/**
 * 〈我们后台线程的封装，实现添加方法执行，和后台只想方法线程〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/20
 * @since 1.0.0
 */
public class SchedulerThread extends Thread {
    private ActivationQueue activationQueue;

    public SchedulerThread(ActivationQueue activationQueue) {
        this.activationQueue = activationQueue;
    }

    //将方法抽象封装放入容器
    public void invoke(MethodRequest requestMethod) {
        activationQueue.put(requestMethod);
    }

    @Override
    public void run() {
        while (true) {
            MethodRequest take = this.activationQueue.take();
            take.execute();
        }
    }
}
