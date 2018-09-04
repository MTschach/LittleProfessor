package de.mss.littleprofessor.plugin;

import java.util.List;

import javax.swing.JPanel;

public interface PluginInfo extends de.mss.plugin.PluginInfo {

   public List<TaskType> getAvailableTaskTypes();


   public List<TaskType> getSelectedTasks();


   public JPanel getTaskConfigPanel();
}
