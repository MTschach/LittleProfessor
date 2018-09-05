package de.mss.littleprofessor.math.tasktype;

import java.math.BigInteger;

import de.mss.littleprofessor.math.IntegerMathTask;
import de.mss.littleprofessor.math.Operation;
import de.mss.littleprofessor.plugin.RandomNumberGenerator;
import de.mss.littleprofessor.plugin.Task;

public class Addition extends IntegerTaskType {

   @Override
   public Task generateTask() {
      IntegerMathTask t = new IntegerMathTask();

      BigInteger a = RandomNumberGenerator.nextNumber(lowerLimit, upperLimit);
      BigInteger b = RandomNumberGenerator.nextNumber(a, upperLimit);
      BigInteger c = a.add(b);

      t.setLastOperation(Operation.ADDITION);

      t.setTask(formatValue(a) + " + " + formatValue(b));
      t.setResult(c);

      return t;
   }


   @Override
   public String getTaskName() {
      return "Addition";
   }
}
