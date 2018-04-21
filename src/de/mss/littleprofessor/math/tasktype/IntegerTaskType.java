package de.mss.littleprofessor.math.tasktype;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

import de.mss.littleprofessor.plugin.TaskType;

public abstract class IntegerTaskType extends TaskType {
   @Override
   public BigDecimal random (BigDecimal value)
   {
      return new BigDecimal(new Random().nextInt(value.intValue()+1));
   }
   
   
   @Override
   protected String formatValue(BigDecimal value)
   {
      return value.intValue()+"";
   }


}
