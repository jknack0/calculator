package edu.csc413.calculator.operators;
import edu.csc413.calculator.evaluator.Operand;

public class PowerOperator extends Operator {
    public int priority() {
        return 3;
    }

    // Does the proper math operation returns operand
    public  Operand execute(Operand op1, Operand op2 ){
        int base = 1;
        for(int i = 1; i < op2.getValue(); i++) {
            base *= op1.getValue();
        }
        Operand exponent = new Operand(base);
        return exponent;
    }

}
