import  java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class main {
    public  static  void  main(String[] args)
    {
        Integer[] _int = new Integer[5];
        _int[0] = 5;

        Integer result[] = new Integer[10];

        AtomicLong  l = new AtomicLong();
        l.set(154515455);

        String[][] str = new String[0][1];


        // create and assign values to String's s1, s2
        String s1 = "TRue";
        String s2 = "yes";

        // create 2 boolean primitives bool1, bool2
        boolean bool1, bool2;

        /**
         *  static method is called using class name
         *  apply result of parseBoolean on s1, s2 to bool1, bool2
         */
        bool1 = Boolean.parseBoolean(s1);
        bool2 = Boolean.parseBoolean(s2);

        String str1 = "Parse boolean on " + s1 + " gives "  + bool1;
        String str2 = "Parse boolean on " + s2 + " gives "  + bool2;

        // print b1, b2 values
        System.out.println( str1 );
        System.out.println( str2 );

    }
}
