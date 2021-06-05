package javaBeginner;
import java.util.Scanner;



public class BankApplication {
	public static void main(String[] args) {
		BankAccount obj1 =new BankAccount("pallavi" ,"3200012");
		obj1.showmManue();
		
	}

}
class BankAccount{
	int balance;
	int previousTransation;
	String costomberID;
	String costomberName;
	
	
	BankAccount(String cName ,String cId){
		costomberName=cName;
		costomberID=cId;
	}
	
	void diposit(int amount) {
		
		if(balance!=0) {
			balance=balance+amount;
			previousTransation=amount;
			
			
		}}
		void withdraw(int amount) {
			if(balance!=0) {
				balance=balance-amount;
				previousTransation=-amount;
			
		}
	}
		void getprivioustransation() {
			if(previousTransation > 0) {
				System.out.println("Diposit:"+previousTransation);
		}
		if(previousTransation < 0) {
			System.out.println("Withdrawn :"+Math.abs(previousTransation));
		}
		else {
			System.out.println("No transation occured:");
			
		}
		
		
}
	void showmManue()	{
		char option=0;
		Scanner scanner =new Scanner(System.in);
		
		System.out.println("WELLCOME TO OUR BANK ");
		System.out.println("Costomber Name is :"+costomberName);
		System.out.println("CostomberID is :"+costomberID);
		System.out.println("\n");
		System.out.println("A. check Balance");
		System.out.println("B. Diposit");
		System.out.println("C. Withdraw");
		System.out.println("D.Previous Transation");
		System.out.println("E. Exit");
		
		
		do {
			System.out.println("=================================");
			System.out.println("Enter Your Option");
			System.out.println("=================================");
			
			option=scanner.next().charAt(0);
			System.out.println("\n");
			
			switch(option) {
			case 'A':	
				System.out.println("-----------------------------------");
				System.out.println("Balance :"+balance);
				System.out.println("-----------------------------------");
				System.out.println("\n");
				break;
			case 'B':
				System.out.println("----------------------------");
				System.out.println("Enter an Amount to Diposit");
							System.out.println("--------------------"); 
							int amount=scanner.nextInt();
							diposit(amount);
							System.out.println("\n");
							break;
			case 'C':
							System.out.println("------------------------------");
							System.out.println("Enter an Amount to Withdraw");
							System.out.println("----------------------------------");
							int amount2=scanner.nextInt();
							withdraw(amount2);
							System.out.println("\n");
							break;
			case 'D':
				System.out.println("------------------------------------");
				getprivioustransation();
				System.out.println("------------------------------------");
				System.out.println("\n");
				break;
				default:
					System.out.println("Invalid Option ! Enter Correct Option");
				break;
				case 'E':	
				System.out.println(" Bye Bye");
				System.out.println("THANK YOU FOR USING OUR SERVISE ");
				
			}
			
		}while(option!='E');
			
		//System.out.println("THANK YOU FOR USING OUR SERVISE ");
		
		
	}
	}	












