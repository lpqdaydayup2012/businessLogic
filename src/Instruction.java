public class Instruction  implements  java.io.Serializable {
     private  Integer line = 0;
     private  Hello  creator;
      public  Instruction setLine(Integer line)
      {
           this.line =  line;
           return  this;
      };
      public  Instruction(Hello hello)
      {
          this.creator = hello;
      }
}
