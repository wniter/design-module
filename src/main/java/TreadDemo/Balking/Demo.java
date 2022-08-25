package TreadDemo.Balking;

/**
 * balking设计模式的测试
 */
public class Demo {
    public static void main(String[] args) {
        new DocumentEditThread("tmp","E:\\git_repository\\thread").start();
    }
}
