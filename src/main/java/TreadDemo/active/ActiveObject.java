/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ActiveObject
 * Author:   Administrator
 * Date:     2020/3/20 11:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package TreadDemo.active;

/**
 * 〈我们方法调用的门户接口〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/20
 * @since 1.0.0
 */
public interface ActiveObject {

    Result makeString(int count, char fillChar);
    void displayString(String text);
}
