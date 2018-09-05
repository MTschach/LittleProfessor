package de.mss.littleprofessor.hsk;

public class ListEqualsMatcherTask extends ListMatcherTask {

   public ListEqualsMatcherTask(int rm) {
      super(rm);
   }


   @Override
   protected int checkGivenResult(String gr, String[] results) {
      for (String r : results)
         if (r.equals(gr))
            return 1;

      return -10000;
   }
}
