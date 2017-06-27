package de.mss.littleprofessor.plugin;

import java.util.List;

public interface PluginInfo extends de.mss.plugin.PluginInfo {
   public List<TaskType> getAvailableTaskTypes(int difficulty);
}
