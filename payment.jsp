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
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/useraccount","root","");
           // con1 = DriverManager.getConnection("jdbc:mysql://localhost:3307/orderdetails","root","");
            //create statement object
            ps1 = con.prepareStatement("select count(*) from account where cardno = ? and pin=?");
            ps2 = con.prepareStatement("select * from account");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
%>
<%
    String param = request.getParameter("s2");
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
        String cd = request.getParameter("cardno");
        String pin = request.getParameter("pin");
        //set form data as param value
        HttpSession sess = request.getSession(); 
sess.setAttribute("cd", cd);
        
        ps1.setString(1,cd);
        ps1.setString(2,pin);
        //excute the query
        ResultSet rs = ps1.executeQuery();
        int cnt = 0;
        if (rs.next())
        cnt = rs.getInt(1);
        if(cnt == 0)
            out.println("<b><i><font color=red>Invalid credential</fonr></i></b>");
        else
        {
         
    //ps3 = con.prepareStatement("select * from registeruser where email='"+ema+"'");
    //ps4=con1.prepareStatement("select * from ordertable where email='"+ema+"'");
//out.print("success");
//rs = ps3.executeQuery();
//ResultSet rs1=ps4.executeQuery();
//con.setAutoCommit(false);
//con.commit();
rs.next();
//String email=rs.getString("email");
 //          out.println("<div class='row'><div class ='left' style='width:300px; height:100%;float:left;' ><form action='servlet/products' method='post'><fieldset style= width:25%; >");
   //       out.println("personal details<br/>Name:"+rs.getString("name")+"<br/>Age:"+rs.getString("age")+"<br/>Gender:"+rs.getString("gender")+"<br/>Email:"+rs.getString("email")+"<br/>Address:"+rs.getString("address")+"</div>");
     //     rs1.last();
       //     out.println("<div class='center' style='width:300px;height:100%; float:left; '>productdetails <br/>Items Purchased:"+rs1.getString("items")+"<br/>Price:"+rs1.getString("price")+"</div>");
            out.println("<div class='right' style='width:300px; height:100%; float:right;'><b><i><font color=red>valid credential..</font></i></b><br>");
         //   out.println("<body><a href='http://localhost:8080/sample1/products'>look for products</a></body></div>");
           //out.println("<body><body>");
            out.println("</fieldset></form></div>");
         //  HttpSession sess = request.getSession(false);
   HttpSession sess1 = request.getSession(false);
  HttpSession sess2 = request.getSession(false);

String email=(String)sess.getAttribute("ema");
//out.println(email);
//String price=request.getParameter("myField");
int price=Integer.parseInt(request.getParameter("myField"));
//int amount=(int)sess2.getAttribute("bal");
//out.println(price);
ps3=con.prepareStatement("select * from account where email='"+email+"'");
ResultSet rs1=ps3.executeQuery();
rs1.next();
//String bal=rs1.getString("balance");
int bal=Integer.parseInt(rs1.getString("balance"));

//out.println(bal);
int remain=bal-price;
//out.println(remain);
ps4=con.prepareStatement("UPDATE account set balance='"+remain+"' WHERE email = '"+email+"' ");
ResultSet rs2;
int i = ps4.executeUpdate();
if(i > 0)
{
out.print("<h1 style='text-align:center;margin-top:200px;margin-left:150px;'>"+email+"Payment Successful<br/> Thanks for Shopping</h1>");
}ps4.executeUpdate();
out.println("<a href='products'>continue shopping</a>");
out.println("<a href='http://www.google.com'>exit</a>");
out.println("<style>a{margin-top:300px;margin-left:600px;</style>");
//out.println("success");




//int bal = (Integer) request.getAttribute("bal");
//int amt=Integer. parseInt(request.getAttribute("bal"));
//out.println(bal);
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