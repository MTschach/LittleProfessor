package de.mss.littleprofessor.plugin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ItemsFromListTaskTest {

   @Test
   public void testTaskList1RequiredOk_0001() throws InterruptedException {
      ItemsFromListTask t = new ItemsFromListTask(1);

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
   public void testTaskList1RequiredOk_0002() throws InterruptedException {
      ItemsFromListTask t = new ItemsFromListTask(1);

      t.setTask("A");
      t.setResult("A,B");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A,B", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("A");
      assertEquals("Given Result", "A", t.getGivenResult());
      assertTrue("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTaskList1RequiredOk_0003() throws InterruptedException {
      ItemsFromListTask t = new ItemsFromListTask(1);

      t.setTask("A");
      t.setResult("A,B");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A,B", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("B");
      assertEquals("Given Result", "B", t.getGivenResult());
      assertTrue("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTaskList1RequiredNook_0001() throws InterruptedException {
      ItemsFromListTask t = new ItemsFromListTask(1);

      t.setTask("A");
      t.setResult("A");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("C");
      assertEquals("Given Result", "C", t.getGivenResult());
      assertFalse("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTaskList1RequiredNook_0002() throws InterruptedException {
      ItemsFromListTask t = new ItemsFromListTask(1);

      t.setTask("A");
      t.setResult("A,B");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A,B", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("C");
      assertEquals("Given Result", "C", t.getGivenResult());
      assertFalse("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTaskList2RequiredOk_0001() throws InterruptedException {
      ItemsFromListTask t = new ItemsFromListTask(2);

      t.setTask("A");
      t.setResult("A,B");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A,B", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("A,B");
      assertEquals("Given Result", "A,B", t.getGivenResult());
      assertTrue("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTaskList2RequiredOk_0002() throws InterruptedException {
      ItemsFromListTask t = new ItemsFromListTask(2);

      t.setTask("A");
      t.setResult("A,B");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A,B", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("B,A");
      assertEquals("Given Result", "B,A", t.getGivenResult());
      assertTrue("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTaskList2RequiredNook_0001() throws InterruptedException {
      ItemsFromListTask t = new ItemsFromListTask(2);

      t.setTask("A");
      t.setResult("A,B");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A,B", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("A,B,C");
      assertEquals("Given Result", "A,B,C", t.getGivenResult());
      assertFalse("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTaskList2RequiredNook_0002() throws InterruptedException {
      ItemsFromListTask t = new ItemsFromListTask(2);

      t.setTask("A");
      t.setResult("A,B");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A,B", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("A,B,C");
      assertEquals("Given Result", "A,B,C", t.getGivenResult());
      assertFalse("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }

}
