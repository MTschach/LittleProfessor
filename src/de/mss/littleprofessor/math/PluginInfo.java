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

import de.mss.littleprofessor.math.tasktype.Addition;
import de.mss.littleprofessor.math.tasktype.Division;
import de.mss.littleprofessor.math.tasktype.LittleOneByOne;
import de.mss.littleprofessor.math.tasktype.Multiply;
import de.mss.littleprofessor.math.tasktype.Subtraction;
import de.mss.littleprofessor.math.tasktype.TrippleAddition;
import de.mss.littleprofessor.math.tasktype.TrippleAdditionSubtraction;
import de.mss.littleprofessor.math.tasktype.TrippleSubtraction;
import de.mss.littleprofessor.plugin.SchoolGrade;
import de.mss.littleprofessor.plugin.TaskType;

public class PluginInfo implements de.mss.littleprofessor.plugin.PluginInfo {
   protected JTextField textMaxValue    = null;
   protected JList<JCheckBox> operationList      = null;
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
   public List<TaskType> getAvailableTaskTypes(SchoolGrade s) {
      ArrayList<TaskType> list = new ArrayList<>();
      switch (s) {
      	case NONE:
      	case PRESCHOOL:
      		list.add(new Addition());
      		break;
      		
      	case FIRSTCLASS:
      		list.add(new Addition());
      		list.add(new Subtraction());
      		break;
      		
      	case SECONDCLASS:
      		list.add(new Addition());
      		list.add(new Subtraction());
      		list.add(new Multiply());
      		list.add(new LittleOneByOne());
      		break;
      		
      	case THIRDCLASS:
      	case FREESETTINGS:
      		list.add(new Addition());
      		list.add(new Subtraction());
      		list.add(new Multiply());
      		list.add(new Division());
      		list.add(new LittleOneByOne());
      		break;
      		
      	case ONEBYONE:
      		list.add(new LittleOneByOne());
      		break;
      }
      return list;
   }
   
   
   protected TaskType getTaskType(TaskType t, BigDecimal lowerLimit, BigDecimal upperLimit)
   {
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
      
      operationList.add(getCheckBox(new Addition(), 	0));
      operationList.add(getCheckBox(new Subtraction(), 	1));
      operationList.add(getCheckBox(new Multiply(), 	2));
      operationList.add(getCheckBox(new Division(), 	3));
      operationList.add(getCheckBox(new LittleOneByOne(), 4));
      
      JScrollPane scrollPane = new JScrollPane(operationList);
      scrollPane.setBounds(5, 5, 260, 170);
      
      p.add(scrollPane);
      
      JLabel l = new JLabel ("größte Zahl");
      l.setBounds(5, 185, 100, 20);
      
      p.add(l);
      
      textMaxValue = new JTextField(10);
      textMaxValue.setBounds(120, 185, 100, 20);
      
      p.add(textMaxValue);
      
      return p;
   }
   
   
   private <T extends TaskType> JCheckBox getCheckBox(T task, int index) {
	   JCheckBox check = new JCheckBox();
	   check.setText(task.getTaskName());
	   check.setBounds(10, 10+index*20, 230, 25);
	   
	   return check;
   }
   
   
   public void doPreselection(SchoolGrade s)
   {
      if (this.operationList == null)
         return;
      
      List<TaskType> taskList = getAvailableTaskTypes(s);
      
      for (int i = 0; i<this.operationList.getComponentCount(); i++)
      {
         Component comp = this.operationList.getComponent(i);
         if (comp instanceof JCheckBox)
         {
            JCheckBox box = (JCheckBox)comp;
            box.setSelected(false);
         }
      }

      for (int i = 0; i<this.operationList.getComponentCount(); i++)
      {
         Component comp = this.operationList.getComponent(i);
         if (comp instanceof JCheckBox)
         {
            JCheckBox box = (JCheckBox)comp;
            for (TaskType t : taskList)
            {
               if (t.getTaskName().equals(box.getText()))
               {
                  box.setSelected(true);
               }
            }
         }
      }
      
      this.textMaxValue.setText(SchoolGradeTasks.getBySchoolGrade(s).getMaxValue().toString());
   }
   
   
   public List<TaskType> getSelectedTasks()
   {
      ArrayList<TaskType> list = new ArrayList<>();
      BigDecimal maxValue = new BigDecimal(this.textMaxValue.getText());
      
      for (int i = 0; i<this.operationList.getComponentCount(); i++)
      {
         Component comp = this.operationList.getComponent(i);
         if (comp instanceof JCheckBox)
         {
            JCheckBox box = (JCheckBox)comp;
            if (box.isSelected())
            {
               if (box.getText().equals("Addition"))
                  list.add(new Addition());
               else if (box.getText().equals("Subtraktion"))
                  list.add(new Subtraction());
               else if (box.getText().equals("Multiplikation"))
                  list.add(new Multiply());
               else if (box.getText().equals("Division"))
                  list.add(new Division());
               else if (box.getText().equals("Kleines 1x1"))
                  list.add(new LittleOneByOne());
            }
         }
      }
      
      for (TaskType t : list)
      {
         t.setLowerLimit(BigDecimal.ZERO);
         t.setUpperLimit(maxValue);
      }
      
      return list;
   }
}
