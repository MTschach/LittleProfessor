package de.mss.littleprofessor.math.tasktype;

import java.math.BigInteger;

import de.mss.littleprofessor.math.IntegerMathTask;
import de.mss.littleprofessor.math.Operation;
import de.mss.littleprofessor.math.RandomNumberGenerator;
import de.mss.littleprofessor.plugin.Task;

public class RootAndSquare extends IntegerTaskType {

   @Override
   public Task generateTask() {
      BigInteger a = RandomNumberGenerator.nextNumber(BigInteger.ZERO, BigInteger.valueOf(20));
      BigInteger c = a.multiply(a);

      IntegerMathTask t = new IntegerMathTask();

      if (BigInteger.TEN.compareTo(RandomNumberGenerator.nextNumber(BigInteger.ZERO, BigInteger.valueOf(20))) < 0) {
         t.setLastOperation(Operation.MULTIPLY);
         t.setTask(formatValue(a) + "²");
         t.setResult(c);
      }
      else {
         t.setLastOperation(Operation.DIVIDE);
         t.setTask("\u221A" + formatValue(c));
         t.setResult(a);
      }

      return t;
   }


   @Override
   public String getTaskName() {
      return "Quadrate und Wurzeln";
   }

}
