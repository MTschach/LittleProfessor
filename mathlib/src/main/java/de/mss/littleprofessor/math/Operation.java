package de.mss.littleprofessor.math;


public enum Operation {
   ADDITION("+"),
   SUBTRACTION("-"),
   MULTIPLY("*"),
   DIVIDE("/");


   private String operation = null;


   private Operation(String o) {
      this.operation = o;
   }


   public String getOperation() {
      return this.operation;
   }


   public static Operation getByOperation(String o) {

      for (Operation op : Operation.values())
         if (op.getOperation().equals(o))
            return op;

      return Operation.ADDITION;
   }
}
