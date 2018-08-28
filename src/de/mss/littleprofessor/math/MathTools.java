package de.mss.littleprofessor.math;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MathTools {

   public static BigInteger random(BigInteger lowerLimit, BigInteger upperLimit) {
      return new BigInteger("" + (upperLimit.subtract(lowerLimit).doubleValue() * Math.random())).add(lowerLimit);
   }


   public static BigDecimal random(BigDecimal lowerLimit, BigDecimal upperLimit) {
      return upperLimit.subtract(lowerLimit).multiply(new BigDecimal(Math.random())).add(lowerLimit);
   }


   public static boolean randomOperationIsAddition() {
      return (Math.random() <= 0.5d);
   }
}

