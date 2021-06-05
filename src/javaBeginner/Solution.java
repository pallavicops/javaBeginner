package javaBeginner;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner reSult = new Scanner(System.in);
       // Scanner scan=new Scanner(System.in);
       // Scanner scan = new Scanner(System.in);
        int i = reSult.nextInt();
        double d=reSult.nextDouble();
        String S ;
       S =reSult.nextLine();
        // Write your code here.
        reSult.close();
        System.out.println("String: " + S);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}

