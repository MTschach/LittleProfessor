package de.mss.littleprofessor.math.tasktype;

import java.math.BigInteger;

import de.mss.littleprofessor.math.IntegerMathTask;
import de.mss.littleprofessor.math.Operation;
import de.mss.littleprofessor.plugin.RandomNumberGenerator;
import de.mss.littleprofessor.plugin.Task;

public class Chain extends IntegerTaskType {

   @Override
   public Task generateTask() {
      return generateChainTask(null, 1);
   }


   private Task generateChainTask(BigInteger operand, int depth) {
      IntegerMathTask task;

      if (depth < 0) {
         task = new IntegerMathTask();
         task.setLastOperation(Operation.NONE);
         task.setResult(operand);
         task.setTask(formatValue(operand));
         return task;
      }

      if (depth == 0 && RandomNumberGenerator.nextNumber(BigInteger.ZERO, BigInteger.valueOf(1l)).intValue() == 1) {
         task = new IntegerMathTask();
         task.setLastOperation(Operation.NONE);
         task.setResult(operand);
         task.setTask(formatValue(operand));
         return task;
      }

      int op = RandomNumberGenerator.nextNumber(BigInteger.ZERO, BigInteger.valueOf(3l)).intValue();

      switch (op) {
         case 1:
            task = IntegerMathTask.generateSubtractionTask(lowerLimit, upperLimit, operand);
            break;

         case 2:
            task = IntegerMathTask.generateMultiplyTask(lowerLimit, upperLimit, operand);
            break;

         case 3:
            task = IntegerMathTask.generateDivideTask(lowerLimit, upperLimit, operand);
            break;

         case 0:
         default:
            task = IntegerMathTask.generateAdditionTask(lowerLimit, upperLimit, operand);
            break;
      }

      IntegerMathTask subTask1 = (IntegerMathTask)generateChainTask(task.getOperand1(), depth - 1);
      IntegerMathTask subTask2 = (IntegerMathTask)generateChainTask(task.getOperand2(), depth - 1);

      task
            .setTask(
                  getSubTask(subTask1, task.getLastOperation())
                        + " "
                        +
                        task.getLastOperation().getOperation()
                        + " "
                        +
                        getSubTask(subTask2, task.getLastOperation()));

      return task;
   }


   private String getSubTask(IntegerMathTask subtask, Operation op) {
      if (subtask.getLastOperation().getOperationLevel() == 0)
         return subtask.getTask();

      else if (subtask.getLastOperation().getOperationLevel() < op.getOperationLevel())
         return "(" + subtask.getTask() + ")";

      else
         return subtask.getTask();
   }


   @Override
   public String getTaskName() {
      return "Kettenaufgabe";
   }

}
