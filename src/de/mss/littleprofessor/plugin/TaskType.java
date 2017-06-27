package de.mss.littleprofessor.plugin;

import java.math.BigInteger;

public abstract class TaskType {
   protected String description     = null;
   protected BigInteger upperLimit  = BigInteger.TEN;
   protected BigInteger lowerLimit  = BigInteger.ZERO;
   
   public String getDescription() { return this.description; }
   public void setUpperLimit(BigInteger l)  { this.upperLimit = l; }
   public void setLowerLimit(BigInteger l)  { this.lowerLimit = l; }
   
   public abstract Task generateTask();
}
