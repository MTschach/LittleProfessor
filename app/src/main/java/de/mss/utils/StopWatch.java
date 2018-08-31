package de.mss.utils;

public class StopWatch {
   
   protected long startTime         = 0;
   protected long endTime           = 0;
   
   
   public StopWatch() {
      this.reset();
   }
   
   public void reset() {
      this.startTime    = -1;
      this.endTime      = -1;
   }
   
   
   public void start() {
      if (this.startTime >= 0)
         return;
      this.startTime = System.currentTimeMillis();
   }
   
   
   
   public void stop() {
      if (this.endTime >= 0)
         return;
      
      this.endTime = System.currentTimeMillis();
   }
   
   
   public long getElapsedTime() {
      if (this.startTime < 0 || this.endTime < 0)
         return 0l;
      return this.endTime - this.startTime;
   }

}
