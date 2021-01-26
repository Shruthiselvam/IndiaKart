/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class registertable extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
String gen;
//out.println("success");
try{
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/registeruser","root","");
out.println("<a style='float:right;' href='http://localhost:8080/sample1/index.html'>home</a>");
 String n=request.getParameter("name");
int a=Integer. parseInt(request. getParameter("age"));   
String e=request.getParameter("email");
String ps=request.getParameter("pwd");
 gen=request.getParameter("gender");
if(gen.equals("male"))
    gen="male";
else
    gen="female";
String add=request.getParameter("address");
//out.println("success");
   Statement stmt = null; 
  ResultSet rs = null;
   con.setAutoCommit(false);
stmt=con.createStatement();
String chkquery="select name from registeruser where name='"+n+"'and age='"+a+"'and email='"+e+"'and gender='"+gen+"'and address='"+add+"'";
rs = stmt.executeQuery(chkquery);
//out.print(rs.isBeforeFirst());
if(rs.isBeforeFirst()==true)
{
    out.print("value already exits");
}
else
{


//if()
    
String insertQuery = "INSERT INTO Registeruser(NAME,AGE,EMAIL,PASSWORD,GENDER,ADDRESS) VALUES('"+n+"','"+a+"','"+e+"','"+ps+"','"+gen+"','"+add+"')";
String selectQuery="SELECT * FROM Registeruser";
//out.print("success");
stmt.executeUpdate(insertQuery);
con.commit();
rs = stmt.executeQuery(selectQuery);
//out.print(n);
			while (rs.next()) {
				// Didplaying data of tables
				/*out.println("name"+rs.getString("name")+
                                        "age" + rs.getString("age")+
                                        "password" + rs.getString("password")
						+ ", email " + rs.getString("email") + ", gender "
						+ gen + ", Address " + rs.getString("address") );*/
                              // out.print(add);
			}
                        con.close(); 
out.print("You are successfully registered...");  
// con.close();
}
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  