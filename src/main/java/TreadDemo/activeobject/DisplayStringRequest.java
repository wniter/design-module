/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DisplayStringRequest
 * Author:   Administrator
 * Date:     2020/3/20 11:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package TreadDemo.activeobject;

/**
 * 〈DisplayString方法的抽象封装实现〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/20
 * @since 1.0.0
 */
public class DisplayStringRequest extends MethodRequest {
    private String text;

    public DisplayStringRequest(FutureResult futureResult, Servant servant, String text) {
        super(futureResult, servant);
        this.text = text;
    }
    @Override
    public void execute() {
        this.getServant().displayString(this.text);
    }
}
