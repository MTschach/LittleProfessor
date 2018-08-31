package de.mss.littleprofessor.math.tasktype;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

import de.mss.littleprofessor.math.RandomNumberGenerator;
import de.mss.littleprofessor.plugin.TaskType;

public abstract class IntegerTaskType extends TaskType {

   protected BigInteger lowerLimit = BigInteger.ZERO;
   protected BigInteger upperLimit = BigInteger.TEN;


   public BigInteger getLowerLimit() {
      return this.lowerLimit;
   }


   public BigInteger getUpperLimit() {
      return this.upperLimit;
   }


   public void setLowerLimit(BigInteger l) {
      this.lowerLimit = l;
   }


   public void setUpperLimit(BigInteger l) {
      this.upperLimit = l;
   }


   @Override
   public BigDecimal random(BigDecimal value) {
      return new BigDecimal(new Random().nextInt(value.intValue() + 1));
   }


   @Override
   protected String formatValue(BigDecimal value) {
      return value.intValue() + "";
   }


   protected String formatValue(BigInteger value) {
      return value.intValue() + "";
   }


   protected boolean isMoreThan50Percent() {
      return RandomNumberGenerator.nextNumber(BigInteger.ZERO, BigInteger.TEN.add(BigInteger.TEN)).compareTo(BigInteger.TEN) >= 0;
   }
}
