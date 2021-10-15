package hackerrank;
import java.util.Scanner;
public class OutputFormate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		            @SuppressWarnings("resource")
					Scanner obj =new Scanner(System.in);
		            System.out.println("================================");
		            System.out.println("Enter your output which you want to print in the form of string and Integer");
		            for(int i=0;i<3;i++){
		                String s1=obj.next();
		                int x= obj.nextInt();
		 
		                System.out.printf("%-15s%03d",s1,x);
		            }
		            
		            System.out.println("================================");

		    }
	}


