package pro.controller;

import java.util.ArrayList;
import java.util.List;

import pro.model.*;

public class validate {
    public static String email(String m,String p)
    {
        if(m.contains("@gmail.com") && p.length()>=8)
        {
            String str=user.signindb(m, p);
            return str;
        }
        return "null";
    }

    public static String email(String n,String m,String p)
    {
        if(m.contains("@gmail.com") && p.length()>=8)
        {
            String str=user.signupdb(n,m,p);
            return str;
        }
        return "null";
    }

    public static String selname(String s)
    {
        if(s.isEmpty())
        {
            return "null";
        }
        else
        {
            String str=sell.sdetail(s);
            return str;
        }
    }

    public static String add(String n,String p,String d,String m, String a)
    {
        if(m.length()==10 && a.length()>0)
        {
            if(n.isEmpty() || p.isEmpty() || d.isEmpty())
            {
                return "null";
            }
            else
            {
                String str=pet.addpet(n,p,d,m,a);
                return str;
            }
        }
        return "Enter Valid Information";
    }

    public static String pd(String st,String pn,String c,String g,String a,String p)
    {
        if(pn.isEmpty() || c.isEmpty() || g.isEmpty() || a.isEmpty() || p.isEmpty())
        return "Enter valid details";
        else
        {
            String str=pet.pettable(st,pn,c,g,a,p);
            return str;
        }
    }

    public static String ch(String n,String m,String a)
    {
        if(n.isEmpty() || m.length()!=10 || a.isEmpty())
        return "Enter valid details";
        else
        {
            String str=sell.check(n,m,a);
            return str;
        }
    }

    public static List<details> viewp(String n)
    {
        if(n.length()!=0)
        {
            List<details> str=display.petdet(n);
            return str;
        }
        else
        return null;
    }
}
