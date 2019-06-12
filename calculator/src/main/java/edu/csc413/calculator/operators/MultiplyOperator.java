package edu.csc413.calculator.operators;
import edu.csc413.calculator.evaluator.Operand;

public class MultiplyOperator extends Operator {
    public int priority() {
        return 2;
    }

    // Does the proper math operation returns operand
    public  Operand execute(Operand op1, Operand op2 ) {
        Operand product = new Operand(op1.getValue() * op2.getValue());
        return product;
    }
}
