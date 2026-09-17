package javalab1;

public class patterne 
{
	public static void main(String[] args) {
		int rows=7;
		for(int i=1;i<=rows;i++) 
		{
			int num=1;
			for(int j=0;j<i;j++)
			{
				System.out.print(num + " ");
				num++;
			System.out.println();	
			}
		for(i= rows-1;i>=1;i--) 
		{
			int num=1;
			for(j=0;j<i;j++)
			{
				System.out.print(num + " ");
				num++;		
				}
			System.out.println();  
			} 
		}
                    }
}
