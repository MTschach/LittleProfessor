package de.mss.littleprofessor.math.tasktype;

import java.math.BigInteger;

import de.mss.littleprofessor.math.IntegerMathTask;
import de.mss.littleprofessor.math.Operation;
import de.mss.littleprofessor.math.RandomNumberGenerator;
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

      t.setLastOperation(Operation.MULTIPLY);

      t.setTask(formatValue(c) + " / " + formatValue(b));
      t.setResult(a);

      return t;
   }


   @Override
   public String getTaskName() {
      return "Division";
   }
}
