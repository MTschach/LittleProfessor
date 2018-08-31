package de.mss.littleprofessor.math.tasktype;

import java.math.BigDecimal;
import java.math.BigInteger;

import de.mss.littleprofessor.math.IntegerMathTask;
import de.mss.littleprofessor.math.MathTask;
import de.mss.littleprofessor.math.Operation;
import de.mss.littleprofessor.math.RandomNumberGenerator;
import de.mss.littleprofessor.plugin.Task;

public class LittleOneByOne extends IntegerTaskType {

   @Override
   public Task generateTask() {
      BigInteger a = RandomNumberGenerator.nextNumber(BigInteger.ZERO, BigInteger.TEN);
      BigInteger b = RandomNumberGenerator.nextNumber(BigInteger.ZERO, BigInteger.TEN);
      BigInteger c = a.multiply(b);

      IntegerMathTask t = new IntegerMathTask();

      if (BigInteger.TEN.compareTo(RandomNumberGenerator.nextNumber(BigInteger.ZERO, new BigInteger("20"))) < 0) {
         t.setLastOperation(Operation.MULTIPLY);
         t.setTask(formatValue(a) + " * " + formatValue(b));
         t.setResult(c);
      }
      else {
         t.setLastOperation(Operation.DIVIDE);
         t.setTask(formatValue(c) + " / " + formatValue(b));
         t.setResult(a);
      }

      return t;
   }


   protected Task generateMultiplyTask() {
      MathTask t = new MathTask();

//      BigDecimal a = random(BigDecimal.TEN);
//      BigDecimal b = random(BigDecimal.TEN);
//      BigDecimal c = a.multiply(b);
//
//      t.setTask(formatValue(a) + " * " + formatValue(b));
//      t.setResult("" + formatValue(c));
//
      return t;
   }


   protected Task generateDivisionTask() {
      MathTask t = new MathTask();

//      BigInteger a = random(BigInteger.TEN);
//      if (BigInteger.ZERO.compareTo(a) == 0)
//         a = BigInteger.ONE;
//      BigInteger b = random(BigInteger.TEN);
//      BigInteger c = a.multiply(b);
//
//      t.setTask(formatValue(c) + " / " + formatValue(a));
//      t.setResult("" + formatValue(b));

      return t;
   }


   @Override
   public String getTaskName() {
      return "Kleines 1x1";
   }

}
