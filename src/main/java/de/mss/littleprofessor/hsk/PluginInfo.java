package de.mss.littleprofessor.hsk;

import java.awt.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import de.mss.littleprofessor.hsk.taskstype.CommonQuestions;
import de.mss.littleprofessor.hsk.taskstype.Potato;
import de.mss.littleprofessor.plugin.TaskType;

public class PluginInfo implements de.mss.littleprofessor.plugin.PluginInfo {

   protected JList<JCheckBox> operationList  = null;
   protected List<TaskType>   availableTasks = null;


   @Override
   public String getPluginName() {
      return "LittleProfessor Heimat- und Sachkunde";
   }


   @Override
   public String getPluginVersion() {
      return "V 1.0";
   }


   @Override
   public String getPluginDescription() {
      return "Stellt Aufgaben aus dem Bereich Heimet- und Sachkunde";
   }


   @Override
   public List<TaskType> getAvailableTaskTypes() {
      if (availableTasks == null) {
         availableTasks = new ArrayList<>();
         availableTasks.add(new CommonQuestions());
         availableTasks.add(new Potato());
      }
      return availableTasks;
   }


   protected TaskType getTaskType(TaskType t, BigDecimal lowerLimit, BigDecimal upperLimit) {
      t.setLowerLimit(lowerLimit);
      t.setUpperLimit(upperLimit);
      return t;
   }


   @Override
   public JPanel getTaskConfigPanel() {
      JPanel p = new JPanel();
      p.setLayout(null);

      p.setBounds(5, 45, 270, 180);

      operationList = new JList<>();

      int i = 0;
      for (TaskType t : getAvailableTaskTypes()) {
         operationList.add(getCheckBox(t, i++ ));
      }

      JScrollPane scrollPane = new JScrollPane(operationList);
      scrollPane.setBounds(5, 5, 260, 170);

      p.add(scrollPane);

      return p;
   }


   private <T extends TaskType> JCheckBox getCheckBox(T task, int index) {
      JCheckBox check = new JCheckBox();
      check.setText(task.getTaskName());
      check.setBounds(10, 10 + index * 20, 230, 25);

      return check;
   }


   public List<TaskType> getSelectedTasks() {
      ArrayList<TaskType> list = new ArrayList<>();
      for (int i = 0; i < this.operationList.getComponentCount(); i++ ) {
         Component comp = this.operationList.getComponent(i);
         if (comp instanceof JCheckBox) {
            JCheckBox box = (JCheckBox)comp;
            if (box.isSelected()) {
               TaskType t = getTask(box.getText());
               if (t != null)
                  list.add(t);
            }
         }
      }

      return list;
   }


   private TaskType getTask(String text) {
      for (TaskType t : availableTasks) {
         if (t.getTaskName().equals(text))
            return t;
      }

      return null;
   }
}
