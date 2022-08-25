/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MakeStringRequest
 * Author:   Administrator
 * Date:     2020/3/20 11:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package TreadDemo.activeobject;

/**
 * 〈我们makeString方法的核心抽象实现〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/20
 * @since 1.0.0
 */
public class MakeStringRequest extends MethodRequest{
    private int count;
    private char fillChar;

    public MakeStringRequest(FutureResult futureResult, Servant servant, int count, char fillChar) {
        super(futureResult, servant);
        this.count = count;
        this.fillChar = fillChar;
    }
    @Override
    public void execute() {
        //执行我们的核心逻辑，并将结果封装到异步返回值中去
        Result reslut = this.getServant().makeString(count, fillChar);
        this.getFutureResult().setRealReslut(reslut);

    }
}
