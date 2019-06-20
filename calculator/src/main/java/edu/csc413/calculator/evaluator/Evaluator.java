package edu.csc413.calculator.evaluator;



import edu.csc413.calculator.operators.Operator;

import java.util.Objects;
import java.util.Stack;
import java.util.StringTokenizer;

public class Evaluator {
  private Stack<Operand> operandStack;
  private Stack<Operator> operatorStack;
  private StringTokenizer tokenizer;
  private static final String DELIMITERS = "+-*^/() ";

  public Evaluator() {
    operandStack = new Stack<>();
    operatorStack = new Stack<>();
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Evaluator evaluator = (Evaluator) o;
    return Objects.equals(operandStack, evaluator.operandStack) &&
            Objects.equals(operatorStack, evaluator.operatorStack) &&
            Objects.equals(tokenizer, evaluator.tokenizer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operandStack, operatorStack, tokenizer);
  }

  public void process() {
    Operand op2 = operandStack.pop();
    Operand op1 = operandStack.pop();
    operandStack.push(operatorStack.pop().execute(op1,op2));
  }

  public int eval(String expression ) {
    String token;

    // The 3rd argument is true to indicate that the delimiters should be used
    // as tokens, too. But, we'll need to remember to filter out spaces.
    this.tokenizer = new StringTokenizer( expression, DELIMITERS, true );


    while ( this.tokenizer.hasMoreTokens() ) {
      // filter out spaces
      if ( !( token = this.tokenizer.nextToken() ).equals( " " )) {
        // check if token is an operand push to stack
        if ( Operand.check( token )) {
          operandStack.push( new Operand( token ));
        } else {
          if ( ! Operator.check( token )) {
            System.out.println( "*****invalid token******" );
            throw new RuntimeException("*****invalid token******");
          }
        if ( Operator.check(token) && operatorStack.empty() && !token.equals("(")  && !token.equals(")") ){
          operatorStack.push(Operator.getOperator(token));
        } else if ( Operator.check(token)  &&
                    !operatorStack.empty() &&
                    Operator.getOperator(token).priority() > operatorStack.peek().priority() ) {
          operatorStack.push(Operator.getOperator(token));
        } else if ( token.equals("(") ) {
          operatorStack.push(Operator.getOperator(token));
        } else if ( token.equals(")") ) {
          while( operatorStack.peek() != Operator.getOperator("(")) {
            process();
          }
          operatorStack.pop();
        } else {
          process();
          operatorStack.push(Operator.getOperator(token));
        }

        }
      }
    }

    while(!operatorStack.empty()) {
      process();
    }

    return operandStack.pop().getValue();
  }
}
