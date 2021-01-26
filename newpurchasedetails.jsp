<%-- 
    Document   : newpurchasedetails
    Created on : Dec 22, 2020, 3:01:14 PM
    Author     : hp
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*,java.util.Arrays"%>

<%
    ResultSet rs=null;
    HttpSession sess = request.getSession(false);
//HttpSession sess1 = request.getSession(false);
//use false to use the existing session
String email=(String)sess.getAttribute("ema");
//out.println(email);
//String pn=(String)sess.getAttribute("pn");
//out.println(pn);
//String pn=(String)request.getParameter("productname");
//out.println(pn);
//String arr=request.getParameter("myField");
String arr=(String)sess.getAttribute("arr");
//out.println(arr);
String arrr=request.getParameter("myFieldd");
//out.println(arrr);
//String arr1=request.getParameter("myField1
String arr1=(String)sess.getAttribute("arr1");
String arrr1=request.getParameter("myFieldd1");
//out.println(arrr1);
//String arr2=request.getParameter("myField2");
String arr2=(String)sess.getAttribute("arr2");
String arrr2=request.getParameter("myFieldd2");
//out.println(arrr2);
//out.println("arr"+arr);
//out.println("arrr"+arrr);
String joined="";
String joined1="";
String joined2="";

if(arrr.equals("")==false)
{
String[] arri=arr.split(",");
String[] arr1i=arr1.split(",");
String[] arr2i=arr2.split(",");
int[] q=new int[arr1i.length];
int[] p=new int[arr2i.length];
for(int i=0;i<arr1i.length;i++)
{
    q[i]=Integer.parseInt(arr1i[i]);
}
for(int i=0;i<arr2i.length;i++)
{
    p[i]=Integer.parseInt(arr2i[i]);
}
String[] arrri=arrr.split(",");
String[] arrr1i=arrr1.split(",");
String[] arrr2i=arrr2.split(",");
int[] q1=new int[arrr1i.length];
int[] p1=new int[arrr2i.length];
for(int i=0;i<arrr1i.length;i++)
{
    q1[i]=Integer.parseInt(arrr1i[i]);
}
for(int i=0;i<arrr2i.length;i++)
{
    p1[i]=Integer.parseInt(arrr2i[i]);
}


 for(int i=0;i<arri.length;i++)
        {
            for(int j=0;j<arrri.length;j++)
            {
               // out.println("arri[i]"+arri[i]);
                //out.println("arrri[j]"+arrri[j]);
                if(arri[i].equals(arrri[j]))
                {
                    //out.println("success");
                   //out.println(i);
                    q[i]=q[i]+q1[j];
                   // out.println(q1[i]);
                    q1[j]=0;
                    arrri[j]="";
                    p1[j]=0;
                }
            }
        }
 String[] qq=new String[q.length];
 for(int j=0;j<arri.length;j++)
 {
     qq[j]=Integer.toString(q[j]);
    // out.println("qq[j]"+qq[j]);
 }
 String[] pp=new String[p.length];
 for(int j=0;j<arri.length;j++)
 {
     pp[j]=Integer.toString(p[j]);
    // out.println("qq[j]"+qq[j]);
 }
 String[] qq1=new String[q1.length];
 for(int j=0;j<arrri.length;j++)
 {
     qq1[j]=Integer.toString(q1[j]);
     //out.println("qq1[j]"+qq1[j]);
 }
 String[] pp1=new String[p1.length];
 for(int j=0;j<arrri.length;j++)
 {
     pp1[j]=Integer.toString(p1[j]);
    // out.println("qq[j]"+qq[j]);
 }
 StringBuffer qqq = new StringBuffer(); 
 StringBuffer ppp=new StringBuffer();
 for(int j=0;j<qq.length;j++)
 {
     //out.println(qq[j]);
     qqq.append(qq[j]).append(",");
    //out.println("qqq"+qqq);
 
 }
 String res=qqq.deleteCharAt(qqq.length() - 1).toString();
 for(int j=0;j<pp.length;j++)
 {
     //out.println(qq[j]);
     ppp.append(pp[j]).append(",");
    //out.println("qqq"+qqq);
 }
  String ress=ppp.deleteCharAt(ppp.length() - 1).toString();
 //out.println(res);
 //String qqq1="";
  StringBuffer qqq1 = new StringBuffer();
  StringBuffer ppp1 = new StringBuffer();
  
 for(int j=0;j<qq1.length;j++)
 {
      qqq1.append(qq1[j]).append(",");
      //out.println("qqq1"+qqq1);
 }
  String res1=qqq1.deleteCharAt(qqq1.length() - 1).toString();
 
 for(int j=0;j<pp1.length;j++)
 {
      ppp1.append(pp1[j]).append(",");
      //out.println("qqq1"+qqq1);
 }
 String ress1=ppp1.deleteCharAt(ppp1.length() - 1).toString();
 
 //out.println(qqq);
 //out.println(qqq1);
 StringBuffer arrii=new StringBuffer();
 for(int i=0;i<arri.length;i++)
 {
     arrii.append(arri[i]).append(",");
 }
 //out.println(arrii);
 StringBuffer arrrii=new StringBuffer();
 for(int i=0;i<arrri.length;i++)
 {
     arrrii.append(arrri[i]).append(",");
 }
 //out.println(arrrii);

 joined = String.join(",", arrii,arrrii);
//out.println("joined" +joined);
 joined1 =  res+","+res1;
//out.println("quantity" +joined1);
 joined2 = String.join(",", ress,ress1);
//out.println("price" +joined2);

}else
{
     joined=String.join(",",arr,arrr);
     joined1=String.join(",",arr1,arrr1);
     joined2=String.join(",",arr2,arrr2);
}
//out.println(joined);
//out.println(joined1);
//out.println(joined2);
String[]  array = joined.split(",");
String[]  array1 = joined1.split(",");
String[]  array2 = joined2.split(",");
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
     //sess = request.getSession();
    //sess.setAttribute("sum",sum);
   HttpSession sess1=request.getSession();
   sess1.setAttribute("sum", sum);
    
    out.println("<style>.button{border-radius: 15px;background:darkgrey; padding: 10px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer;}.button1 {background-color: darkgrey; color: black; }.button1:hover{border-radius: 15px;background-color: deeppink;color:darkgrey;}</style>");
            out.println("<h1 style='text-align: center;background:deeppink;font-size: 50px;margin-top: 0;margin-bottom: 0;'>IndiaKart</h1>");
   // out.println(" <style>h1{text-align: center;background:deeppink;font-size: 50px;margin-top: 0;margin-bottom: 0;}<style>");
