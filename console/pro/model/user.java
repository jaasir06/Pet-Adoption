package pro.model;

import java.sql.*;

public class user {
    static db db = new db();
    static Connection con;

    static {
        try {
            con = db.getConnection();
        } 
        catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static String  signindb(String m,String p)
    {
        try{
            String sql="select * from user where email=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, m);
            ResultSet res=ps.executeQuery();
            if(res.next())
            {
                String n=res.getString("name");
                String pas=res.getString("pass");
                String r=res.getString("role");
                String str=n+" "+r+" "+m;
                if(p.equals(pas))
                {
                    return str;
                }
                else 
                return "null";
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "null";
    }



    public static String signupdb(String n,String m,String p)
    {
        try{
            String sql="insert into user (name,email,pass) values(?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, n);
            ps.setString(2, m);
            ps.setString(3, p);
            int rs=ps.executeUpdate();
            if(rs>0)
            {
                return "User Added Succesfully";
            }
            else
            return "Try again";
        }
        catch(SQLException e)
        {
            e.printStackTrace();  
        }
        return "Try again";
    }


    public static boolean selbuy(int a,String mail)
    {
        try{
            String g="";
        if(a==1)
        g="seller";
        else
        g="buyer";
        String sql="UPDATE user SET role=? where email=?";
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setString(1, g);
        stmt.setString(2, mail);
        int rt=stmt.executeUpdate();
        if(rt>0)
        return true;
        return false;
        
        }
        catch(SQLException e){
        e.printStackTrace();
        }
        return false;

    }

    public static String val(String m)
    {
        try{
            String sql="select * from user where email=? ";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, m);
            ResultSet res=ps.executeQuery();
            if(res.next())
            {
                String sn=res.getString("name");
                return sn;
            }
            // return "null";
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return "No User Found";
    }

}
