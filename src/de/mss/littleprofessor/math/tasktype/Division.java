package de.mss.littleprofessor.math.tasktype;

import java.math.BigDecimal;
import java.math.BigInteger;

import de.mss.littleprofessor.math.MathTask;
import de.mss.littleprofessor.plugin.Task;

public class Division extends IntegerTaskType {
   @Override
   public Task generateTask() {
      MathTask t = new MathTask();
      
      BigDecimal ul = new BigDecimal(this.upperLimit.intValue());
      
      BigDecimal a = random(ul);
      if (a.equals(BigInteger.ZERO))
         a = BigDecimal.ONE;
      BigDecimal b = random(ul.divide(a));
      BigDecimal c = a.multiply(b);
      
      t.setTask(formatValue(c) + " / " + formatValue(a));
      t.setResult("" + formatValue(b));

      return t;
   }
   
   
   @Override
   public String getTaskName()
   {
      return "Division";
   }
}
