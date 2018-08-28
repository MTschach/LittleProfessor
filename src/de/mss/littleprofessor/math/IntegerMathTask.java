package de.mss.littleprofessor.math;

import java.math.BigInteger;

public class IntegerMathTask extends MathTask {

   protected BigInteger intResult = null;


   public void setResult(BigInteger r) {
      this.intResult = r;
      this.setResult("" + r);
   }


   public BigInteger getResultAsInteger() {
      return this.intResult;
   }
}
