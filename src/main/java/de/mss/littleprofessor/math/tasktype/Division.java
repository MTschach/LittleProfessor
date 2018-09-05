package de.mss.littleprofessor.math.tasktype;

import java.math.BigInteger;

import de.mss.littleprofessor.math.IntegerMathTask;
import de.mss.littleprofessor.math.Operation;
import de.mss.littleprofessor.plugin.RandomNumberGenerator;
import de.mss.littleprofessor.plugin.Task;

public class Division extends IntegerTaskType {

   @Override
   public Task generateTask() {
      IntegerMathTask t = new IntegerMathTask();

      BigInteger a = RandomNumberGenerator.nextNumber(lowerLimit, upperLimit);
      BigInteger b = RandomNumberGenerator.nextNumber(lowerLimit, upperLimit);
      if (b.compareTo(BigInteger.ZERO) == 0)
         b = BigInteger.ONE;
      BigInteger c = a.multiply(b);

      while (c.compareTo(lowerLimit) < 0 || c.compareTo(upperLimit) > 0) {
         b = RandomNumberGenerator.nextNumber(lowerLimit, upperLimit);
         if (b.compareTo(BigInteger.ZERO) == 0)
            b = BigInteger.ONE;
         c = a.multiply(b);
      }

      t.setLastOperation(Operation.DIVIDE);

      int r = RandomNumberGenerator.nextNumber(BigInteger.ZERO, BigInteger.valueOf(2)).intValue();

      if (BigInteger.TEN.compareTo(upperLimit) <= 0 || r == 0) {
         t.setTask(formatValue(c) + " / " + formatValue(b));
         t.setResult(a);
      }
      else if (r == 1) {
         t.setTask(formatValue(a) + " * ? =  " + formatValue(c));
         t.setResult(b);
      }
      else {
         t.setTask(formatValue(c) + " / ? = " + formatValue(a));
         t.setResult(b);
      }


      return t;
   }


   @Override
   public String getTaskName() {
      return "Division";
   }
}
