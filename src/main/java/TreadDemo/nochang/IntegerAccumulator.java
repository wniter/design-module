package TreadDemo.nochang;

/**
 * 我们要实现的不可变对象
 */
public final class IntegerAccumulator {
    private final int value;

    public IntegerAccumulator(int value) {
        this.value = value;
    }
    //我们每次都创建一个新的对象
    private IntegerAccumulator(IntegerAccumulator accumulator,int value) {
        this.value = accumulator.getValue() + value;
    }

    public int getValue() {
        return value;
    }
    //每次都返回不同的对象
    public IntegerAccumulator add(int value) {
       return  new IntegerAccumulator(this,value);
    }

}
