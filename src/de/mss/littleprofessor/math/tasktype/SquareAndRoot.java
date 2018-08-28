package de.mss.littleprofessor.math.tasktype;

import java.math.BigInteger;

import de.mss.littleprofessor.math.MathTask;
import de.mss.littleprofessor.math.MathTools;
import de.mss.littleprofessor.plugin.Task;
import de.mss.littleprofessor.plugin.TaskType;

public class SquareAndRoot extends TaskType {

   @Override
   public Task generateTask() {
      MathTask t = new MathTask();

      BigInteger a = MathTools.random(BigInteger.ZERO, new BigInteger("20"));
      BigInteger c = a.multiply(a);

      if (Math.random() < 0.5d) {
         t.setTask(a + " * " + a);
         t.setResult("" + c);
      }
      else {
         t.setTask(c + " / " + a);
         t.setResult("" + a);
      }

      return t;
   }
}
