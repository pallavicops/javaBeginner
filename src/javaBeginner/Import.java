package javaBeginner;
/*import java.util.Scanner;

import com.sun.net.httpserver.Authenticator.Result;


public class Import {
	public static void main(String[] args) {
Scanner myObj=new Scanner(System.in);
String userName;
System.out.println("enter ypur Name ");
userName=myObj.nextLine();
System.out.println("UserName is :"+ userName);
System.out.println("Enter your age");
Scanner myObjt=new Scanner(System.in);
int userAge;
userAge=myObjt.nextInt();
ReSult.close();
System.out.println("UserAge is :"+userAge);

}
}
*/
import java.util.Scanner;

public class Import{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       
        int i = scan.nextInt();
        
        double d = scan.nextDouble();
        
       String s = scan.nextLine();
        // gWrite your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
