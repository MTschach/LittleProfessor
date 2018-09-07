package de.mss.littleprofessor.plugin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TaskTest {

   @Test
   public void testTaskOk() throws InterruptedException {
      Task t = new Task();
      t.setTask("A");
      t.setResult("A");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("A");
      assertEquals("Given Result", "A", t.getGivenResult());
      assertTrue("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTaskNook() throws InterruptedException {
      Task t = new Task();
      t.setTask("A");
      t.setResult("A");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("a");
      assertEquals("Given Result", "a", t.getGivenResult());
      assertFalse("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }
}
