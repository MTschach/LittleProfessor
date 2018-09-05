package de.mss.littleprofessor.hsk;

import de.mss.littleprofessor.plugin.Task;

public class TextMatcherTask extends Task {

   protected int requiredMatches = 1;


   public TextMatcherTask(int rm) {
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

      String[] results = this.result.toUpperCase().split(" ");
      String[] givenResults = res.toUpperCase().split(" ");
      int matches = 0;
      for (String gr : givenResults) {
         matches += checkGivenResult(gr, results);
      }

      this.correct = matches >= requiredMatches;
   }


   protected int checkGivenResult(String gr, String[] results) {
      for (String r : results)
         if (r.equals(gr))
            return 1;

      return 0;
   }
}
