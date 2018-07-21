package com.count;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

public class OrderByMain {
   public  int[] getCorrectOrder(int[] A)
   {

       int[] B = new int[A.length];//[9,8,5,4]
       for(int i = 0; i <A.length; i++ )
       {
           for(int j = A.length-1;j>i;j-- ) {
               if (A[i] > A[j]) {
                   int tempA = A[i];
                   A[i] = A[j];
                   A[j] = tempA;
               }
           }
       }
       return  A;
   }
   @Test
   public  void Result() {
       int[] input = new int[]{9,8,5,4,55,74,42,587};
       int[] x = new OrderByMain().getCorrectOrder(input);
       System.out.println(x[0]);

   }

}
