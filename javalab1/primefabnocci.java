package javalab1;
import java.util.Scanner;

public class primefabnocci {

    public static void main(String[] args)     {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.print("Prime Fibonacci numbers: ");
        int a = 0, b = 1;
        while (a <= n) 
        {
            if (a >= 2)
            {
                boolean isPrime = true;
                for (int i = 2; i <= a / 2; i++)  
                {
                    if (a % i == 0) 
                    {
                        isPrime = false;
                        break;  
                        }
                }
                if (isPrime) {
                    System.out.print(a + " ");   }
            }
            int c = a + b;
            a = b;
            b = c;   }
        sc.close();   }
}
