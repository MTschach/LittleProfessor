package de.mss.littleprofessor.math;


public enum Operation {
   NONE("", 0),
   ADDITION("+", 1),
   SUBTRACTION("-", 1),
   MULTIPLY("*", 2),
   DIVIDE("/", 2);


   private String operation      = null;
   private int    operationLevel = 0;


   private Operation(String o, int ol) {
      this.operation = o;
      this.operationLevel = ol;
   }


   public String getOperation() {
      return this.operation;
   }


   public int getOperationLevel() {
      return this.operationLevel;
   }


   public static Operation getByOperation(String o) {

      for (Operation op : Operation.values())
         if (op.getOperation().equals(o))
            return op;

      return Operation.ADDITION;
   }
}
