/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ActiveObjectProxy
 * Author:   Administrator
 * Date:     2020/3/20 11:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * weijinhao           2020/03/21           1.0              普通方法的代理对象
 */
package TreadDemo.active;

/**
 * 〈我们通过代理进项装饰着设计模式，封装method放入queue〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/20
 * @since 1.0.0
 */
public class ActiveObjectProxy implements ActiveObject{
    private SchedulerThread schedulerThread;
    private Servant servant;


    public ActiveObjectProxy(SchedulerThread schedulerThread,Servant servant) {
        this.schedulerThread = schedulerThread;
        this.servant = servant;
    }

    @Override
    public Result makeString(int count, char fillChar) {
        FutureResult futureResult = new FutureResult();
        MakeStringRequest makeStringRequest = new MakeStringRequest(futureResult, servant, count, fillChar);
        schedulerThread.invoke(makeStringRequest);
        return futureResult;
    }

    @Override
    public void displayString(String text) {
        DisplayStringRequest displayStringRequest = new DisplayStringRequest(new FutureResult(),servant,text);
        schedulerThread.invoke(displayStringRequest);

    }
}
