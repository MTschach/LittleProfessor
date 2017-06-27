package de.mss.littleprofessor.math;

import java.util.ArrayList;
import java.util.List;

import de.mss.littleprofessor.plugin.TaskType;

public class PluginInfo implements de.mss.littleprofessor.plugin.PluginInfo {

   @Override
   public String getPluginName() {
      return "LittleProfessor Mathematik";
   }

   @Override
   public String getPluginVersion() {
      return "V 1.0";
   }

   @Override
   public String getPlugindescription() {
      return "Stellt Mathematikaufgaben";
   }

   @Override
   public List<TaskType> getAvailableTaskTypes(int difficulty) {
      List<TaskType> ret = new ArrayList<TaskType>();
      if (difficulty <= 0)  return null;
      
      for (TaskTypeEnum t : TaskTypeEnum.values()) {
         if (t.getDifficulty() <= difficulty)
            ret.add(t.getTaskType());
      }
      
      return ret;
   }
}
