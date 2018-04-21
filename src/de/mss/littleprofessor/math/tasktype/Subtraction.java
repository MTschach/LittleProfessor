package de.mss.littleprofessor.math.tasktype;

import java.math.BigDecimal;

import de.mss.littleprofessor.math.MathTask;
import de.mss.littleprofessor.plugin.Task;

public class Subtraction extends IntegerTaskType {
   @Override
   public Task generateTask() {
      MathTask t = new MathTask();
      
      BigDecimal range = this.upperLimit.subtract(this.lowerLimit);
      BigDecimal a = random(range);
      BigDecimal b = random(a);
      a = a.add(this.lowerLimit);
      b = b.add(this.lowerLimit);
      BigDecimal c = b.subtract(a);
      
      t.setTask(formatValue(a) + " - " + formatValue(b));
      t.setResult("" + formatValue(c));
      
      return t;
   }
   
   
   @Override
   public String getTaskName()
   {
      return "Subtraktion";
   }

}
