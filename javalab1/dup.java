package javalab1;

import java.util.Arrays;
public class dup {
	public static void main(String[] args) {
        int[] numbers = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Input Array: " + Arrays.toString(numbers));
        System.out.print("Duplicate values: ");
        for (int i = 0; i < numbers.length; i++)   
        {
            for (int j = i + 1; j < numbers.length; j++)    
            {
                if (numbers[i] == numbers[j])    
                {
                    System.out.print(numbers[i] + " ");
                    break;      
                    }
            }
        }     
        }
	}
