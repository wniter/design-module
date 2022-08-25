package TreadDemo.singleThreadExecution;

public class Demo {
    public static void main(String[] args) {
        TableWare left = new TableWare("刀子");
        TableWare reight = new TableWare("叉子");
        TableWarePair tableWarePair = new TableWarePair(left, reight);
        new EatNoodleThread(tableWarePair,"A").start();
        new EatNoodleThread(tableWarePair,"S").start();
    }
}
