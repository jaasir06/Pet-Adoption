package pro.model;

import java.sql.*;

public class pet {
    static db db=new db();
    static Connection con;

    static{
        try{
            con=db.getConnection();
        }
        catch(SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public static String addpet(String n,String p, String d, String m, String a)
    {
        try{
            String sql="insert into seller (s_name,p_name,date,mobile,address) values(?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, n);
            ps.setString(2, p);
            ps.setString(3, d);
            ps.setString(4, m);
            ps.setString(5, a);
            int res=ps.executeUpdate();
            if(res>0)
            {
                String qry="select s_id from seller where mobile = ? and s_name = ? ";
                PreparedStatement pr=con.prepareStatement(qry);
                pr.setString(1, m);
                pr.setString(2, n);
                ResultSet rs=pr.executeQuery();
                if(rs.next())
                {
                    String id = rs.getString("s_id");
                    String str=id;
                    return str;
                }

                // return "User Added Successfully";
            }
            else
            {
                return "Try Again";
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static String pettable(String st,String pn,String c, String a, String g, String p)
    {
        try{
            String sql="insert into pet (s_id,p_name,p_color,p_gender,p_DOB,price ) values(?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, st);
            ps.setString(2, pn);
            ps.setString(3, c);
            ps.setString(4, a);
            ps.setString(5, g);
            ps.setString(6, p);
            int res=ps.executeUpdate();
            if(res>0)
            {
                return "PET Added Successfully";
            }
            else
            {
                return "Try Again";
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
