package de.mss.littleprofessor.math;

import java.math.BigInteger;
import java.util.ArrayList;

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

public enum SchoolGradeTasks {

   NONE             (SchoolGrade.NONE,			BigInteger.TEN),
   LITTLEONEBYONE   (SchoolGrade.ONEBYONE,		BigInteger.TEN),
   PRESCHOOL        (SchoolGrade.PRESCHOOL,		BigInteger.TEN),
   FIRSTCLASS       (SchoolGrade.FIRSTCLASS,	BigInteger.TEN),
   SECONDCLASS      (SchoolGrade.SECONDCLASS,	new BigInteger("100")),
   THIRDCLASS       (SchoolGrade.THIRDCLASS,	new BigInteger("100")),
   ALL              (SchoolGrade.FREESETTINGS,	new BigInteger("1000"))
   ;
   
   
   private SchoolGrade schoolGrade      = SchoolGrade.NONE;
   private BigInteger maxValue			= BigInteger.TEN;
   
   private SchoolGradeTasks (SchoolGrade sg, BigInteger mv)
   {
      this.schoolGrade 	= sg;
      this.maxValue    	= mv;
   }
   
   public SchoolGrade getSchoolGrade()
   {
      return this.schoolGrade;
   }
   
   
   public BigInteger getMaxValue()
   {
      return this.maxValue;
   }
   
   
   public static SchoolGradeTasks getBySchoolGrade(SchoolGrade sg)
   {
      for (SchoolGradeTasks sgt : SchoolGradeTasks.values())
         if (sg.equals(sgt.getSchoolGrade()))
            return sgt;
      
      return SchoolGradeTasks.NONE;
   }
}
