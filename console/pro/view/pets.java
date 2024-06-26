package pro.view;

import pro.controller.validate;
import java.util.*;

public class pets {

    public static String adpet(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name :");
        String n=sc.nextLine();

        System.out.println("Enter Pet name :");
        String p=sc.nextLine();

        System.out.println("Enter Todays Date (yyyy-mm-dd) :");
        String d=sc.nextLine();

        System.out.println("Enter your mobile number : ");
        String m=sc.nextLine();

        System.out.println("Enter your Address : ");
        String a=sc.nextLine();

        String st=validate.ch(n,m,a);
        if(st.equals("null"))
        {
            String str=validate.add(n,p,d,m,a);
            return str;
        }
        else
        return st;

    }

    public static String details(String st){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter your Pet Name : ");
        String pn=sc.nextLine();

        System.out.println("Enter your Pet colour : ");
        String c=sc.nextLine();

        System.out.println("Enter Pet Gender : ");
        String g=sc.nextLine();

        System.out.println("Enter Pet DOB (yyyy-mm-dd) : ");
        String a=sc.nextLine();

        System.out.println("Enter Pet price : ");
        String p=sc.nextLine();

        String str=validate.pd(st,pn,c,g,a,p);
        return str;
    }

}
