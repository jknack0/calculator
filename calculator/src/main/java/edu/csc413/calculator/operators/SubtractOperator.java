package edu.csc413.calculator.operators;
import edu.csc413.calculator.evaluator.Operand;

public class SubtractOperator extends Operator {
    public int priority() {
        return 1;
    }

    // Does the proper math operation returns operand
    public  Operand execute(Operand op1, Operand op2 ){
        Operand difference = new Operand(op1.getValue() - op2.getValue());
        return difference;
    }
}
