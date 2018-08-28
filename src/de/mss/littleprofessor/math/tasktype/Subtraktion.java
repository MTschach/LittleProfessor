package de.mss.littleprofessor.math.tasktype;

import java.math.BigInteger;

import de.mss.littleprofessor.math.MathTask;
import de.mss.littleprofessor.math.MathTools;
import de.mss.littleprofessor.plugin.Task;
import de.mss.littleprofessor.plugin.TaskType;

public class Subtraktion extends TaskType {

   @Override
   public Task generateTask() {
      MathTask t = new MathTask();

      BigInteger a = MathTools.random(this.lowerLimit, this.upperLimit);
      BigInteger b = MathTools.random(a, this.upperLimit);
      BigInteger c = a.add(b);

      t.setTask(c + " - " + b);
      t.setResult("" + a);

      return t;
   }
}
