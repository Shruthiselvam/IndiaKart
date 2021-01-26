<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%!
    Connection con,con1;
    PreparedStatement ps1, ps2,ps3,ps4;
    public void jspInit()
    {
        try
        {
            //loading the driver
            Class.forName("com.mysql.jdbc.Driver");
            //establish the connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/registeruser","root","");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3307/orderdetails","root","");
            //create statement object
            ps1 = con.prepareStatement("select count(*) from registeruser where email = ? and password=?");
            ps2 = con.prepareStatement("select * from registeruser");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
%>
<%
    out.println("<a style='float:right;' href='index.html'>home</a>");
    String param = request.getParameter("s1");
    if(param =="link")
    {
        ResultSet rs = ps2.executeQuery();
        out.println("<table>");
        while(rs.next())
        {
            out.println("<tr>");
            out.println("<td>"+rs.getString(1)+"</td>");
            out.println("<td>"+rs.getString(2)+"</td");
            out.println("</tr>");
        }
        out.println("</table>");
        rs.close();
    }
    else
    {
        //write jdbc code for authentication
        String ema = request.getParameter("email");
        String pass = request.getParameter("pwd");
        //set form data as param value
        HttpSession sess = request.getSession(); 
sess.setAttribute("ema", ema);
        
        ps1.setString(1,ema);
        ps1.setString(2,pass);
        //excute the query
        ResultSet rs = ps1.executeQuery();
        int cnt = 0;
        if (rs.next())
        cnt = rs.getInt(1);
        if(cnt == 0)
            out.println("<b><i><font color=red>Invalid credential</fonr></i></b>");
        else
        {
         
    ps3 = con.prepareStatement("select * from registeruser where email='"+ema+"'");
    ps4=con1.prepareStatement("select * from ordertable where email='"+ema+"'");
//out.print("success");
rs = ps3.executeQuery();
ResultSet rs1=ps4.executeQuery();
con.setAutoCommit(false);
con.commit();
rs.next();

//String email=rs.getString("email");
out.println("<html><head><div class='toppane' style='text-align:center;background-color:deeppink;'><h1 style='height:50px;'>IndiaKart</h1></div></head>");
           out.println("<body style='width:100%;height:100%;background-color:azure;'>");
          out.println("<div class='leftpane' style='width:300px; height:100%;float:left;border-collapse: collapse;background-color:azure;'><h3>Personal Details</h3><br/>Name:"+rs.getString("name")+"<br/>Age:"+rs.getString("age")+"<br/>Gender:"+rs.getString("gender")+"<br/>Email:"+rs.getString("email")+"<br/>Address:"+rs.getString("address")+"</div>");
          rs1.last();
          int cnt1 = 0;
        if (rs1.last())
        cnt1++;
        if(cnt1!=0)
        { out.println("<div class='middlepane' style='width:300px;height:100%; float:left;border-collapse:collapse;background-color:azure; '><h3>Recently Purchased ProductDetails</h3> <br/>Items Purchased:"+rs1.getString("items")+"<br/>Price:"+rs1.getString("price")+"</div>");}
        else{out.println("Welcome to IndiaKart");}   
        out.println("<div class='rightpane' style='width:300px; height:100%; float:right;background-color:azure;'><b><i><font color=red>valid credential..</font></i></b><br>");
            out.println("<a href='http://localhost:8080/sample1/products'>look for products</a></body></div>");
           //out.println("<body><body>");
            out.println("</body></html>");
        }
    }
%>
<%!
    public void jspDestroy()
    {
        try
        {
            //colse
            ps1.close();
            ps2.close();
            con.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
%>