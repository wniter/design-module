package TreadDemo.singleton;

/**
 * 懒汉式
 * 分析：会不会有并发问题，分别从三个角度来讨论，1 原子性 2 有序性 3 可见性
 *  我们先从第一个原子性进行分析
 *  因为其不是原子性的，当线程1判断 singletion = null ,然后进去，这时线程2也判断singletion = null
 *  也进去，这时就不是单例的了。
 *
 *  解决办法：
 *  使用synchronized
 */
public class Singletion2 {

    private static Singletion2 singletion = null;

    public  void sout() {
        System.out.println(singletion.hashCode());
    }

    public  static synchronized Singletion2 get() {
        if(singletion == null) {
            singletion = new Singletion2();
        }
        return singletion;
    }
/*
    public  static Singletion2 get() {
        if(singletion == null) {
            singletion = new Singletion2();
        }
        return singletion;
    }*/
}
