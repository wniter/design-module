package TreadDemo.singleton;

/**
 * 饿汉式
 * 分析：会不会有并发问题，分别从三个角度来讨论，1 原子性 2 有序性 3 可见性
 *  private static Singletion1 singletion = new Singletion1(); 这段程序发生在类的初始化当中，
 *  类的初始化函数不存在并发问题，所以没有并发问题
 */
public class Singletion1 {
    private static Singletion1 singletion = new Singletion1();

    public  void sout() {
        System.out.println("hello world");
    }

    public  static Singletion1 get() {
        return singletion;
    }
}
