package de.mss.littleprofessor.math.tasktype;

import java.math.BigInteger;

import de.mss.littleprofessor.math.IntegerMathTask;
import de.mss.littleprofessor.math.Operation;
import de.mss.littleprofessor.math.RandomNumberGenerator;
import de.mss.littleprofessor.plugin.Task;

public class Multiply extends IntegerTaskType {

   @Override
   public Task generateTask() {
      IntegerMathTask t = new IntegerMathTask();

      BigInteger a = RandomNumberGenerator.nextNumber(lowerLimit, upperLimit);
      BigInteger b = RandomNumberGenerator.nextNumber(lowerLimit, upperLimit);
      BigInteger c = a.multiply(b);

      while (c.compareTo(lowerLimit) < 0 || c.compareTo(upperLimit) > 0) {
         b = RandomNumberGenerator.nextNumber(lowerLimit, upperLimit);
         c = a.multiply(b);
      }

      t.setLastOperation(Operation.MULTIPLY);

      t.setTask(formatValue(a) + " * " + formatValue(b));
      t.setResult(c);

      return t;
   }


   @Override
   public String getTaskName() {
      return "Multiplikation";
   }

}