out.println("<h4>The items in the cart  of  "+email+"  are:</h4>");
            out.println("<body style='background-color:azure;'><table style='margin-left: auto;margin-right: auto;margin-top:100px; border: 1px solid black;border-collapse: collapse;'><tr><th style='border: 1px solid black;border-collapse: collapse;height:30px;'>ProductName</th><th style='border: 1px solid black;border-collapse: collapse;'>Quantity</th><th style='border: 1px solid black;border-collapse: collapse;'>Price</th></tr>");
  for (int i=0; i<array.length; i++) {
  out.println("<tr><td style=' border: 1px solid black;border-collapse: collapse;width:150px;height:50px;text align:center;'>"+array[i]+"</td>");
  out.println("<td style='border: 1px solid black;border-collapse: collapse;text align:center; width:100px;height:50px;'>" + array1[i] + "</td>");
  out.println("<td  style='border: 1px solid black;border-collapse: collapse;text align:center;width:100px;height:50px;'>" + array2[i] + "</td></tr>");
}
       out.println("<td>Total Cost</td><td></td><td>"+sum+"</td>");
try
{
    if(email!=""&&joined!=""){
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/orderdetails", "root", "");
Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3307/ordertable", "root", "");
Statement st=conn.createStatement();
PreparedStatement ps4=conn1.prepareStatement("select * from ordertable where email='"+email+"'");
//Statement st1=conn1.createStatement();
//out.println("success");
rs=st.executeQuery("select email from orderdetails where email='"+email+"'and orderedItems='"+joined+"'");
//if(rs.isBeforeFirst()!=true)
//{
  //  out.println("success");
st.executeUpdate("insert into orderdetails values('"+email+"','"+joined+"')");
//out.println("success");
st.executeUpdate("insert into ordertable values('"+email+"','"+joined+"','"+tqnty+"','"+sum+"')");
out.println("Data is successfully inserted!");
//}
out.println("<a style='margin-left:450px;' class='button button1' href='payment' >Payment</a>");
out.println("<a style='float:right;' href='index.html'>home</a>");
//if(rs.isBeforeFirst()!=true)
//{
    //out.println("success");

//st.executeUpdate("insert into ordertable values('"+email+"','"+arr+"','"+tqnty+"','"+sum+"')");
//out.println("Data is successfully inserted!");
conn.commit();
//response.sendRedirect("login.jsp");
    //}
//ResultSet rs1=ps4.executeQuery();
//rs1.last();
}}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
  
%>
