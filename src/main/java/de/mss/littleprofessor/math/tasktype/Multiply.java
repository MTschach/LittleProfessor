package de.mss.littleprofessor.math.tasktype;

import de.mss.littleprofessor.math.IntegerMathTask;
import de.mss.littleprofessor.plugin.Task;

public class Multiply extends IntegerTaskType {

   @Override
   public Task generateTask() {
      return IntegerMathTask.generateMultiplyTask(lowerLimit, upperLimit);
   }


   @Override
   public String getTaskName() {
      return "Multiplikation";
   }

}
