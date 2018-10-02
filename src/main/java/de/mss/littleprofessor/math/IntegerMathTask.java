package de.mss.littleprofessor.math;

import java.math.BigInteger;

import de.mss.littleprofessor.plugin.RandomNumberGenerator;

public class IntegerMathTask extends MathTask {

   protected BigInteger lastResult    = BigInteger.ZERO;
   protected Operation  lastOperation = Operation.ADDITION;
   protected BigInteger operand1      = BigInteger.ZERO;
   protected BigInteger operand2      = BigInteger.ZERO;


   public void setResult(BigInteger r) {
      this.lastResult = r;
      this.result = "" + r;
   }


   public void setLastOperation(Operation o) {
      this.lastOperation = o;
   }


   public Operation getLastOperation() {
      return this.lastOperation;
   }


   public BigInteger getLastIntegerResult() {
      return this.lastResult;
   }


   @Override
   public void setGivenResult(String r) {
      super.setGivenResult(r.trim());
   }


   public BigInteger getOperand1() {
      return this.operand1;
   }


   public BigInteger getOperand2() {
      return this.operand2;
   }


   public void setOperand1(BigInteger o) {
      this.operand1 = o;
   }


   public void setOperand2(BigInteger o) {
      this.operand2 = o;
   }


   public static IntegerMathTask generateAdditionTask(BigInteger lowerLimit, BigInteger upperLimit, BigInteger res) {
      if (res == null)
         return generateAdditionTask(lowerLimit, upperLimit);

      IntegerMathTask task = new IntegerMathTask();
      task.setLastOperation(Operation.ADDITION);
      task.setOperand1(RandomNumberGenerator.nextNumber(lowerLimit, res));
      task.setOperand2(res.subtract(task.getOperand1()));
      task.setResult(res);
      task.setTask(formatValue(task.getOperand1()) + " + " + formatValue(task.getOperand2()));
      return task;
   }


   public static IntegerMathTask generateAdditionTask(BigInteger lowerLimit, BigInteger upperLimit) {
      IntegerMathTask task = new IntegerMathTask();
      task.setLastOperation(Operation.ADDITION);
      task.setOperand1(RandomNumberGenerator.nextNumber(lowerLimit, upperLimit));
      task.setOperand2(RandomNumberGenerator.nextNumber(lowerLimit, upperLimit.subtract(task.getOperand1())));
      task.setTask(formatValue(task.getOperand1()) + " + " + formatValue(task.getOperand2()));
      task.setResult(task.getOperand1().add(task.getOperand2()));
      return task;
   }


   public static IntegerMathTask generateSubtractionTask(BigInteger lowerLimit, BigInteger upperLimit, BigInteger res) {
      if (res == null)
         return generateSubtractionTask(lowerLimit, upperLimit);

      IntegerMathTask task = new IntegerMathTask();
      task.setLastOperation(Operation.SUBTRACTION);
      task.setOperand2(RandomNumberGenerator.nextNumber(lowerLimit, upperLimit.subtract(res)));
      task.setOperand1(res.add(task.getOperand2()));
      task.setResult(res);
      task.setTask(formatValue(task.getOperand1()) + " - " + formatValue(task.getOperand2()));
      return task;
   }


   public static IntegerMathTask generateSubtractionTask(BigInteger lowerLimit, BigInteger upperLimit) {
      IntegerMathTask task = new IntegerMathTask();
      task.setLastOperation(Operation.SUBTRACTION);
      task.setOperand1(RandomNumberGenerator.nextNumber(lowerLimit, upperLimit));
      task.setOperand2(RandomNumberGenerator.nextNumber(lowerLimit, task.getOperand1()));
      task.setResult(task.getOperand1().subtract(task.getOperand2()));
      task.setTask(formatValue(task.getOperand1()) + " - " + formatValue(task.getOperand2()));
      return task;
   }


