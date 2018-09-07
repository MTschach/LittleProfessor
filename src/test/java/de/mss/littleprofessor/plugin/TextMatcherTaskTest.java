package de.mss.littleprofessor.plugin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TextMatcherTaskTest {

   @Test
   public void testTextMatherTask1RequiredOk_0001() throws InterruptedException {
      TextMatcherTask t = new TextMatcherTask(1);

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
   public void testTextMatherTask1RequiredOk_0002() throws InterruptedException {
      TextMatcherTask t = new TextMatcherTask(1);

      t.setTask("A");
      t.setResult("A");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("A b");
      assertEquals("Given Result", "A b", t.getGivenResult());
      assertTrue("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTextMatherTask1RequiredOk_0003() throws InterruptedException {
      TextMatcherTask t = new TextMatcherTask(1);

      t.setTask("A");
      t.setResult("A");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("b A");
      assertEquals("Given Result", "b A", t.getGivenResult());
      assertTrue("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTextMatherTask1RequiredOk_0004() throws InterruptedException {
      TextMatcherTask t = new TextMatcherTask(1);

      t.setTask("A");
      t.setResult("A");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("c A b");
      assertEquals("Given Result", "c A b", t.getGivenResult());
      assertTrue("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTextMatherTask1RequiredNook_0001() throws InterruptedException {
      TextMatcherTask t = new TextMatcherTask(1);

      t.setTask("A");
      t.setResult("A");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("b");
      assertEquals("Given Result", "b", t.getGivenResult());
      assertFalse("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTextMatherTask2RequiredOk_0001() throws InterruptedException {
      TextMatcherTask t = new TextMatcherTask(1);

      t.setTask("A");
      t.setResult("A B");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A B", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("A B");
      assertEquals("Given Result", "A B", t.getGivenResult());
      assertTrue("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTextMatherTask2RequiredOk_0002() throws InterruptedException {
      TextMatcherTask t = new TextMatcherTask(1);

      t.setTask("A");
      t.setResult("A B");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A B", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("a b");
      assertEquals("Given Result", "a b", t.getGivenResult());
      assertTrue("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTextMatherTask2RequiredOk_0003() throws InterruptedException {
      TextMatcherTask t = new TextMatcherTask(1);

      t.setTask("A");
      t.setResult("A B");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A B", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("B a");
      assertEquals("Given Result", "B a", t.getGivenResult());
      assertTrue("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTextMatherTask2RequiredOk_0004() throws InterruptedException {
      TextMatcherTask t = new TextMatcherTask(1);

      t.setTask("A");
      t.setResult("A B");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A B", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("A B c");
      assertEquals("Given Result", "A B c", t.getGivenResult());
      assertTrue("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTextMatherTask2RequiredOk_0005() throws InterruptedException {
      TextMatcherTask t = new TextMatcherTask(1);

      t.setTask("A");
      t.setResult("A B");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A B", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("c A B");
      assertEquals("Given Result", "c A B", t.getGivenResult());
      assertTrue("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTextMatherTask2RequiredOk_0006() throws InterruptedException {
      TextMatcherTask t = new TextMatcherTask(1);

      t.setTask("A");
      t.setResult("A B");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A B", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("A c B");
      assertEquals("Given Result", "A c B", t.getGivenResult());
      assertTrue("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTextMatherTask2RequiredOk_0007() throws InterruptedException {
      TextMatcherTask t = new TextMatcherTask(1);

      t.setTask("A");
      t.setResult("A B");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A B", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("b c a");
      assertEquals("Given Result", "b c a", t.getGivenResult());
      assertTrue("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTextMatherTask2RequiredOk_0008() throws InterruptedException {
      TextMatcherTask t = new TextMatcherTask(1);

      t.setTask("A");
      t.setResult("A B");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A B", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("c A e B f");
      assertEquals("Given Result", "c A e B f", t.getGivenResult());
      assertTrue("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTextMatherTask2RequiredNook_0001() throws InterruptedException {
      TextMatcherTask t = new TextMatcherTask(1);

      t.setTask("A");
      t.setResult("A B");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A B", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("a");
      assertEquals("Given Result", "a", t.getGivenResult());
      assertFalse("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTextMatherTask2RequiredNook_0002() throws InterruptedException {
      TextMatcherTask t = new TextMatcherTask(1);

      t.setTask("A");
      t.setResult("A B");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A B", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("b");
      assertEquals("Given Result", "b", t.getGivenResult());
      assertFalse("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


   @Test
   public void testTextMatherTask2RequiredNook_0003() throws InterruptedException {
      TextMatcherTask t = new TextMatcherTask(1);

      t.setTask("A");
      t.setResult("A B");

      assertEquals("Task", "A", t.getTask());
      assertEquals("Result", "A B", t.getResult());
      assertEquals("Duration", 0l, t.getTaskDuration());
      assertNull("Given Result", t.getGivenResult());

      Thread.sleep(10);

      t.setGivenResult("a c e");
      assertEquals("Given Result", "a c e", t.getGivenResult());
      assertFalse("Correct", t.isCorrect());
      assertTrue("Duration > 0", t.getTaskDuration() > 0);
   }


}
