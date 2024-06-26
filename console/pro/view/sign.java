package pro.view;
import java.util.*;

import pro.controller.validate;
import pro.model.details;
import pro.model.display;
import pro.model.sell;
import pro.model.user;
public class sign {
    static String mail;
    static String id="";
    static int f2=0;
    public static void signup()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("--------------------------------------------------------");
        System.out.println("                 *** Welcome to sign-up page ***");
        System.out.println();
        
        System.out.println("Enter user name: ");
        String name=sc.nextLine();
        System.out.println();
        
        System.out.println("Enter e-mail: ");
        mail=sc.nextLine();
        System.out.println();
        
        System.out.println("Enter password of atleast 8 characters : ");
        String pass=sc.nextLine();
        System.out.println();
        
        String ret=validate.email(name,mail,pass);
        
        if(!ret.equals("null"))
        {
            System.out.println(ret);
            System.out.println("--------------------------------------------------------");
            System.out.println();
    
            sign.home(mail);
        }
        else
        {
            System.out.println("!!!   Enter Valid Details    !!!");
            signup();
        }
    }
    public static void signin()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.println("                 *** Welcome to sign-in page ***");
        System.out.println();
        
        System.out.println("Enter e-mail: ");
        mail=sc.nextLine();
        System.out.println();
        
        System.out.println("Enter password of atleast 8 characters :");
        String pass=sc.nextLine();
        System.out.println();

        String str=validate.email(mail,pass);
        if(!str.equals("null"))
        {
            System.out.println("--------------------------------------------------------");
            System.out.println();
            
            String g[]=str.split(" ");
            System.out.println("           welcome "+g[0]);
            // System.out.println(str);
            System.out.println();
            if(g[1].equals("seller"))
            {
                seller.page(g[0]);
                f2=1;
            }
            sign.home(mail);
        }
        else
        {
            System.out.println("!!!   Enter Valid Information   !!!");
            signin();
        }
    }

    public static void home(String m)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1 to add pets  ||  Enter 2 to buy pets  ||  Enter 3 to Exit");
        int n=sc.nextInt();
        System.out.println();
        if(n==1)
        {
            if(user.selbuy(n,m))
            {
                String str=pets.adpet();
                System.out.println();
                System.out.println("--- Enter Pet Details ---");
                System.out.println();
                String st=pets.details(str);
                System.out.println(st);
                System.out.println();
                f2=1;
                home(mail);
            }
        }  
        else if(n==3)
        System.exit(0);
        else if(n==2)
        {
            // System.out.println("Buyer");
             
            ArrayList dis=display.table();
            Object a[]=dis.toArray();
            System.out.println("---------------- PET ---------------- ");
            System.out.println();
            System.out.println("NAME   |  COLOUR | GENDER | D-O-B | PRICE | AVAILABILITY");
            System.out.println();
            for(int i=0;i<a.length;i++)
            {
                System.out.println(a[i]);
                System.out.println();
            }
            sc.nextLine();
            System.out.println("Enter the pet name you want : ");
            String name=sc.nextLine();
            System.out.println();
            List<details> al=validate.viewp(name);
            Iterator itr=al.iterator();
            System.out.println("---------------- PET DETAILS ----------------");
            System.out.println();
            System.out.println("SELLER ID |  NAME | COLOUR | GENDER | D-O-B | PRICE | AVAILABILITY");
            System.out.println();
            while(itr.hasNext())
            {
                details dt= (details) itr.next();
                String l=dt.getsid().toString();
                if(l.length()>0)
                id+=l+" ";
                System.out.println("    "+dt.getsid()+"  |  "+dt.getname()+" | "+dt.getcolour()+" | "+dt.getgender()+" | "+dt.getDOB()+" | "+dt.getprice()+" | "+dt.getavailable());
                System.out.println();
            }
            // System.out.println(al+" "+al.size());
            // String str=validate.viewp(name);
            if(al.size()>=1)
            {
                System.out.println();
                System.out.println("Enter * SELLER ID * to view the details of Pet Owner :");
                String id1=sc.nextLine();
                String v1=display.val(id1);
                String v2=user.val(mail);
                String st=display.seldet(id1);
                System.out.println();
                System.out.println();
                System.out.println("---------------- OWNER DETAILS ----------------");
                System.out.println();
                System.out.println("SELLER NAME | MOBILE | ADDRESS");
                System.out.println(st);

                System.out.println();
                
                System.out.println("Enter 1 book the pet   ||   Enter 2 view more pets");
                int b=sc.nextInt();
                if(b==1)
                {
                    if(v1.equals(v2))
                    System.out.println("Sorry");
                    else
                    {
                        System.out.println("--- Thank You For Booking ---");
                        String d=sell.updt(id1);
                        System.out.println(d);
                    }
                    home(m);
                }
                else
                home(m);
            }
            else
            {
                System.out.println(name+" Not Available -> You Can View More");
                home(m);
            }

        }
        else
        {
            System.out.println("!  Enter Valid Number to Continue...");
            home(m);
        }
        home(m);
    }
}
