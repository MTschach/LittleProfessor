package de.mss.littleprofessor.app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import de.mss.littleprofessor.plugin.PluginInfo;
import de.mss.littleprofessor.plugin.Task;
import de.mss.littleprofessor.plugin.TaskType;
import de.mss.utils.StopWatch;

public class LittleProfessor extends JFrame implements WindowListener, MouseListener, ActionListener, KeyListener {

   protected JComboBox<String> comboSchoolgrade  = null;
   protected JTextField        textNumberOfTasks = null;

   protected List<PluginInfo>  loadedPlugins     = null;

   protected JTabbedPane       tabs              = null;

   protected ArrayList<Task>   taskList          = null;

   protected JLabel            currentTaskText   = null;
   protected JTextField        currentResult     = null;

   protected java.util.Date    startDate         = null;

   protected int               currentTask       = 0;

   protected StopWatch         stopWatch         = new StopWatch();

   protected JLabel            resultLabel       = new JLabel();

   protected int               maxWidth          = 600;
   protected int               maxHeight         = 520;

   protected JTable            resultTable       = null;

   /**
    * 
    */
   private static final long   serialVersionUID  = -7067067848699201534L;


   public LittleProfessor(String args[]) {
      init(args);
   }


   protected void deinit() {
      this.dispose();
   }


   protected void init(String args[]) {
      loadPlugins("./bin");
      this.setVisible(false);
      this.setTitle("LittleProfessor");
      this.setSize(new Dimension(this.maxWidth, this.maxHeight));

      this.setLayout(null);

      this.addWindowListener(this);
      this.addMouseListener(this);

      initTabs();

      this.getContentPane().add(this.tabs);

      this.setVisible(true);
   }


   protected void initTabs() {
      this.tabs = new JTabbedPane();
      this.tabs.setBounds(5, 5, this.maxWidth - 10, this.maxHeight - 40);

      JPanel p = new JPanel();
      p.setBounds(5, 5, this.tabs.getWidth() - 10, this.tabs.getHeight() - 20);
      p.setLayout(null);
      p.add(getPanelCommons());
      p.add(getPanelLectures());

      JButton cont = new JButton("Start");
      cont.setBounds(5, 375, p.getWidth() - 10, 30);
      cont.addActionListener(this);
      cont.setActionCommand("startTasks");

      p.add(cont);

      tabs.addTab("Auswahl", p);

      p = new JPanel();

      tabs.addTab("Aufgaben", initTaskPanel());


      p = new JPanel();

      tabs.addTab("Ergebnis", initResultPanel());

      tabs.setEnabled(false);
      tabs.setSelectedIndex(0);
   }


   private JPanel initResultPanel() {
      JPanel resultPanel = new JPanel();
      resultPanel.setLayout(null);
      resultPanel.setBounds(5, 5, this.tabs.getWidth() - 10, this.tabs.getHeight() - 20);

      resultLabel.setText("");
      resultLabel.setBounds(5, 10, resultPanel.getWidth() - 10, 40);
      resultPanel.add(resultLabel);

      resultTable = new JTable();

      JScrollPane scroll = new JScrollPane(resultTable);
      scroll.setBounds(5, 60, resultPanel.getWidth() - 10, 170);

      resultPanel.add(scroll);

      JButton redo = new JButton("Nochmal");
      redo.addActionListener(this);
      redo.setActionCommand("redo");
      redo.setBounds(5, 250, resultPanel.getWidth() - 10, 40);

      resultPanel.add(redo);

      return resultPanel;
   }


   private JPanel initTaskPanel() {
      JPanel p = new JPanel();
      p.setLayout(null);
      p.setBounds(5, 5, this.tabs.getWidth() - 10, this.tabs.getHeight() - 20);

      this.currentTaskText = new JLabel("");
      this.currentTaskText.setBounds(10, 10, p.getWidth() - 20, 140);

      p.add(this.currentTaskText);

      this.currentResult = new JTextField(70);
      this.currentResult.setBounds(10, 160, p.getWidth() - 20, 140);
      this.currentResult.addKeyListener(this);

      p.add(this.currentResult);

      JButton cont = new JButton("Weiter");
      cont.setBounds(10, 320, p.getWidth() - 20, 30);
      cont.addActionListener(this);
      cont.setActionCommand("nextTask");

      p.add(cont);

      return p;
   }


