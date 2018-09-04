package de.mss.littleprofessor.math;

import java.math.BigDecimal;

import de.mss.littleprofessor.plugin.Task;

public class MathTask extends Task {

   protected BigDecimal lastResult = BigDecimal.ZERO;


   public void setResult(BigDecimal r) {
      this.lastResult = r;
      this.result = "" + r;
   }


   public BigDecimal getLastResult() {
      return this.lastResult;
   }


   @Override
   public void setGivenResult(String r) {
      super.setGivenResult(r.trim());
   }
}
