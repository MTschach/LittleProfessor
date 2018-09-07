package de.mss.littleprofessor.plugin;

public class TextMatcherTask extends ItemsFromListTask {

   public TextMatcherTask() {
      super(1);
   }


   public TextMatcherTask(int neededResults) {
      super(neededResults);
   }


   @Override
   public void setGivenResult(String r) {
      neededResults = split(getResult()).length;
      super.setGivenResult(r.replaceAll("  ", " ").replaceAll(",", ""));
   }


   @Override
   protected int checkForFalseResults(String gr, String[] results) {
      return 0;
   }


   @Override
   protected String[] split(String value) {
      return value.split(" ");
   }
}
