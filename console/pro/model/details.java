package pro.model;

public class details {
    private String p_id;
    private Object  s_id;
    private String p_name, p_color, p_gender, p_DOB, price, isavailable;
    public void setpid(String p_id)
    {
        this.p_id=p_id;
    }
    public void setsid(Object s_id)
    {
        this.s_id=s_id;
    }
    public void setname(String p_name)
    {
        this.p_name=p_name;
    }
    public void setcolour(String p_color)
    {
        this.p_color=p_color;
    }
    public void setgender(String p_gender)
    {
        this.p_gender=p_gender;
    }
    public void setDOB(String p_DOB)
    {
        this.p_DOB=p_DOB;
    }
    public void setprice(String price)
    {
        this.price=price;
    }
    public void setavailable(String isavailable)
    {
        this.isavailable=isavailable;
    }

    public String getpid()
    {
        return p_id;
    }
    public Object getsid()
    {
        return s_id;
    }
    public String getname()
    {
        return p_name;
    }
    public String getcolour()
    {
        return p_color;
    }
    public String getgender()
    {
        return p_gender;
    }
    public String getDOB()
    {
        return p_DOB;
    }
    public String getprice()
    {
        return price;
    }
    public String getavailable()
    {
        return isavailable;
    }
    
}

