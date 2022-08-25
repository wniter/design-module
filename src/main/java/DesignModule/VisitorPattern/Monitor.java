package DesignModule.VisitorPattern;

public class Monitor  implements ComputerPart {


    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}