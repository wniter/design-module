/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: FutureResult
 * Author:   Administrator
 * Date:     2020/3/20 11:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package TreadDemo.active;


/**
 * 〈异步返回值实现〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/20
 * @since 1.0.0
 */
public class FutureResult implements Result {

    private Result realReslut;
    private boolean hasRet = false;


    public synchronized void setRealReslut(Result realReslut) {
        this.hasRet = true;
        this.realReslut = realReslut;
        this.notifyAll();
    }

    @Override
    public synchronized Object getResultValue() {
        while (hasRet != true) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realReslut.getResultValue();
    }
}
