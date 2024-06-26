package pro.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class display {
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
    
    public static ArrayList table()
    {
        try{
            String sql="select p_name, p_color, p_gender, p_DOB, price, isavailable from pet";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet res=ps.executeQuery();
            ResultSetMetaData md=(ResultSetMetaData)res.getMetaData();
            int col=md.getColumnCount();
            ArrayList<ArrayList<Object>> al=new ArrayList<>();
            while(res.next())
            {
                ArrayList<Object> row=new ArrayList<>();
                for(int i=1;i<=col;i++)
                {
                    Object data=res.getObject(i);
                    row.add(data);
                }
                al.add(row);
            }      
            return al;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<details> petdet(String n)
    {
        try{
            String sql="select * from pet where p_name=? and isavailable='available' ";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, n);
            ResultSet res=ps.executeQuery();
            List<details> al=new ArrayList<>();
            while(res.next())
            {
                details obj=new details();
                obj.setpid(res.getString("p_id"));
                obj.setsid(res.getString("s_id"));
                obj.setname(res.getString("p_name"));
                obj.setcolour(res.getString("p_color"));
                obj.setgender(res.getString("p_gender"));
                obj.setDOB(res.getString("p_DOB"));
                obj.setprice(res.getString("price"));
                obj.setavailable(res.getString("isavailable"));
                al.add(obj);
                // String str= pid+" "+id+" "+pn+" "+pc+" "+pg+" "+pdob+" "+pr;
                // al.add(str);
            }
                return al;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static String seldet(String id)
    {
        try{
            String sql="select * from seller where s_id=? ";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet res=ps.executeQuery();
            if(res.next())
            {
                String sn=res.getString("s_name");
                String sid=res.getString("s_id");
                String mob=res.getString("mobile");
                String add=res.getString("address");
                String str=sn+"   |  "+mob+"   |  "+add;
                if(sid.equals(id))
                {
                    return str;
                }
                else
                return "Pet Not Available";
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return "Pet Not Available";
    }


    public static String val(String id)
    {
        try{
            String sql="select * from seller where s_id=? ";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet res=ps.executeQuery();
            if(res.next())
            {
                String sn=res.getString("s_name");
                String sid=res.getString("s_id");
                return sn;
            }
            // return "null";
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return "Pet Not Available";
    }
}
