/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ActivationQueue
 * Author:   Administrator
 * Date:     2020/3/20 11:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package TreadDemo.active;

import java.util.LinkedList;

/**
 * 〈我们的容器〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/20
 * @since 1.0.0
 */
public class ActivationQueue {
    private int  MAX_METHOD_REQUEST_QUEUE_SIZE = 100;
    private LinkedList<MethodRequest> methodQueue;

    public ActivationQueue() {
        this.methodQueue = new LinkedList<MethodRequest>();
    }


    public synchronized void put(MethodRequest methodRequest) {
        while(methodQueue.size() >= 100) {
            try {
                methodQueue.wait();
            } catch (InterruptedException e) {

            }
        }
        this.methodQueue.addLast(methodRequest);
        this.notifyAll();

    }
    public synchronized MethodRequest take() {
        while(methodQueue.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        MethodRequest methodRequest = this.methodQueue.removeFirst();
        this.notifyAll();
        return methodRequest;

    }
}
