
package javalab1;
import java.util.*;
public class cases {
	public static void main(String[] args) 
{
	Scanner cases =new Scanner(System.in);
	int result;
	System.out.println("enter num1&num2:");
	int num1=cases.nextInt();
	int num2=cases.nextInt();
    System.out.println("enter operator(+,-,*,/):");
    char oper=cases.next().charAt(0);
    switch(oper) 
    	{
       case '+':result=num1+num2;  {
             System.out.println("Result="+result);}
           break;
case '-':result=num1-num2; {
    		System.out.println("Result="+result); }
    		break;
       	case '*':result=num1*num2;  {
    		System.out.println("Result="+result);    }
                 break;
      case'/':result=num1/num2;    {
               System.out.println("Result="+result);    }
                    break;
     default:   {
            System.out.println("invalid operator");   }
     cases.close();
       }
 	}
 }

