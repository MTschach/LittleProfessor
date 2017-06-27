package de.mss.littleprofessor.math;

import de.mss.littleprofessor.plugin.TaskType;
import de.mss.littleprofessor.math.tasktype.*;

public enum TaskTypeEnum {
   
   addition     (new Addition(),          1),
   subtraction  (new Subtraktion(),       2),
   multiply     (new Multiplikation(),    3),
   divide       (new Division(),          4);
   
   protected TaskType taskType      = null;
   protected int difficulty         = 0;
   
   TaskTypeEnum(TaskType t, int d) {
      this.taskType     = t;
      this.difficulty   = d;
   }
   
   public TaskType getTaskType()    { return this.taskType; }
   public int getDifficulty()       { return this.difficulty; }
}
