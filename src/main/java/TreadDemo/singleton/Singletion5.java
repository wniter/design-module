/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Singletion5
 * Author:   Administrator
 * Date:     2020/3/21 16:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package TreadDemo.singleton;

import java.util.stream.IntStream;

/**
 * 〈通过枚举进行单例的设计〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/21
 * @since 1.0.0
 */
public class Singletion5 {
    private Singletion5() {
    }

    public static Singletion getInstance() {
        return SingletionFactory.INSANCE.getSingletion();
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).forEach(i ->
                new Thread(
                        () -> System.out.println(Singletion5.getInstance()),
                        String.valueOf(i)
                ).start()
        );
    }
}


enum SingletionFactory {
    INSANCE;

    private final Singletion singletion;

    SingletionFactory() {
        this.singletion = new Singletion();
    }

    public Singletion getSingletion() {
        return singletion;
    }
}

class Singletion {}
