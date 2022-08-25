package DesignModule.InterpreterPattern;

/**
 * 创建实现了上述接口的实体类。
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data){
        this.data = data;
    }
    public boolean interpret(String context) {
        if(context.contains(data)){
            return true;
        }
        return false;
    }
}