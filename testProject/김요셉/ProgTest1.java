package ±è¿ä¼Á;

public class ProgTest1 {
   static int cVar;

   String iStr[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
   Double iDouble;
   boolean iBool = false;
   char iChar = 'a';

   String getGugudan(int dan) {   
      String str = "";
      if (dan > 0) {
         for (int i = 1; i <= 9; i++) {

            str += dan + "*" + i + "=" + String.valueOf(dan * i)+"\t";   
       
         }
      }
      return str;      
   }
}

