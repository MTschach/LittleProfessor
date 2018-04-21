package de.mss.littleprofessor.math.tasktype;

import java.math.BigDecimal;

import de.mss.littleprofessor.math.MathTask;
import de.mss.littleprofessor.plugin.Task;

public class TrippleAddition extends IntegerTaskType {
   @Override
   public Task generateTask() {
      MathTask t = new MathTask();
      
      BigDecimal range = this.upperLimit.subtract(this.lowerLimit);
      BigDecimal a = random(range);
      BigDecimal b = random(range.subtract(a));
      BigDecimal c = random(range.subtract(a.add(b)));
      a = a.add(this.lowerLimit);
      b = b.add(this.lowerLimit);
      BigDecimal d = c.add(a).add(b);
      
      t.setTask(formatValue(a) + " + " + formatValue(b) + " + " + formatValue(c));
      t.setResult("" + formatValue(d));
      
      return t;
   }
   
   
   @Override
   public String getTaskName()
   {
      return "Addition 3 Operanden";
   }
}
