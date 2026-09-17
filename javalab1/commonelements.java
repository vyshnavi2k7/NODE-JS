package javalab1;
import java.util.*;
public class commonelements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements in the first array: ");
        int n1 = scanner.nextInt();
        
        String[] array1 = new String[n1];
        System.out.println("Enter elements for the first array:");
        
        for (int i = 0; i < n1; i++) 
        {
            array1[i] = scanner.next();       
            }
        System.out.print("Enter the number of elements in the second array: ");
        int n2 = scanner.nextInt();
        
        String[] array2 = new String[n2];
        System.out.println("Enter elements for the second array:");
        
        for (int i = 0; i < n2; i++) 
        {
            array2[i] = scanner.next();      
            }
        ArrayList<String> commonElements = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (array1[i].equals(array2[j])) {
                    if (!commonElements.contains(array1[i])) {
                        commonElements.add(array1[i]); }
                }
            }
        }
        System.out.println("Common elements: " + commonElements);
        scanner.close();   
        }
}
