package de.mss.littleprofessor.math.tasktype;

import java.math.BigInteger;

import de.mss.littleprofessor.math.IntegerMathTask;
import de.mss.littleprofessor.math.Operation;
import de.mss.littleprofessor.math.RandomNumberGenerator;
import de.mss.littleprofessor.plugin.Task;

public class Subtraction extends IntegerTaskType {

   @Override
   public Task generateTask() {
      IntegerMathTask t = new IntegerMathTask();

      BigInteger a = RandomNumberGenerator.nextNumber(lowerLimit, upperLimit);
      BigInteger b = RandomNumberGenerator.nextNumber(a, upperLimit);
      BigInteger c = a.add(b);

      t.setLastOperation(Operation.SUBTRACTION);

      if (BigInteger.TEN.compareTo(upperLimit) <= 0 || isMoreThan50Percent()) {
         t.setTask(formatValue(c) + " - " + formatValue(b));
         t.setResult(a);
      }
      else {
         t.setTask(formatValue(a) + " + ? = " + formatValue(c));
         t.setResult(b);
      }

      return t;
   }


   @Override
   public String getTaskName() {
      return "Subtraktion";
   }
}
