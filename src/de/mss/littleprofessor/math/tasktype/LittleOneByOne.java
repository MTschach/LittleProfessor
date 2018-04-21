package de.mss.littleprofessor.math.tasktype;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

import de.mss.littleprofessor.math.MathTask;
import de.mss.littleprofessor.plugin.Task;

public class LittleOneByOne extends IntegerTaskType {
   @Override
   public Task generateTask() {
      if ((new Random().nextInt() % 2) > 0)
         return generateDivisionTask();
      else
         return generateMultiplyTask();
   }
   
   
   
   protected Task generateMultiplyTask() {
      MathTask t = new MathTask();
      
      BigDecimal a = random(BigDecimal.TEN);
      BigDecimal b = random(BigDecimal.TEN);
      BigDecimal c = a.multiply(b);
      
      t.setTask(formatValue(a) + " * " + formatValue(b));
      t.setResult("" + formatValue(c));
      
      return t;
   }

   
   
   protected Task generateDivisionTask() {
      MathTask t = new MathTask();
      
      BigDecimal a = random(BigDecimal.TEN);
      if (a.equals(BigInteger.ZERO))
         a = BigDecimal.ONE;
      BigDecimal b = random(BigDecimal.TEN);
      BigDecimal c = a.multiply(b);
      
      t.setTask(formatValue(c) + " / " + formatValue(a));
      t.setResult("" + formatValue(b));

      return t;
   }

   
   @Override
   public String getTaskName()
   {
      return "Kleines 1x1";
   }

}
