package de.mss.littleprofessor.math;

import java.awt.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import de.mss.littleprofessor.math.tasktype.AddSubChain;
import de.mss.littleprofessor.math.tasktype.Addition;
import de.mss.littleprofessor.math.tasktype.Division;
import de.mss.littleprofessor.math.tasktype.LittleOneByOne;
import de.mss.littleprofessor.math.tasktype.Multiply;
import de.mss.littleprofessor.math.tasktype.RootAndSquare;
import de.mss.littleprofessor.math.tasktype.Subtraction;
import de.mss.littleprofessor.plugin.TaskType;

public class PluginInfo implements de.mss.littleprofessor.plugin.PluginInfo {

   protected JTextField       textMaxValue   = null;
   protected JList<JCheckBox> operationList  = null;
   protected List<TaskType>   availableTasks = null;


   @Override
   public String getPluginName() {
      return "LittleProfessor Mathematik";
   }


   @Override
   public String getPluginVersion() {
      return "V 1.0";
   }


   @Override
   public String getPluginDescription() {
      return "Stellt Mathematikaufgaben";
   }


   @Override
   public List<TaskType> getAvailableTaskTypes() {
      if (availableTasks == null) {
         availableTasks = new ArrayList<>();
         availableTasks.add(new Addition());
         availableTasks.add(new Subtraction());
         availableTasks.add(new Multiply());
         availableTasks.add(new Division());
         availableTasks.add(new LittleOneByOne());
         availableTasks.add(new RootAndSquare());
         availableTasks.add(new AddSubChain());
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

      operationList = new JList<JCheckBox>();

      int i = 0;
      for (TaskType t : getAvailableTaskTypes()) {
         operationList.add(getCheckBox(t, i++ ));
      }

      JScrollPane scrollPane = new JScrollPane(operationList);
      scrollPane.setBounds(5, 5, 260, 170);

      p.add(scrollPane);

      JLabel l = new JLabel("größte Zahl");
      l.setBounds(5, 185, 100, 20);

      p.add(l);

      textMaxValue = new JTextField(10);
      textMaxValue.setBounds(120, 185, 100, 20);
      textMaxValue.setText("10");

      p.add(textMaxValue);

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
      BigDecimal maxValue = new BigDecimal(this.textMaxValue.getText());

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

      for (TaskType t : list) {
         t.setLowerLimit(BigDecimal.ZERO);
         t.setUpperLimit(maxValue);
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
