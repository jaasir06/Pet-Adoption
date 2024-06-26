package pro.view;

import java.util.*;

public class index {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println();
        System.out.println("               * ----- Pet  Adoption ----- *");
        System.out.println();
        System.out.println(     " Enter 1 for sign-up           Enter 2 for sign-in ");
        System.out.println();
        int a=sc.nextInt();
        if(a==1)
        sign.signup();
        else if(a==2)
        sign.signin(); 
        else
        {
            System.out.println("Enter Valid Number ");
            main(args);
        }

    }
}

