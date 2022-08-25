package TreadDemo.singleton;

/**
 * 懒汉式 + double check + volatile
 * 分析：会不会有并发问题，分别从三个角度来讨论，1 原子性 2 有序性 3 可见性
 *  上面这种的话这个函数就是串行化的了，效率不是很高，我们进行改写
 *  demo01这种方式我们来分析一下，第一 原子性 没有问题 第二 有序性 但是有序性就有问题了
 *  如果是先构建的Singletion3，在构建的成员变量name passworld的话，就会有空指针异常
 *
 *  解决办法 ： 在加上volatile关键字
 */
public class Singletion3 {

    private static volatile Singletion3 singletion = null;

    private String name;
    private String passworld;

    Singletion3() {
        name = "weijinhao";
        passworld = "123456";
    }

    public  void sout() {
        System.out.println(singletion.hashCode() + "   " + name + "    " + passworld);

    }
    //demo01
    public  static  Singletion3 get() {
        if(singletion == null) {
            synchronized (Singletion3.class) {
                if (singletion == null)
                    //通过valatile 的有序性来解决对象还没有创建完成就把引用给抛出去了
                    singletion = new Singletion3();
            }
        }
        return singletion;
    }



}
