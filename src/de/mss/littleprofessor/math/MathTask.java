package de.mss.littleprofessor.math;

import de.mss.littleprofessor.plugin.Task;

public abstract class MathTask extends Task {

   @Override
   public void setGivenResult(String r) {
      super.setGivenResult(r.trim());
   }
}
