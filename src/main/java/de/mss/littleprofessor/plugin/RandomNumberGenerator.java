package de.mss.littleprofessor.plugin;

import java.math.BigInteger;
import java.util.Random;

public class RandomNumberGenerator {

   private static Random numberGenerator = null;


   public static BigInteger nextNumber(BigInteger minValue, BigInteger maxValue) {
      if (numberGenerator != null)
         return new BigInteger("" + numberGenerator.nextInt());

      BigInteger range = maxValue.subtract(minValue).add(BigInteger.ONE);
      int rand = new Random().nextInt();
      int val = (Math.abs(rand) % range.intValue()) + minValue.intValue();

      return new BigInteger("" + val);
   }

}
