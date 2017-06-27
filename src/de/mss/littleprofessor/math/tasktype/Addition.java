package de.mss.littleprofessor.math.tasktype;

import java.math.BigInteger;

import de.mss.littleprofessor.math.MathTask;
import de.mss.littleprofessor.plugin.Task;
import de.mss.littleprofessor.plugin.TaskType;

public class Addition extends TaskType {
   @Override
   public Task generateTask() {
      MathTask t = new MathTask();
      
      BigInteger range = this.upperLimit.subtract(this.lowerLimit);
      BigInteger a = range.multiply(new BigInteger("" +(long) Math.random()));
      BigInteger c = range.subtract(a).add(BigInteger.ONE).multiply(new BigInteger("" +(long) Math.random()));
      BigInteger b = c.subtract(a).subtract(this.lowerLimit);
      a = a.subtract(this.lowerLimit);
      c = c.subtract(lowerLimit);
      
      t.setTask(a + " + " + b);
      t.setResult("" + c);
      
      return t;
   }
}
