package javalab1;

public class patternd {
	public static void main(String[] args) {
	int Rows = 7; 
        for (int i = Rows; i >= 1; i--) 
        {
            char ch = 'A'; 
            for (int j = 0; j <= Rows-i; j++)
            {
                System.out.print("  ");       
                }
            for(int k=1;k<=i;k++)
            {
            System.out.print(ch + " ");
            	ch++;      
            	}
            System.out.println(); 
            } 
         }   
      }

