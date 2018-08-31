package de.mss.littleprofessor.math;

public enum OperationTaskMapping {
   ADDITION         ("Addition"),
   SUBTRACTION      ("Subtraktion"),
   MULTIPLY         ("Multiplikation"),
   DIVIDE           ("Division"),
   LITTLEONEBYONE   ("kleines Einmal Eins")
   ;
   
   private String name     = null;
   
   private OperationTaskMapping(String o)
   {
      this.name    = o;
   }
   
   public String getOperation()
   {
      return this.name;
   }
   
   public final static OperationTaskMapping getByName(String o)
   {
      for (OperationTaskMapping otm : OperationTaskMapping.values())
      {
         if (otm.getOperation().equals(o))
            return otm;
      }
      return OperationTaskMapping.ADDITION;
   }
}
