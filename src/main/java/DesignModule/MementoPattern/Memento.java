package DesignModule.MementoPattern;

/**
 * 创建 Memento 类。
 */
public class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}