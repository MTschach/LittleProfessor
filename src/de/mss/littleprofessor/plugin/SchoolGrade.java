package de.mss.littleprofessor.plugin;

public enum SchoolGrade {

   NONE         (""),
   ONEBYONE     ("kleines 1x1"),
   PRESCHOOL    ("Vorschule"),
   FIRSTCLASS   ("1. Klasse"),
   SECONDCLASS  ("2. Klasse"),
   THIRDCLASS   ("3. Klasse"),
   FREESETTINGS ("Freie Wahl")
   ;
   
   private String name      = null;
   
   private SchoolGrade(String n)
   {
      this.name = n;
   }
   
   public String getName()
   {
      return this.name;
   }
   
   
   public static SchoolGrade getByName(String n)
   {
      for (SchoolGrade s : SchoolGrade.values())
      {
         if (s.getName().equals(n))
            return s;
      }
      return SchoolGrade.NONE;
   }
}
