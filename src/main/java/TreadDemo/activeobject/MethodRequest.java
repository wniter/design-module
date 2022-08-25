/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MethodRequest
 * Author:   Administrator
 * Date:     2020/3/20 11:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package TreadDemo.activeobject;

/**
 * 〈单个方法的抽象封装〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/20
 * @since 1.0.0
 */
public abstract class MethodRequest {
    private FutureResult futureResult;
    private final Servant servant;

    public MethodRequest(FutureResult futureResult, Servant servant) {
        this.futureResult = futureResult;
        this.servant = servant;
    }

    public abstract void execute();


    public FutureResult getFutureResult() {
        return futureResult;
    }

    public Servant getServant() {
        return servant;
    }
}
