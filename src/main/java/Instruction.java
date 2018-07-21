public class Instruction  implements  java.io.Serializable {
     private  Integer line = 0;
     private  StreamOp  creator;
      public  Instruction setLine(Integer line)
      {
           this.line =  line;
           return  this;
      };
      public  Instruction(StreamOp hello)
      {
          this.creator = hello;
      }
}
