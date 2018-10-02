package de.mss.littleprofessor.math.tasktype;

import de.mss.littleprofessor.math.IntegerMathTask;
import de.mss.littleprofessor.plugin.Task;

public class Division extends IntegerTaskType {

   @Override
   public Task generateTask() {
      return IntegerMathTask.generateDivideTask(lowerLimit, upperLimit);
   }


   @Override
   public String getTaskName() {
      return "Division";
   }
}
