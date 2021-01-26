/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class fp extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
out.println("success");
try{
    out.println("<a style='float:right;' href='index.html'>home</a>");
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/registeruser","root","");
 String np=request.getParameter("new");   
String cp=request.getParameter("cnfrm");
   Statement stmt = null; 
 ResultSet rs1 = null;
   con.setAutoCommit(false);
   String email=request.getParameter("email");
   out.println(email);

out.print(cp);
out.print(np);
//if(request.getParameter("new")==request.getParameter("cnfrm"))
//{
    stmt=con.createStatement();
PreparedStatement ps1 = con.prepareStatement("UPDATE registeruser SET password='"+cp+"'WHERE email='"+email+"' ");
ResultSet rs;
int i = ps1.executeUpdate();
if(i > 0)
{

//out.print(rs.isBeforeFirst());
    out.print("password updated");  
    con.commit();
// con.close();
}
String selectQuery="select * from registeruser where email='"+email+"'";
rs1=stmt.executeQuery(selectQuery);
//ResultSet rs1;
//ps2.executeQuery();
rs1.next();
//out.println("success");

String pass=rs1.getString("password");
//out.println(pass);
//}
//else{
 //   out.println("password and confirm should be same");
//}
}catch (Exception e2) {
    System.out.println(e2);
}  
          
out.close();  
}  
  
}  