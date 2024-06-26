package pro.view;

import pro.controller.validate;
import java.util.*;

public class seller {
    public static void page(String g)
    {
        Scanner sc=new Scanner(System.in);
        String str=validate.selname(g);
        System.out.println();
        System.out.println("Your Post");
        System.out.println(str);
        System.out.println();
        // System.out.println("Enter 1 to Buy / Add pets :");
        // int a=sc.nextInt();

        
    }
    
}
