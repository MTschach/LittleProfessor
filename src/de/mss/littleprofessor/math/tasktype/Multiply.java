package de.mss.littleprofessor.math.tasktype;

import java.math.BigDecimal;
import java.math.BigInteger;

import de.mss.littleprofessor.math.MathTask;
import de.mss.littleprofessor.plugin.Task;

public class Multiply extends IntegerTaskType {
   @Override
   public Task generateTask() {
      MathTask t = new MathTask();
      
      BigDecimal ul = new BigDecimal(this.upperLimit.intValue());
      
      BigDecimal a = random(ul);
      BigDecimal b = random(ul.divide(a));
      BigDecimal c = a.multiply(b);
      
      t.setTask(formatValue(a) + " * " + formatValue(b));
      t.setResult("" + formatValue(c));
      
      return t;
   }
   
   
   @Override
   public String getTaskName()
   {
      return "Multiplikation";
   }

}
