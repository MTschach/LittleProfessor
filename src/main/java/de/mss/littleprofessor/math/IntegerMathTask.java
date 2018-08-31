package de.mss.littleprofessor.math;

import java.math.BigInteger;

public class IntegerMathTask extends MathTask {

   protected BigInteger lastResult    = BigInteger.ZERO;
   protected Operation  lastOperation = Operation.ADDITION;


   public void setResult(BigInteger r) {
      this.lastResult = r;
      this.result = "" + r;
   }


   public void setLastOperation(Operation o) {
      this.lastOperation = o;
   }


   public Operation getLastOperation() {
      return this.lastOperation;
   }


   public BigInteger getLastIntegerResult() {
      return this.lastResult;
   }


   @Override
   public void setGivenResult(String r) {
      super.setGivenResult(r.trim());
   }
}
