package pro.model;

import java.sql.*;
public class sell  {
    static db db=new db();
    static Connection con;

    static {
        try{
            con=db.getConnection();
        }

        catch(SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    public static String sdetail(String s)
    {
        try{
            String sql="select * from seller where s_name=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, s);
            ResultSet res=ps.executeQuery();
            if(res.next())
            {
                String name = res.getString("p_name");
                String sname = res.getString("s_name");
                // String available = res.getString("isavailable");
                String date = res.getString("date");
                String str=name+" "+date;
                if(sname.equals(s))
                {
                    return str;
                }
                else
                return null;
            }
        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "null";
    }

    public static String check(String n,String m,String a)
    {
        try{
            String sql="select * from seller where s_name=? and mobile=? and address=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, n);
            ps.setString(2, m);
            ps.setString(3, a);
            ResultSet res=ps.executeQuery();
            if(res.next())
            {
                String name = res.getString("s_name");
                String mob = res.getString("mobile");
                String add = res.getString("address");
                String id = res.getString("s_id");
                if(name.equals(n) && mob.equals(m) && add.equals(a))
                return id;
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

    public static String updt(String id)
    {
        try{
            String sql="UPDATE pet SET isavailable= 'booked' where s_id=?";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, id);
            int rt=stmt.executeUpdate();
            if(rt>0)
            return "Successfully booked";
            return "Try Again";
        
        }

        catch(SQLException e){
        e.printStackTrace();
        }
        return null;
    }
}
