package edu.csc413.calculator.evaluator;
/**
 * Operand class used to represent an operand
 * in a valid mathematical expression.
 */
public class Operand {
  private int operandValue;

  /**
  * construct operand from string token.
  */  
  public Operand( String token ) {
    operandValue = Integer.parseInt(token);
  }

  /**
   * construct operand from integer
   */
  public Operand( int value ) {
    operandValue = value;
  }

  /**
   * return value of operand
   */
  public int getValue() {
    return operandValue;
  }

  /**
   * Check to see if given token is a valid
   * operand.
   */
  public static boolean check( String token ) {
    // I got found this https://stackoverflow.com/questions/40519580/trying-to-determine-if-a-string-is-an-integer
    // There was the try/catch  with parseInt() but I didn't like that one so I was inspired by this one

    for(int i = 0; i < token.length();i++) {
      if(Character.isDigit(token.charAt(i))) {
        continue;
      } else {
        return false;
      }
    }
    return true;
  }
}
