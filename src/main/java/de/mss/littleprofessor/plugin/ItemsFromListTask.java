package de.mss.littleprofessor.plugin;

public class ItemsFromListTask extends Task {

   protected int neededResults = 1;


   public ItemsFromListTask(int neededResults) {
      this.neededResults = neededResults;
   }


   @Override
   public void setGivenResult(String r) {
      String res = r.replaceAll("  ", " ");
      super.setGivenResult(r);

      String[] results = split(this.result.toUpperCase());
      String[] givenResults = split(res.toUpperCase());
      int matches = 0;
      int falseResults = 0;
      for (String gr : givenResults) {
         matches += checkGivenResult(gr.trim(), results);
         falseResults += checkForFalseResults(gr.trim(), results);
      }

      this.correct = matches >= neededResults && falseResults == 0;
   }


   protected int checkForFalseResults(String gr, String[] results) {
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


   protected String[] split(String value) {
      return value.split(",");
   }
}
