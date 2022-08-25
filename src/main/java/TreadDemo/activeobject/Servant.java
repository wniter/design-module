/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Servant
 * Author:   Administrator
 * Date:     2020/3/20 11:20
 * Description: \
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package TreadDemo.activeobject;

/**
 * 〈我们真正做事情的核心逻辑〉<br>
 * 〈\〉
 *
 * @author Administrator
 * @create 2020/3/20
 * @since 1.0.0
 */
public class Servant implements ActiveObject{

    @Override
    public Result makeString(int count, char fillChar) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0 ; i < count ; i ++) {
            stringBuffer.append(fillChar);
        }
        return new RealResult(stringBuffer.toString());
    }

    @Override
    public void displayString(String text) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        System.out.println(text);
    }
}
