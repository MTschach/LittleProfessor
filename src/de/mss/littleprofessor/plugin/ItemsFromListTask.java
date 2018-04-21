package de.mss.littleprofessor.plugin;

import java.util.ArrayList;

public class ItemsFromListTask extends Task {
   
   protected int neededResults      = 1;
   
   
   public ItemsFromListTask(int neededResults) {
      this.neededResults = neededResults;
   }

   @Override
   public void setGivenResult(String r) {
      super.setGivenResult(r.trim());
      
      this.correct = false;
      
      if (!isSet(r))
         return;
      
      ArrayList<String> possibleResults = new ArrayList<>();
      for (String s : this.getResult().toUpperCase().split(","))
         possibleResults.add(s.trim());
      
      ArrayList<String>results = new ArrayList<>();
      for (String s : r.toUpperCase().split(","))
         results.add(s.trim());
      
      
      int correctResults = 0;
      for (String s : results)
      {
         if (possibleResults.contains(s))
         {
            correctResults++;
         }
      }
      
      this.correct = (correctResults >= this.neededResults);
   }
}
