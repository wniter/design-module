/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: RealResult
 * Author:   Administrator
 * Date:     2020/3/20 11:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package TreadDemo.active;

/**
 * 〈我们真是返回的结果封装〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/20
 * @since 1.0.0
 */
public class RealResult implements Result {
    private final Object ret;

    public RealResult(Object ret) {
        this.ret = ret;
    }

    @Override
    public Object getResultValue() {
        return ret;
    }
}
