package de.mss.littleprofessor.math.tasktype;

import java.math.BigInteger;

import de.mss.littleprofessor.math.IntegerMathTask;
import de.mss.littleprofessor.math.Operation;
import de.mss.littleprofessor.plugin.RandomNumberGenerator;
import de.mss.littleprofessor.plugin.Task;

public class LittleOneByOne extends IntegerTaskType {

   @Override
   public Task generateTask() {
      BigInteger a = RandomNumberGenerator.nextNumber(BigInteger.ZERO, BigInteger.TEN);
      BigInteger b = RandomNumberGenerator.nextNumber(BigInteger.ZERO, BigInteger.TEN);
      BigInteger c = a.multiply(b);

      IntegerMathTask t = new IntegerMathTask();

      if (BigInteger.TEN.compareTo(RandomNumberGenerator.nextNumber(BigInteger.ZERO, BigInteger.valueOf(20))) < 0) {
         t.setLastOperation(Operation.MULTIPLY);
         t.setTask(formatValue(a) + " * " + formatValue(b));
         t.setResult(c);
      }
      else {
         t.setLastOperation(Operation.DIVIDE);
         t.setTask(formatValue(c) + " / " + formatValue(b));
         t.setResult(a);
      }

      return t;
   }


   @Override
   public String getTaskName() {
      return "Kleines 1x1";
   }

}
