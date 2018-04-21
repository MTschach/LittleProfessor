package de.mss.littleprofessor.math.tasktype;

import java.math.BigDecimal;
import java.util.Random;

import de.mss.littleprofessor.math.MathTask;
import de.mss.littleprofessor.plugin.Task;

public class TrippleAdditionSubtraction extends IntegerTaskType {
   @Override
   public Task generateTask() {
      MathTask t = new MathTask();
      
      
      if (new Random().nextInt(2) == 0)
      {
         BigDecimal a = random(this.upperLimit);
         BigDecimal b = random(this.upperLimit.subtract(a));
         BigDecimal c = random(a.add(b));
         
         BigDecimal d = a.add(b).subtract(c);
         
         t.setTask(formatValue(a) + " + " + formatValue(b) + " - " + formatValue(c));
         t.setResult("" + formatValue(d));
      }
      else
      {
         BigDecimal a = random(this.upperLimit);
         BigDecimal b = random(a);
         BigDecimal c = random(this.upperLimit.subtract(a.subtract(b)));
         
         BigDecimal d = a.subtract(b).add(c);
         
         t.setTask(formatValue(a) + " - " + formatValue(b) + " + " + formatValue(c));
         t.setResult("" + formatValue(d));
      }
      
      
      return t;
   }
   
   
   @Override
   public String getTaskName()
   {
      return "Addition und Subtraktion 3 Operanden";
   }
}
