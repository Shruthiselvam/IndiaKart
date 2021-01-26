<%-- 
    Document   : purchasedetails
    Created on : Dec 16, 2020, 4:50:38 PM
    Author     : hp
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>

<%
    ResultSet rs=null;
     out.println("<a style='float:right;' href='index.html'>home</a>");
    HttpSession sess = request.getSession(false);
//HttpSession sess1 = request.getSession(false);
//use false to use the existing session
String email=(String)sess.getAttribute("ema");
//out.println(email);
//String pn=(String)sess.getAttribute("pn");
//out.println(pn);
//String pn=(String)request.getParameter("productname");
//out.println(pn);
String arr=request.getParameter("myField");
sess.setAttribute("arr",arr);
//String arrr=request.getParameter("myFieldd");
//out.println(arrr);
String arr1=request.getParameter("myField1");
sess.setAttribute("arr1",arr1);
//String arrr1=request.getParameter("myFieldd1");
//out.println(arrr1);
String arr2=request.getParameter("myField2");
sess.setAttribute("arr2",arr2);
//String arrr2=request.getParameter("myFieldd2");
//out.println(arrr2);
String[]  array = arr.split(",");
String[]  array1 = arr1.split(",");
String[]  array2 = arr2.split(",");
     /*  for(int i=0;i<array.length;i++)
       {
           out.println(array[i]);
       }
String[]  array1 = arr1.split(",");*/
int tqnty=0;
       for(int i=0;i<array1.length;i++)
       {
         tqnty=tqnty+Integer.parseInt(array1[i]);  
       }
      // out.println(tqnty);
     /*  String[]  array2 = arr2.split(",");
       for(int i=0;i<array2.length;i++)
       {
           out.println(array2[i]);
       }*/
    int sum=0;
           for(int i=0;i<array2.length;i++){
           sum=sum+Integer.parseInt(array1[i])*Integer.parseInt(array2[i]);
           }
           //out.println("success");
            out.println("<h1 style='text-align: center;background:deeppink;font-size: 50px;margin-top: 0;margin-bottom: 0;'>IndiaKart</h1>");
   // out.println(" <style>h1{text-align: center;background:deeppink;font-size: 50px;margin-top: 0;margin-bottom: 0;}<style>");
out.println("<h4>The items purchased by  "+email+"  are</h4>");
            out.println("<body style='background-color:azure;'><table style='margin-left: auto;margin-right: auto;margin-top:100px; border: 1px solid black;border-collapse: collapse;'><tr><th style='border: 1px solid black;border-collapse: collapse;height:30px;'>ProductName</th><th style='border: 1px solid black;border-collapse: collapse;'>Quantity</th><th style='border: 1px solid black;border-collapse: collapse;'>Price</th></tr>");
  for (int i=0; i<array.length; i++) {
  out.println("<tr><td style=' border: 1px solid black;border-collapse: collapse;width:150px;height:50px;text align:center;'>"+array[i]+"</td>");
  out.println("<td style='border: 1px solid black;border-collapse: collapse;text align:center; width:100px;height:50px;'>" + array1[i] + "</td>");
  out.println("<td  style='border: 1px solid black;border-collapse: collapse;text align:center;width:100px;height:50px;'>" + array2[i] + "</td></tr>");
}
       out.println("<td>Total Cost</td><td></td><td>"+sum+"</td>");
try
{
    if(email!=""&&arr!=""){
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/orderdetails", "root", "");
Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3307/ordertable", "root", "");
Statement st=conn.createStatement();
PreparedStatement ps4=conn1.prepareStatement("select * from ordertable where email='"+email+"'");
//Statement st1=conn1.createStatement();
//out.println("success");
rs=st.executeQuery("select email from orderdetails where email='"+email+"'and orderedItems='"+arr+"'");
//if(rs.isBeforeFirst()!=true)
//{
    //out.println("success");
st.executeUpdate("insert into orderdetails values('"+email+"','"+arr+"')");
//out.println("success");
st.executeUpdate("insert into ordertable values('"+email+"','"+arr+"','"+tqnty+"','"+sum+"')");
out.println("Do you want to select items from cart?");
//}
out.println("<a  class='button button1' href='cart' >cart</a>");
//if(rs.isBeforeFirst()!=true)
//{
    //out.println("success");
//st.executeUpdate("insert into ordertable values('"+email+"','"+arr+"','"+tqnty+"','"+sum+"')");
//out.println("Data is successfully inserted!");
conn.commit();
//response.sendRedirect("login.jsp");
    //}
ResultSet rs1=ps4.executeQuery();
rs1.last();
}}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>