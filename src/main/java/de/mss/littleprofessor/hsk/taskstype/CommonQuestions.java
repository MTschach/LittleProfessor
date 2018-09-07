package de.mss.littleprofessor.hsk.taskstype;

import java.math.BigInteger;

import de.mss.littleprofessor.plugin.ItemsFromListTask;
import de.mss.littleprofessor.plugin.RandomNumberGenerator;
import de.mss.littleprofessor.plugin.Task;
import de.mss.littleprofessor.plugin.TaskType;

public class CommonQuestions extends TaskType {

   private static QuestionAnswer[] questions = {
                                                new QuestionAnswer("Wieviele Jahreszeiten gibt es?", "4,vier", 1),
                                                new QuestionAnswer("Wieviele Monate hat ein Jahr?", "12,zwölf", 1),
                                                new QuestionAnswer("Wieviele Tage hat eine Woche?", "7,sieben", 1),
                                                new QuestionAnswer("Welcher Nadelbaum verliert im Winter seine Nadeln?", "Lärche", 1),
                                                new QuestionAnswer("Welches Tier rollt sich bei Gefahr zu einer Stachelkugel zusammen?", "Igel", 1),

                                                new QuestionAnswer("Nenne mindestens 2 Winterblüher", "Schneeglöckchen,Winterling,Christrose", 2),
                                                new QuestionAnswer("Nenne mindestens 2 Getreidearten", "Weizen,Roggen,Gerste,Hafer,Dinkel", 2),

                                                new QuestionAnswer(
                                                      "Nenne mindestens 3 Frühjahrsblüher",
                                                      "Krokus,Maiglöckchen,Märzenbecher,Narzisse,Osterglocke",
                                                      3),
                                                new QuestionAnswer(
                                                      "Nenne mindestens 3 einheimische Laubbäume",
                                                      "Ahorn,Buche,Eiche,Birke,Linde,Kastanie,Pappel,Erle",
                                                      3),
                                                new QuestionAnswer("Nennen mindestens 3 einheimische Nadelbäume", "Fichte,Kiefer,Lärche,Tanne", 3),
                                                new QuestionAnswer(
                                                      "Nenne 3 einheimische Früchte",
                                                      "Apfel,Birne,Kirsche,Erdbeere,Himbeere,Stachelbeere,Pflaume",
                                                      3),

                                                new QuestionAnswer("Welche Jahreszeiten gibt es?", "Frühling,Sommer,Herbst,Winter", 4)

   };


   @Override
   public Task generateTask() {
      int index = RandomNumberGenerator.nextNumber(BigInteger.ZERO, BigInteger.valueOf(questions.length - 1l)).intValue();

      ItemsFromListTask task = new ItemsFromListTask(questions[index].getRequiredMatches());

      task.setResult(questions[index].getAnswer());
      task.setTask(questions[index].getQuestion());

      return task;
   }


   @Override
   public String getTaskName() {
      return "allgemeine Fragen";
   }
}
