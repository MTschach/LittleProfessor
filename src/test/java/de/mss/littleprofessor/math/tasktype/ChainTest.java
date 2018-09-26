package de.mss.littleprofessor.math.tasktype;

import org.junit.Test;

import de.mss.littleprofessor.plugin.Task;

public class ChainTest {

   @Test
   public void testChain() {
      Chain c = new Chain();
      for (int i = 0; i < 10; i++ ) {
         Task task = c.generateTask();
         System.out.println(task.getTask() + " = " + task.getResult());
      }
   }

}
