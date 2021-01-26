/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author hp
 */
@WebServlet(urlPatterns = {"/cart"})
public class cart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       //try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
         //   out.println("<!DOCTYPE html>");
           // out.println("<html>");
            //out.println("<head>");
            //out.println("<title>Servlet products</title>");            
            //out.println("</head>");
            //out.println("<body>");
            //out.println("<h1>Servlet products at " + request.getContextPath() + "</h1>");
            //out.println("</body>");
            //out.println("</html>");
        //}
        
        //PrintWriter out = response.getWriter();  
//out.println("success");
ServletOutputStream out=response.getOutputStream();
String arr=request.getParameter("myField");
       out.println("  ");
        String arr1=request.getParameter("myField1");
        out.println("   ");
        String arr2=request.getParameter("myField2");
        out.println("  ");
try{ 
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/productdetails","root","");
Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3307/orderdetails","root","");
//out.println("success");
//String n=request.getParameter("name");
//int a=Integer. parseInt(request. getParameter("age"));   
//String e=request.getParameter("email");
//String ps=request.getParameter("pwd");
 //gen=request.getParameter("gender");
//if(gen.equals("male"))
  //  gen="male";
//else
  //  gen="female";
 out.println("<a style='float:right;' href='index.html'>home</a>");
   Statement stmt = null; 
  ResultSet rs = null;
 con.setAutoCommit(false);
stmt=con.createStatement();
Statement stmt1 = null; 
  ResultSet rs1 = null;
 con1.setAutoCommit(false);
stmt1=con1.createStatement();
HttpSession sess = request.getSession(false);
String email=(String)sess.getAttribute("ema");
//out.println(email);
String display="SELECT ordereditems FROM orderdetails where email='"+email+"'";
rs1=stmt1.executeQuery(display);
rs1.last();
rs1.previous();
String cartitems=rs1.getString("ordereditems");
//out.println(cartitems);
//String[] cart=new String[200];
/*if(cartitems.split(",")==null){
    String[] cart=new String[200];
    cart[0]=cartitems;
    out.println(cart.length);
}*/
//else{
String cart[]=cartitems.split( "," );
int len=cart.length;
if(len==0)
{
    cart[0]=cartitems;
}
//out.println(cart[0]);
//out.println(cart[1]);
//}
 out.println("<!DOCTYPE html>");
      out.println("<html>");  
            out.println("<head>");
            out.println("<h1>IndiaKart</h1>");
for(int i=0;i<cart.length;i++)
{
    String selectQuery="SELECT productname,category,price,image FROM productdetails where productname='"+cart[i]+"' ";
    rs=stmt.executeQuery(selectQuery);
    con.commit();
int idb=0;
out.println("<style>form{width: 300px; margin: 0 auto;text-align: center;padding-top: 50px;}.value-button {display: inline-block;border: 1px solid #ddd;margin: 0px;width: 40px;height: 20px;text-align: center;vertical-align: middle;padding: 11px 0;background: #eee;-webkit-touch-callout: none;-webkit-user-select: none; -khtml-user-select: none; -moz-user-select: none;-ms-user-select: none;user-select: none; }.value-button:hover { cursor: pointer;}form #decrease { margin-right: -4px;border-radius: 8px 0 0 8px;}form #increase {margin-left: -4px;border-radius: 0 8px 8px 0;}form #input-wrap {margin: 0px;padding: 0px;}input#number {text-align: center;border: none;border-top: 1px solid #ddd;border-bottom: 1px solid #ddd; margin: 0px;width: 40px; height: 40px;}input[type=number]::-webkit-inner-spin-button,input[type=number]::-webkit-outer-spin-button {-webkit-appearance: none;margin: 0;}.button{border-radius: 15px;background:darkgrey; padding: 10px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer;}.button1 {background-color: darkgrey; color: black; }.button1:hover{border-radius: 15px;background-color: deeppink;color:darkgrey;}");
out.println(" h1{text-align: center;background:deeppink;font-size: 50px;margin-top: 0;margin-bottom: 0;}");
out.println(".personal details{float:left;width:30%}.productlists{float:right;width:70%;");
out.println("</style>");
out.println("<script>function increaseValue(id) {var value = parseInt(document.getElementById(id).value, 10);value = isNaN(value) ? 0 : value;value++; document.getElementById(id).value = value;}function decreaseValue(id) {var value = parseInt(document.getElementById(id).value, 10);value = isNaN(value) ? 0 : value;value < 1 ? value = 1 : '';value--;document.getElementById(id).value = value;var qnty=document.getElementById(id).value ;}var arrayy=new Array();var arrayy1=new Array();var arrayy2=new Array();function reply(pn,id,pr){var qnty=document.getElementById(id).value;if(qnty>0){var val1=pn;arrayy.push(val1);arrayy1.push(qnty);var val2=pr; arrayy2.push(val2);document.querySelector('.myIdd').innerHTML = arrayy.join(',');document.querySelector('.myIdd1').innerHTML = arrayy1.join(',');document.querySelector('.myIdd2').innerHTML = arrayy2.join(',');var strr=document.querySelector('.myIdd').innerHTML;var strr1=document.querySelector('.myIdd1').innerHTML;var strr2=document.querySelector('.myIdd2').innerHTML;document.getElementById('myFieldd').value = strr;document.getElementById('myFieldd1').value = strr1;document.getElementById('myFieldd2').value = strr2;}}</script>");           
out.println("<title>Servlet DisplayData</title>");  
            out.println("</head>");  
            out.println("<body style='background:azure;'>");
      rs.next();
      String pn=rs.getString("productname");
          String pr=rs.getString("Price");
sess.setAttribute("pn",pn );
              String img=rs.getString("image");
               out.println("<div style='margin: 0px;background-color:azure;border-style: ridge;'><table style='width:100%; height:auto;'><tr><td style='width:300px;'>'ProductName:'   "+rs.getString("productname")+"</td><td style='width:300px;'> 'Category:'    "+ rs.getString("category") +"</td><td style='width:200px;'>'Price:'   "+ rs.getString("price") +"</td><td style='width:200px;'><img src='" + img+ "'  width='200' height='200' style='padding-left:5px;'>"+"</td>");
                out.println("<td style='width:100px;'><form><div class='value-button' id='decrease' onclick='decreaseValue(\""+i+"\")' value='Decrease Value'>-</div>")  ;       
                out.println("<input type='number' id='"+i+"' value='0' style='width:30px; height:40px;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;border-style:none;text-align:center;' />");
                out.println("<div class='value-button' id='increase' onclick='increaseValue(\""+i+"\")' value='Increase Value'>+</div></form></td>");
                out.println(" <td style='width:100px;'><input type='button' class='button button1'value='Add To Cart' onClick='this.disabled=true;reply(\""+pn+"\",\""+i+"\",\""+pr+"\");'></td>");
                out.println("</tr></table></div>");
}
//out.println("success");
out.println("<p class='myIdd'>Selected values--</p>");
      out.println("<p class='myIdd1'>Selected quantity--</p>");
      out.println("<p class='myIdd2'>Selected Price--</p>");
out.println("<form action='newpurchasedetails.jsp'><input type='hidden' name='myFieldd' id='myFieldd' value='' /><input type='hidden' name='myFieldd1' id='myFieldd1' value='' /><input type='hidden' name='myFieldd2' id='myFieldd2' value='' /><input class='button button1' type='submit' value='OrderDetails'></form>");
        out.println("</body>");  
            out.println("</html>");
           
}
                      

catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}