   private void loadPlugins(String pathToLibs) {
      this.loadedPlugins = new ArrayList<>();

      File libs = new File(pathToLibs);

      for (File f : libs.listFiles(new LibFileFilter())) {
         JarFile j;
         try {
            j = new JarFile(f);
            Enumeration<JarEntry> e = j.entries();
            while (e.hasMoreElements()) {
               JarEntry entry = e.nextElement();
               if (entry.getName().contains("PluginInfo.class")) {
                  loadPlugin(f, entry.getName().replaceAll("/", ".").replaceAll("\\\\", ".").replaceAll(".class", ""));
                  break;
               }
            }
         }
         catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
      }
   }


   private void loadPlugin(File jarArchive, String pluginInfoClassName) {
      try {
         URLClassLoader cl = new URLClassLoader(new URL[] {jarArchive.toURL()}, this.getClass().getClassLoader());
         PluginInfo pluginInfo = (PluginInfo)Class.forName(pluginInfoClassName).newInstance();
         loadedPlugins.add(pluginInfo);

      }
      catch (MalformedURLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (InstantiationException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (IllegalAccessException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }


   protected JPanel getPanelCommons() {
      JPanel panelCommons = new JPanel();
      panelCommons.setLayout(null);
      panelCommons.setBorder(new TitledBorder("Allgemein"));
      panelCommons.setBounds(5, 5, this.tabs.getWidth() - 10, 80);

      JLabel l = new JLabel("Aufgabenzahl");
      l.setBounds(5, 15, 150, 25);

      panelCommons.add(l);

      textNumberOfTasks = new JTextField(10);
      textNumberOfTasks.setBounds(170, 15, 160, 25);
      textNumberOfTasks.setText("10");

      panelCommons.add(textNumberOfTasks);

      return panelCommons;
   }


   protected JTabbedPane getPanelLectures() {
      JTabbedPane panelLectures = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
      panelLectures.setBounds(5, 90, this.tabs.getWidth() - 10, 280);
      panelLectures.setBorder(new TitledBorder("Fächer"));

      panelLectures.removeAll();
      for (PluginInfo pluginInfo : loadedPlugins) {
         panelLectures.addTab(pluginInfo.getPluginName(), pluginInfo.getTaskConfigPanel());
      }

      return panelLectures;
   }


   @Override
   public void mouseClicked(MouseEvent e) {
      // TODO Auto-generated method stub

   }


   @Override
   public void mousePressed(MouseEvent e) {
      // TODO Auto-generated method stub

   }


   @Override
   public void mouseReleased(MouseEvent e) {
      // TODO Auto-generated method stub

   }


   @Override
   public void mouseEntered(MouseEvent e) {
      // TODO Auto-generated method stub

   }


   @Override
   public void mouseExited(MouseEvent e) {
      // TODO Auto-generated method stub

   }


   @Override
   public void windowOpened(WindowEvent e) {
      // TODO Auto-generated method stub

   }


   @Override
   public void windowClosing(WindowEvent e) {
      // TODO Auto-generated method stub
      deinit();
   }


   @Override
   public void windowClosed(WindowEvent e) {
      // TODO Auto-generated method stub
   }


   @Override
   public void windowIconified(WindowEvent e) {
      // TODO Auto-generated method stub

   }


   @Override
   public void windowDeiconified(WindowEvent e) {
      // TODO Auto-generated method stub

   }


   @Override
   public void windowActivated(WindowEvent e) {
      // TODO Auto-generated method stub

   }


   @Override
   public void windowDeactivated(WindowEvent e) {
      // TODO Auto-generated method stub

   }


   public static void main(String[] args) {
      new LittleProfessor(args);
   }


   @Override
   public void actionPerformed(ActionEvent e) {
      String cmd = e.getActionCommand();

      if ("startTasks".equals(cmd))
         startTasks();

      else if ("nextTask".equals(cmd))
         nextTask();

      else if ("redo".equals(cmd))
         redo();
   }


   private void redo() {
      this.tabs.setSelectedIndex(0);
   }


   private void nextTask() {
      if (this.currentTask >= 0) {
         stopWatch.stop();
         this.taskList.get(this.currentTask).setGivenResult(this.currentResult.getText());
         this.taskList.get(this.currentTask).setTaskDuration(stopWatch.getElapsedTime());
      }

      int maxTasks = this.taskList.size();
      this.currentTask++ ;

      if (this.currentTask >= maxTasks) {
         allTasksDone();
         return;
      }

      this.currentTaskText.setText(this.taskList.get(this.currentTask).getTask());
      this.currentResult.setText("");
      stopWatch.reset();
      stopWatch.start();
   }


   private void allTasksDone() {
      this.tabs.setSelectedIndex(2);

      long duration = 0;
      int correctTasks = 0;
      for (Task t : this.taskList) {
         duration += t.getTaskDuration();
         if (t.isCorrect())
            correctTasks++ ;
      }

      this.resultLabel.setText(getResultText(correctTasks, taskList.size(), duration));

      DefaultTableModel dataModel = new DefaultTableModel(taskList.size(), 4);

      dataModel.setColumnIdentifiers(new String[] {"Aufgabe", "gegebene Lösung", "Lösung", "", "Zeit"});

      int i = 0;
      for (Task t : this.taskList) {
         dataModel.setValueAt(t.getTask(), i, 0);
         dataModel.setValueAt(t.getGivenResult(), i, 1);
         dataModel.setValueAt(t.getResult(), i, 2);
         dataModel.setValueAt((t.isCorrect() ? "richtig" : "falsch"), i, 3);
         dataModel.setValueAt(formatDuration(t.getTaskDuration()), i, 4);

         i++ ;
      }

      this.resultTable.setModel(dataModel);
      this.resultTable.setDefaultRenderer(Object.class, new MyTableCellRender());
   }


   private String getResultText(int correctTasks, int size, long duration) {
      StringBuilder sb = new StringBuilder("Du hast ");
      sb.append(correctTasks);
      sb.append(" von ");
      sb.append(size);
      sb.append(" Aufgabe(n) richtig.\nDafür hast du ");
      sb.append(formatDuration(duration));
      sb.append(" benötigt.");

      sb.append("\nDas wäre eine ");
      sb.append(calculateNote(correctTasks, size));
      sb.append(" gewesen.");

      return sb.toString();
   }


   private Object calculateNote(int correctTasks, int size) {
      int pro = (int)(correctTasks * 100 / size);

      if (pro >= 96)
         return "1 (sehr gut)";
      else if (pro >= 80)
         return "2 (gut)";
      else if (pro >= 60)
         return "3 (befriedigend)";
      else if (pro >= 45)
         return "4 (ausreichend)";
      else if (pro >= 16)
         return "5 (mangelhaft)";
      else
         return "6 (ungenügend)";
   }


   private String formatDuration(long duration) {
      if (duration <= 0)
         return "0 ms";

      long ms = duration % 1000;
      duration /= 1000;
      long s = duration % 60;
      duration /= 60;
      long m = duration % 60;
      duration /= 60;

      return String.format("%d:%02d:%02d.%03d", duration, m, s, ms);

   }


   private void startTasks() {

      ArrayList<TaskType> availTasks = new ArrayList<>();

      for (PluginInfo p : this.loadedPlugins) {
         availTasks.addAll(p.getSelectedTasks());
      }


      taskList = new ArrayList<>();
      int count = Integer.parseInt(this.textNumberOfTasks.getText());

      for (int i = 0; i < count; i++ ) {
         taskList.add(availTasks.get(new Random().nextInt(availTasks.size())).generateTask());
      }

      this.tabs.setSelectedIndex(1);

      this.currentTask = -1;
      nextTask();
      this.startDate = new java.util.Date();
   }


   @Override
   public void keyTyped(KeyEvent e) {
      // TODO Auto-generated method stub

   }


   @Override
   public void keyPressed(KeyEvent e) {
      // TODO Auto-generated method stub

   }


   @Override
   public void keyReleased(KeyEvent e) {
      if (e.getComponent().equals(this.currentResult))
         if (e.getKeyCode() == 10)
            nextTask();
   }


   private class MyTableCellRender extends DefaultTableCellRenderer {

      public MyTableCellRender() {
         setOpaque(true);
      }


      public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
         if ("richtig".equals(table.getValueAt(row, 3))) {
            setBackground(Color.GREEN);
         }
         else {
            setBackground(Color.RED);
         }
         setText(value != null ? value.toString() : "");
         return this;
      }
   }
}
