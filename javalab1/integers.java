
package javalab1;
import java.util.Scanner;
public class integers 
{
	public static void main(String[] args) 
	{
		Scanner sum = new Scanner(System.in);
		 System.out.print("How many integers do you want to enter? ");
	        int count = sum.nextInt();
	        int evenSum = 0;
	        int oddSum = 0;
	        for (int i = 0; i < count; i++)     {
	            System.out.print("Enter integer " + (i + 1) + ": ");
	            int num = sum.nextInt();
	            if (num % 2 == 0)   {
	                evenSum += num;  } 
	            else  {
	                oddSum += num;   }
	        }
	        System.out.println("Sum of even integers: " + evenSum);
	        System.out.println("Sum of odd integers: " + oddSum);
	        sum.close();
	}        
}
