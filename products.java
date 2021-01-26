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
@WebServlet(urlPatterns = {"/products"})
public class products extends HttpServlet {

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
try{
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/productdetails","root","");
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
String selectQuery="SELECT productname,category,price,image FROM productdetails";
//String selectemail="SELECT EMAIL FROM REGISTERUSER";
rs=stmt.executeQuery(selectQuery);
//String selectImages="SELECT IMAGE    FROM PRODUCTDETAILS WHERE PRODUCTNAME=rs.getString('productname')";
 //String selectimage="SELECT image FROM PRODUCTDETAILS where Price=999";
                   //     rs=stmt.executeQuery(selectimage);
con.commit();
//rs = stmt.executeQuery(selectQuery);
//out.print("success");
			//while(rs.next()) {
   //int pri=rs.getInt("Price");
     //                     String selectimage="SELECT IMAGE FROM PRODUCTDETAILS WHERE PRODUCTNAME='pri'";
       //                     rs=stmt.executeQuery(selectimage);
                             
                           
                            //response.setContentType("text/html");
                           //out.println("ProductName:  "+rs.getString("productname")+ "Category:  " + rs.getString("category")+
                  //"Price:  " + rs.getString("price"));
                          // out.println("")
                           // out.print("success");
                         //im = rs.getBlob("image");
                            //PreparedStatement ps=con.PreparedStatement("Select * from productdetails where productname=name");
                           //im = rs.getBlob("image");
/*imgData = image1.getBytes(1,(int)image1.length());
response.setContentType("image/jpg");
OutputStream o = response.getOutputStream();
o.write(imgData);*/
//ByteArrayInputStream bais = new ByteArrayInputStream(imgData);
//BufferedImage im = ImageIO.read(bais);
//ImageIcon imageIcon = new ImageIcon(imgData);
//Image im=imageIcon.getImage();
//out.println("ProductName:  "+rs.getString("productname")+ "Category:  " + rs.getString("category")+ "Price:  " + rs.getString("price"));
            //               while(rs.next()){
int idb=0;
HttpSession sess = request.getSession(); 
                               out.println("<!DOCTYPE html>");
      out.println("<html>");  
            out.println("<head>");
            out.println("<h1>IndiaKart</h1>");
           // out.println("<a  class='button button1' href='cart' >cart</a>");
out.println("<style>form{width: 300px; margin: 0 auto;text-align: center;padding-top: 50px;}.value-button {display: inline-block;border: 1px solid #ddd;margin: 0px;width: 40px;height: 20px;text-align: center;vertical-align: middle;padding: 11px 0;background: #eee;-webkit-touch-callout: none;-webkit-user-select: none; -khtml-user-select: none; -moz-user-select: none;-ms-user-select: none;user-select: none; }.value-button:hover { cursor: pointer;}form #decrease { margin-right: -4px;border-radius: 8px 0 0 8px;}form #increase {margin-left: -4px;border-radius: 0 8px 8px 0;}form #input-wrap {margin: 0px;padding: 0px;}input#number {text-align: center;border: none;border-top: 1px solid #ddd;border-bottom: 1px solid #ddd; margin: 0px;width: 40px; height: 40px;}input[type=number]::-webkit-inner-spin-button,input[type=number]::-webkit-outer-spin-button {-webkit-appearance: none;margin: 0;}.button{border-radius: 15px;background:darkgrey; padding: 10px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer;}.button1 {background-color: darkgrey; color: black; }.button1:hover{border-radius: 15px;background-color: deeppink;color:darkgrey;}");
        out.println(" h1{text-align: center;background:deeppink;font-size: 50px;margin-top: 0;margin-bottom: 0;}");
out.println(".personal details{float:left;width:30%}.productlists{float:right;width:70%;");
        out.println("</style>");
out.println("<script>function increaseValue(id) {var value = parseInt(document.getElementById(id).value, 10);value = isNaN(value) ? 0 : value;value++; document.getElementById(id).value = value;}function decreaseValue(id) {var value = parseInt(document.getElementById(id).value, 10);value = isNaN(value) ? 0 : value;value < 1 ? value = 1 : '';value--;document.getElementById(id).value = value;var qnty=document.getElementById(id).value ;}var array=new Array();var array1=new Array();var array2=new Array();function reply(pn,id,pr){var qnty=document.getElementById(id).value;if(qnty>0){var val1=pn;array.push(val1);array1.push(qnty);var val2=pr; array2.push(val2);document.querySelector('.myId').innerHTML = array.join(',');document.querySelector('.myId1').innerHTML = array1.join(',');document.querySelector('.myId2').innerHTML = array2.join(',');var str=document.querySelector('.myId').innerHTML;var str1=document.querySelector('.myId1').innerHTML;var str2=document.querySelector('.myId2').innerHTML;document.getElementById('myField').value = str;document.getElementById('myField1').value = str1;document.getElementById('myField2').value = str2;}}</script>");           
out.println("<title>Servlet DisplayData</title>");  
            out.println("</head>");  
            //out.println("<body>");      
      out.println("<body style='background:azure;'>");
      int intb=0;
       while (rs.next()) {
          // out.println(intb);
          String pn=rs.getString("productname");
          String pr=rs.getString("Price");
         // out.println(pr);
         //  String pn=document.getElementById('a').getAttribute('value');
     // HttpSession sess = request.getSession(); 
sess.setAttribute("pn",pn );
//out.println(pn);
//response.sendRedirect("purchasedetails.jsp");
              String img=rs.getString("image");
    out.println("<div style='margin: 0px;background-color:azure;border-style: ridge;'><table style='width:100%; height:auto;'><tr><td style='width:300px;'>'ProductName:'   "+rs.getString("productname")+"</td><td style='width:300px;'> 'Category:'    "+ rs.getString("category") +"</td><td style='width:200px;'>'Price:'   "+ rs.getString("price") +"</td><td style='width:200px;'><img src='" + img+ "'  width='200' height='200' style='padding-left:5px;'>"+"</td>");
    out.println("<td style='width:100px;'><form><div class='value-button' id='decrease' onclick='decreaseValue(\""+intb+"\")' value='Decrease Value'>-</div>")  ;       
    out.println("<input type='number' id='"+intb+"' value='0' style='width:30px; height:40px;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;border-style:none;text-align:center;' />");
    out.println("<div class='value-button' id='increase' onclick='increaseValue(\""+intb+"\")' value='Increase Value'>+</div></form></td>");
    out.println(" <td style='width:100px;'><input type='button' class='button button1'value='Add To Cart' onClick='this.disabled=true;reply(\""+pn+"\",\""+intb+"\",\""+pr+"\");'></td>");
  //out.println("<td style='width:100px;'><a  class='button button1'   href='purchasedetails.jsp'>Add To Cart</a>");
   // out.println("<a  class='button button1'   href='purchasedetails.jsp'>Order Details</a>");
    out.println("</tr></table></div>");
    intb++;
    //int your_int = Integer.parseInt( .getText() );

      //out.println("<form><div class='value-button' id='decrease' onclick='decreaseValue()' value='Decrease Value'>-</div>")  ;       
      //out.println("<input type='number' id='number' value='0' />");
      //out.println("<div class='value-button' id='increase' onclick='increaseValue()' value='Increase Value'>+</div>+</form>")
                }  
      out.println("<p class='myId'>Selected values--</p>");
      out.println("<p class='myId1'>Selected quantity--</p>");
      out.println("<p class='myId2'>Selected Price--</p>");
       //out.println("<a  class='button button1'   href='purchasedetails.jsp'>Order Details</a>");
       //out.println(email);
      // String arr=request.getParameter("str");
      // out.println(arr);
       out.println("<form action='purchasedetails.jsp'><input type='hidden' name='myField' id='myField' value='' /><input type='hidden' name='myField1' id='myField1' value='' /><input type='hidden' name='myField2' id='myField2' value='' /><input class='button button1' type='submit' value='Proceed to Cart'></form>");
//String img=rs.getString("image");
  //    out.println("<div style='margin: 0px;background-color:azure;border-style: ridge;'><table><tr><td>'ProductName:'   "+rs.getString("productname")+"</td><td> 'Category:'    "+ rs.getString("category") +"</td><td>'Price:'   "+ rs.getString("price") +"</td><td><img src='" + img+ "'  width='200' height='200' style='padding-left:5px;'>"+"</td></tr></div>");
            out.println("</body>");  
            out.println("</html>");  
  // String text=document.getElementById("myId").text();
   //out.println(text);
             
       

}

//OutputStream o = response.getOutputStream();
//o.write(imgData);
//response.getOutputStream().write(imgData,0,(int)image.length());
//o.write(im);
//o.flush();
//o.close();	
	/*response.setContentType("image/jpg");
  InputStream in = im.getBinaryStream();
  int length = (int) im.length();
  //out.println(length);
  int bufferSize = 1024;
  byte[] buffer = new byte[bufferSize];
  while((length=in.read(buffer))!=-1){
      out.write(buffer,0,length);
  }	*/	
                      

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
         String result = request.getParameter("str");
System.out.print("get"+result);
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
        String email=request.getParameter("email");
        System.out.println(email);
        String result = request.getParameter("str");
System.out.print("post"+result);
System.out.println("this is post");

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


