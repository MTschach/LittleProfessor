package de.mss.littleprofessor.hsk.taskstype;

import java.math.BigInteger;

import de.mss.littleprofessor.plugin.RandomNumberGenerator;
import de.mss.littleprofessor.plugin.Task;
import de.mss.littleprofessor.plugin.TaskType;
import de.mss.littleprofessor.plugin.TextMatcherTask;

public class Potato extends TaskType {

   private static QuestionAnswer[] questions = {
                                                new QuestionAnswer("Wo kommt die Kartoffelpflanze urspürnglich her?", "Südamerika"),
                                                new QuestionAnswer("Wer baute die Kartoffelpflanze schon vor fast 1000 Jahren an?", "Inka"),
                                                new QuestionAnswer("Wer verbreitete die Kartoffel in Deutschland?", "Friedrich der Große"),
                                                new QuestionAnswer("Wer ist der Feind der Kartoffel", "Kartoffelkäfer")
   };


   @Override
   public Task generateTask() {
      int index = RandomNumberGenerator.nextNumber(BigInteger.ZERO, BigInteger.valueOf(questions.length - 1l)).intValue();

      TextMatcherTask task = new TextMatcherTask();

      task.setResult(questions[index].getAnswer());
      task.setTask(questions[index].getQuestion());

      return task;
   }


   @Override
   public String getTaskName() {
      return "Die Kartoffel";
   }
}
