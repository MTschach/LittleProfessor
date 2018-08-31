package de.mss.littleprofessor.plugin;

import java.math.BigDecimal;
import java.util.Random;

public abstract class TaskType {
   protected String description     = null;
   protected BigDecimal upperLimit  = BigDecimal.TEN;
   protected BigDecimal lowerLimit  = BigDecimal.ZERO;
   
   public String getDescription() { return this.description; }
   public void setUpperLimit(BigDecimal l)  { this.upperLimit = l; }
   public void setLowerLimit(BigDecimal l)  { this.lowerLimit = l; }
   
   public abstract Task generateTask();
   
   
   protected BigDecimal random()
   {
      return random(BigDecimal.ONE);
   }
   
   protected BigDecimal random (BigDecimal value)
   {
      return new BigDecimal("" + (new Random().nextDouble()*value.doubleValue()));
   }
   
   protected String formatValue(BigDecimal value)
   {
      return value.toString();
   }
   public String getTaskName() {
      return "Aufagbe";
   }
}
