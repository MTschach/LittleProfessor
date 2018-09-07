package de.mss.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StopWatchTest {

   @Test
   public void testStopWatch() throws InterruptedException {
      StopWatch sw = new StopWatch();
      sw.start();
      Thread.sleep(100);
      sw.stop();

      assertTrue("Time >= 100", sw.getElapsedTime() >= 100);
   }


   @Test
   public void testStopWatchReset() throws InterruptedException {
      StopWatch sw = new StopWatch();
      sw.start();
      Thread.sleep(100);
      sw.stop();

      assertTrue("Time >= 100", sw.getElapsedTime() >= 100);
      sw.reset();
      assertEquals("Time reset", 0l, sw.getElapsedTime());
   }
}
