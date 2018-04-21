package de.mss.littleprofessor.math.tasktype;

import java.math.BigDecimal;

import de.mss.littleprofessor.math.MathTask;
import de.mss.littleprofessor.plugin.Task;

public class TrippleSubtraction extends IntegerTaskType {
   @Override
   public Task generateTask() {
      MathTask t = new MathTask();
      
      BigDecimal range = this.upperLimit.subtract(this.lowerLimit);
      BigDecimal a = random(range);
      BigDecimal b = random(a);
      BigDecimal c = random(a.subtract(b));
      a = a.add(this.lowerLimit);
      b = b.add(this.lowerLimit);
      c = c.add(this.lowerLimit);
      BigDecimal d = a.subtract(b).subtract(c);
      
      t.setTask(formatValue(a) + " - " + formatValue(b) + " - " + formatValue(c));
      t.setResult("" + formatValue(d));
      
      return t;
   }
   
   
   @Override
   public String getTaskName()
   {
      return "Subtraktion 3 Operanden";
   }

}
