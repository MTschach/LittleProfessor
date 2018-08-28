package de.mss.littleprofessor.math.tasktype;

import java.math.BigInteger;

import de.mss.littleprofessor.math.IntegerMathTask;
import de.mss.littleprofessor.math.MathTools;
import de.mss.littleprofessor.plugin.Task;
import de.mss.littleprofessor.plugin.TaskType;

public class SimpleAddSubChain extends TaskType {

   protected int chainLength = 2;


   public SimpleAddSubChain(int cl) {
      setChainLength(cl);
   }


   public void setChainLength(int cl) {
      this.chainLength = cl;
   }


   public int getChainLength() {
      return this.chainLength;
   }


   @Override
   public Task generateTask() {
      IntegerMathTask t = new IntegerMathTask();


      return t;
   }


   private IntegerMathTask generateTask(IntegerMathTask t, int lengthToGo) {
      IntegerMathTask ret = t;
      if (ret == null) {
         ret = new IntegerMathTask();
         ret.setResult(MathTools.random(lowerLimit, upperLimit));
         ret.setTask("" + ret.getResultAsInteger());
      }

      if (lengthToGo <= 2) {
         BigInteger b = BigInteger.ZERO;
         if (MathTools.randomOperationIsAddition()) {
            b = MathTools.random(lowerLimit, upperLimit.subtract(ret.getResultAsInteger()));
            ret.setResult(ret.getResultAsInteger().add(b));
            ret.setResult(ret.getTask() + " + " + b);
         }
         else {
            b = MathTools.random(lowerLimit, ret.getResultAsInteger());
            ret.setResult(ret.getResultAsInteger().subtract(b));
            ret.setResult(ret.getTask() + " - " + b);
         }

         return ret;
      }

      return generateTask(ret, --lengthToGo);
   }

}
