package DesignModule.BuilderPattern;

/**
 * 创建实现 Packing 接口的实体类。
 */
public class Wrapper implements Packing {


    public String pack() {
        return "Wrapper";
    }
}