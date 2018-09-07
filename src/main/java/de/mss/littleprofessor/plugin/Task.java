package de.mss.littleprofessor.plugin;

public class Task {

   protected String         currentTask         = null;
   protected String         result       = null;
   protected boolean        correct      = false;
   protected String         givenResult  = null;

   protected java.util.Date startTask    = null;
   protected long           taskDuration = 0;


   public String getTask() {
      this.startTask = new java.util.Date();
      return this.currentTask;
   }


   public String getResult() {
      return this.result;
   }


   public String getGivenResult() {
      return this.givenResult;
   }


   public boolean isCorrect() {
      return this.correct;
   }


   public long getTaskDuration() {
      return this.taskDuration;
   }


   public void setTask(String t) {
      this.currentTask = t;
   }


   public void setResult(String r) {
      this.result = r;
   }


   public void setTaskDuration(long d) {
      this.taskDuration = d;
   }


   public void setGivenResult(String r) {
      if (this.startTask != null)
         this.taskDuration = new java.util.Date().getTime() - startTask.getTime();
      this.givenResult = r;
      this.correct = false;
      if (this.givenResult == null) return;
      if (this.givenResult.equals(this.result)) this.correct = true;
   }


   protected boolean isSet(String s) {
      return (s != null && s.trim().length() > 0);
   }


   public String toString() {
      return "Aufgabe : \""
            + this.currentTask
            + "\"; Antwort : \""
            + this.result
            + "\"; Gegebene Antwort : \""
            + this.givenResult
            + "\"; Richtig : "
            + (this.correct ? "Ja" : "Nein")
            + "; Zeit : "
            + this.taskDuration;
   }
}
