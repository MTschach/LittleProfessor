package de.mss.littleprofessor.hsk;

import de.mss.littleprofessor.plugin.Task;

public class ListMatcherTask extends Task {

   protected int requiredMatches = 1;


   public ListMatcherTask(int rm) {
      setRequiredMatches(rm);
   }


   public void setRequiredMatches(int rm) {
      if (rm > 0)
         this.requiredMatches = rm;
   }


   public int getRequiredMatches() {
      return this.requiredMatches;
   }


   @Override
   public void setGivenResult(String r) {
      String res = r.replaceAll("  ", " ");
      super.setGivenResult(r);

      String[] results = this.result.toUpperCase().split(",");
      String[] givenResults = res.toUpperCase().split(",");
      int matches = 0;
      int falseResults = 0;
      for (String gr : givenResults) {
         matches += checkGivenResult(gr.trim(), results);
         falseResults += checkForFalseResults(gr.trim(), results);
      }

      this.correct = matches >= requiredMatches && falseResults == 0;
   }


   private int checkForFalseResults(String gr, String[] results) {
      for (String r : results)
         if (r.equals(gr))
            return 0;

      return 1;
   }


   protected int checkGivenResult(String gr, String[] results) {
      for (String r : results)
         if (r.equals(gr))
            return 1;

      return 0;
   }
}
