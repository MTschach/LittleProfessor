package de.mss.littleprofessor.plugin;

public class Task {
   protected String task        = null;
   protected String result      = null;
   protected boolean correct    = false;
   protected String givenResult = null;
   
   public String getTask()          { return this.task; }
   public String getResult()        { return this.result; }
   public String getGivenResult()   { return this.givenResult; }
   public boolean isCorrect()       { return this.correct; }
   
   public void setTask(String t)    { this.task = t; }
   public void setResult(String r)  { this.result = r; }
   
   public void setGivenResult(String r) {
      this.givenResult = r;
      this.correct = false;
      if (this.givenResult == null) return;
      if (this.givenResult.equals(this.result)) this.correct = true;
   }
}