   public static IntegerMathTask generateMultiplyTask(BigInteger lowerLimit, BigInteger upperLimit, BigInteger res) {
      if (res == null)
         return generateMultiplyTask(lowerLimit, upperLimit);

      IntegerMathTask task = new IntegerMathTask();
      task.setLastOperation(Operation.MULTIPLY);
      task.setOperand1(RandomNumberGenerator.nextNumber(lowerLimit, res));
      if (BigInteger.ZERO.compareTo(res) == 0) {
         if (BigInteger.ZERO.compareTo(task.getOperand1()) == 0)
            task.setOperand2(RandomNumberGenerator.nextNumber(lowerLimit, upperLimit));
         else
            task.setOperand2(BigInteger.ZERO);
      }
      else {
         task.setOperand1(genNonZero(lowerLimit, res));

         BigInteger[] rem = res.divideAndRemainder(task.getOperand1());
         while (rem[1].compareTo(BigInteger.ZERO) != 0) {
            task.setOperand1(genNonZero(lowerLimit, res));
            rem = res.divideAndRemainder(task.getOperand1());
         }
         task.setOperand2(res.divide(task.getOperand1()));

         task.setResult(res);

         while (task.getLastIntegerResult().compareTo(lowerLimit) < 0 || task.getLastIntegerResult().compareTo(upperLimit) > 0) {
            task.setOperand2(RandomNumberGenerator.nextNumber(lowerLimit, upperLimit));
            task.setResult(task.getOperand1().multiply(task.getOperand2()));
         }
         task.setTask(formatValue(task.getOperand1()) + " * " + formatValue(task.getOperand2()));
      }
      return task;
   }


   public static IntegerMathTask generateMultiplyTask(BigInteger lowerLimit, BigInteger upperLimit) {
      IntegerMathTask task = new IntegerMathTask();
      task.setLastOperation(Operation.MULTIPLY);
      task.setOperand1(RandomNumberGenerator.nextNumber(lowerLimit, upperLimit));
      task.setOperand2(RandomNumberGenerator.nextNumber(lowerLimit, upperLimit));
      task.setResult(task.getOperand1().multiply(task.getOperand2()));

      while (task.getLastIntegerResult().compareTo(lowerLimit) < 0 || task.getLastIntegerResult().compareTo(upperLimit) > 0) {
         task.setOperand2(RandomNumberGenerator.nextNumber(lowerLimit, upperLimit));
         task.setResult(task.getOperand1().multiply(task.getOperand2()));
      }
      task.setTask(formatValue(task.getOperand1()) + " * " + formatValue(task.getOperand2()));
      return task;
   }


   public static IntegerMathTask generateDivideTask(BigInteger lowerLimit, BigInteger upperLimit, BigInteger res) {
      if (res == null)
         return generateDivideTask(lowerLimit, upperLimit);

      IntegerMathTask task = new IntegerMathTask();
      task.setLastOperation(Operation.DIVIDE);

      if (BigInteger.ZERO.compareTo(res) == 0) {
         task.setOperand1(res);
         task.setOperand2(checkZero(RandomNumberGenerator.nextNumber(lowerLimit, upperLimit)));
      }
      else {

         task.setOperand2(checkZero(RandomNumberGenerator.nextNumber(lowerLimit, upperLimit)));
         BigInteger r = res.multiply(task.getOperand2());

         while (r.compareTo(lowerLimit) < 0 || r.compareTo(upperLimit) > 0) {
            task.setOperand2(checkZero(RandomNumberGenerator.nextNumber(lowerLimit, upperLimit)));
            r = res.multiply(task.getOperand2());
         }
         task.setOperand1(r);
         task.setResult(res);
      }

      task.setTask(formatValue(task.getOperand1()) + " : " + formatValue(task.getOperand2()));

      return task;
   }


   public static IntegerMathTask generateDivideTask(BigInteger lowerLimit, BigInteger upperLimit) {
      IntegerMathTask task = new IntegerMathTask();
      task.setLastOperation(Operation.DIVIDE);

      BigInteger b = checkZero(RandomNumberGenerator.nextNumber(lowerLimit, upperLimit));
      BigInteger c = RandomNumberGenerator.nextNumber(lowerLimit, upperLimit);

      BigInteger a = b.multiply(c);
      while (a.compareTo(lowerLimit) < 0 || a.compareTo(upperLimit) > 0) {
         b = checkZero(RandomNumberGenerator.nextNumber(lowerLimit, upperLimit));
         a = b.multiply(c);
      }

      task.setOperand1(a);
      task.setOperand2(b);
      task.setResult(c);
      task.setTask(formatValue(task.getOperand1()) + " : " + formatValue(task.getOperand2()));

      return task;
   }


   private static BigInteger checkZero(BigInteger val) {
      if (BigInteger.ZERO.compareTo(val) == 0)
         return BigInteger.ONE;

      return val;
   }


   private static BigInteger genNonZero(BigInteger lowerLimit, BigInteger upperLimit) {
      if (BigInteger.ZERO.compareTo(lowerLimit) == 0 && BigInteger.ZERO.compareTo(upperLimit) == 0)
         return BigInteger.ONE;

      BigInteger a = BigInteger.ZERO;

      while (BigInteger.ZERO.compareTo(a) == 0)
         a = RandomNumberGenerator.nextNumber(lowerLimit, upperLimit);

      return a;
   }


   public static String formatValue(BigInteger value) {
      return value.intValue() + "";
   }


}
