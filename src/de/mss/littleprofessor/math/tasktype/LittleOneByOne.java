package de.mss.littleprofessor.math.tasktype;

import java.math.BigInteger;

import de.mss.littleprofessor.math.MathTask;
import de.mss.littleprofessor.math.MathTools;
import de.mss.littleprofessor.plugin.Task;
import de.mss.littleprofessor.plugin.TaskType;

public class LittleOneByOne extends TaskType {

   @Override
   public Task generateTask() {
      MathTask t = new MathTask();

      BigInteger a = MathTools.random(BigInteger.ZERO, BigInteger.TEN);
      BigInteger b = MathTools.random(BigInteger.ZERO, BigInteger.TEN);
      BigInteger c = a.multiply(b);

      if (Math.random() < 0.5d) {
         t.setTask(a + " * " + b);
         t.setResult("" + c);
      }
      else {
         t.setTask(c + " / " + b);
         t.setResult("" + a);
      }

      return t;
   }
}
