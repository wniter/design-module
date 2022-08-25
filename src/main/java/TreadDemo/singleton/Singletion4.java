package TreadDemo.singleton;

/**
 * 使用类加载器相关技术实现懒加载
 * 分析：会不会有并发问题，分别从三个角度来讨论，1 原子性 2 有序性 3 可见性
 *  我们前面说过 类的初始化是线程安全的
 *
 */
public class Singletion4 {
    private String name;
    private String passworld;

    Singletion4() {
        name = "weijinhao";
        passworld = "123456";
    }

    public  void sout() {
        System.out.println(hashCode() + "   " + name + "    " + passworld);
    }
    //demo01
    public  static Singletion4 get() {
      return Holder.singletion4;
    }


    //这一步是关键
   private static  class Holder {
        private static Singletion4 singletion4 = new Singletion4();
   }

}
