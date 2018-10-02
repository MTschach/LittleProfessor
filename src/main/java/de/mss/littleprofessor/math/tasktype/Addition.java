package de.mss.littleprofessor.math.tasktype;

import de.mss.littleprofessor.math.IntegerMathTask;
import de.mss.littleprofessor.plugin.Task;

public class Addition extends IntegerTaskType {

   @Override
   public Task generateTask() {
      return IntegerMathTask.generateAdditionTask(lowerLimit, lowerLimit);
   }


   @Override
   public String getTaskName() {
      return "Addition";
   }
}
