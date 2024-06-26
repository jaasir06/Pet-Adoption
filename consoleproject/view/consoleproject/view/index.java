package consoleproject.view;
import java.util.*;
public class index {
    static void signup()
    {
        System.out.println("*** Welcome to sign-up page ***");
    }
    static void signin()
    {
        System.out.println("*** Welcome to sign-in page ***");
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println(" Enter 1 for sign-up          \n Enter 2 for sign-in ");
        int a=sc.nextInt();
        if(a==1)
        signup();
        else if(a==2)
        signin();
    }
}


