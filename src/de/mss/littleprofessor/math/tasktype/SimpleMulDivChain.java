package de.mss.littleprofessor.math.tasktype;

import java.math.BigInteger;

import de.mss.littleprofessor.math.IntegerMathTask;
import de.mss.littleprofessor.math.MathTools;
import de.mss.littleprofessor.plugin.Task;
import de.mss.littleprofessor.plugin.TaskType;

public class SimpleMulDivChain extends TaskType {

   protected int chainLength = 2;


   public SimpleMulDivChain(int cl) {
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
            b = MathTools.random(lowerLimit, upperLimit.divide(ret.getResultAsInteger()));
            if (BigInteger.ZERO.compareTo(b) == 0)
               b = BigInteger.ONE;
            ret.setResult(ret.getResultAsInteger().multiply(b));
            ret.setResult(ret.getTask() + " * " + b);
         }
         else {
            BigInteger[] result;
            do {
               b = MathTools.random(lowerLimit, ret.getResultAsInteger());
               if (BigInteger.ZERO.compareTo(b) == 0)
                  b = BigInteger.ONE;

               result = ret.getResultAsInteger().divideAndRemainder(b);
            }
            while (BigInteger.ZERO.compareTo(result[1]) != 0);
            ret.setResult(ret.getResultAsInteger().divide(b));
            ret.setResult(ret.getTask() + " / " + b);
         }

         return ret;
      }

      return generateTask(ret, --lengthToGo);
   }

}
