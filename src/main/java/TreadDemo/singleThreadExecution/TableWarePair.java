package TreadDemo.singleThreadExecution;

/**
 * Created by qd on 2019/1/5.
 */
public class TableWarePair {
    private TableWare left;
    private TableWare reight;

    public TableWarePair(TableWare left, TableWare reight) {
        this.left = left;
        this.reight = reight;
    }

    public TableWare getLeft() {
        return left;
    }

    public TableWare getReight() {
        return reight;
    }
}
