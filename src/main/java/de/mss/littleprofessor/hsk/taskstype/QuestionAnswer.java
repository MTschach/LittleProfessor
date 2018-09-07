package de.mss.littleprofessor.hsk.taskstype;


public class QuestionAnswer {

   private String question        = null;
   private String answer          = null;
   private int    requiredMatches = 1;


   public QuestionAnswer(String q, String a) {
      this.question = q;
      this.answer = a;
      this.requiredMatches = 1;
   }


   public QuestionAnswer(String q, int a) {
      this.question = q;
      this.answer = "" + a;
      this.requiredMatches = 1;
   }


   public QuestionAnswer(String q, String a, int rm) {
      this.question = q;
      this.answer = a;
      this.requiredMatches = rm;
   }


   public QuestionAnswer(String q, int a, int rm) {
      this.question = q;
      this.answer = "" + a;
      this.requiredMatches = rm;
   }


   public String getQuestion() {
      return this.question;
   }


   public String getAnswer() {
      return this.answer;
   }


   public int getRequiredMatches() {
      return this.requiredMatches;
   }
}
