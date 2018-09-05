package de.mss.littleprofessor.hsk.taskstype;

import java.math.BigInteger;

import de.mss.littleprofessor.hsk.ListMatcherTask;
import de.mss.littleprofessor.plugin.RandomNumberGenerator;
import de.mss.littleprofessor.plugin.Task;
import de.mss.littleprofessor.plugin.TaskType;

public class CommonQuestions extends TaskType {

   private static QuestionAnswer[] questions = {
                                                new QuestionAnswer("Wieviele Jahreszeiten gibt es?", "4,vier", 1),
                                                new QuestionAnswer("Wieviele Monate hat ein Jahr?", "12,zwölf", 1),
                                                new QuestionAnswer("Wieviele Tage hat eine Woche?", "7,sieben", 1)
   };


   @Override
   public Task generateTask() {
      int index = RandomNumberGenerator.nextNumber(BigInteger.ZERO, BigInteger.valueOf(questions.length - 1l)).intValue();

      ListMatcherTask task = new ListMatcherTask(questions[index].getRequiredMatches());

      task.setResult(questions[index].getAnswer());
      task.setTask(questions[index].getQuestion());

      return task;
   }


   @Override
   public String getTaskName() {
      return "allgemeine Fragen";
   }
}
