package de.mss.littleprofessor.math.tasktype;

import java.math.BigInteger;

import de.mss.littleprofessor.math.IntegerMathTask;
import de.mss.littleprofessor.math.Operation;
import de.mss.littleprofessor.math.RandomNumberGenerator;
import de.mss.littleprofessor.plugin.Task;

public class AddSubChain extends IntegerTaskType {

   @Override
   public Task generateTask() {
      int maxChainLength = 2;

      if (BigInteger.valueOf(20).compareTo(upperLimit) >= 0)
         maxChainLength = 3;
      else if (BigInteger.valueOf(20).compareTo(upperLimit) < 0)
         maxChainLength = 10;

      int chainLength = RandomNumberGenerator.nextNumber(BigInteger.valueOf(2), BigInteger.valueOf(maxChainLength)).intValue();

      return generateChainTask(null, chainLength);
   }


   private Task generateChainTask(IntegerMathTask task, int chainLength) {

      if (task == null) {
         task = new IntegerMathTask();
         task.setResult(RandomNumberGenerator.nextNumber(lowerLimit, upperLimit));
         task.setTask(formatValue(task.getLastIntegerResult()));
         return generateChainTask(task, --chainLength);
      }
      else if (chainLength <= 0) {
         return task;
      }
      else if (RandomNumberGenerator.nextNumber(BigInteger.ZERO, BigInteger.ONE).intValue() == 0) {
         task.setLastOperation(Operation.ADDITION);
         BigInteger b = RandomNumberGenerator.nextNumber(lowerLimit, upperLimit.subtract(task.getLastIntegerResult()));
         task.setResult(task.getLastIntegerResult().add(b));
         task.setTask(task.getTask() + " + " + formatValue(b));
         return generateChainTask(task, --chainLength);
      }
      else {
         task.setLastOperation(Operation.SUBTRACTION);
         BigInteger b = RandomNumberGenerator.nextNumber(lowerLimit, task.getLastIntegerResult());
         task.setResult(task.getLastIntegerResult().subtract(b));
         task.setTask(task.getTask() + " - " + formatValue(b));
         return generateChainTask(task, --chainLength);
      }
   }


   @Override
   public String getTaskName() {
      return "Kettenaufgabe Addition/Subtraktion";
   }

}
