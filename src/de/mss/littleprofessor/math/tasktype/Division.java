package de.mss.littleprofessor.math.tasktype;

import java.math.BigInteger;

import de.mss.littleprofessor.math.MathTask;
import de.mss.littleprofessor.math.MathTools;
import de.mss.littleprofessor.plugin.Task;
import de.mss.littleprofessor.plugin.TaskType;

public class Division extends TaskType {

   @Override
   public Task generateTask() {
      MathTask t = new MathTask();

      BigInteger a = MathTools.random(this.lowerLimit, this.upperLimit);
      BigInteger b = MathTools.random(BigInteger.ZERO, this.upperLimit.divide(a));
      if (b.equals(BigInteger.ZERO))
         b = BigInteger.ONE;

      BigInteger c = a.multiply(b);

      t.setTask(c + " / " + b);
      t.setResult("" + a);

      return t;
   }
}
