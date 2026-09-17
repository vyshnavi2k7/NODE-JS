package javalab1;

public class patternb {

public static void main(String[] args)
{
   int rows=7;
   int k;
   for(int i=1; i<=rows; i++)
   {
  	 for(int j=1; j<=rows-i; j++) 
  	 {
  	 System.out.print("  ");   
  	 }
  	 for(k=1; k<=i; k++) 
  	 {
  	 System.out.print("* ");
  	 }
  	 System.out.println();     
  	 }
}
}
