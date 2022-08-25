package TreadDemo.singleThreadExecution;

/**
 * 我们的餐具类
 */
public class TableWare {
    //餐具名称
    private String name;

    public TableWare(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
