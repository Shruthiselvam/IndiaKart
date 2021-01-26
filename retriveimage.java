/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
//import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;  
import java.io.InputStream;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import java.sql.*;  
import javax.servlet.ServletOutputStream;  
import javax.servlet.ServletInputStream;
   

/**
 *
 * @author hp
 */
@WebServlet(urlPatterns = {"/retriveimage"})
public class retriveimage extends HttpServlet {

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
        //response.setContentType("image/jpeg");  
        //PrintWriter out = response.getWriter();  
        Blob im = null;
byte[ ] imgData = null ;
        ServletOutputStream out = response.getOutputStream();  
        try {  
            /* 
             * TODO output your page here. You may use following sample code. 
             */  
            //byte[] rawBytes = null;  
            String id = request.getQueryString();  
            Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/productdetails","root","");
Statement stmt = null; 
  ResultSet rs = null;
  //CallableStatement stat = null;
 //stat = con.prepareCall("{call productdetails_image(?)}");  
  //          stat.setInt(1, Integer.parseInt(id));  
    //        ResultSet rs = stat.executeQuery();  

      //      rs.next(); 
 /*Statement stmt = null; 
  ResultSet rs = null;
   con.setAutoCommit(false);*/
//stmt=con.createStatement();
out.println("success");
String selectimage="SELECT image FROM PRODUCTDETAILS where productname='+name+'";
                     rs=stmt.executeQuery(selectimage);
                    // rs.setInt(1,Integer.parseInt(id));
//stmt = con.prepareCall("{call productdetails('image')}");
                     con.commit();
                    //  rs.next();  
//            out.println("<html>");  
//            out.println("<head>");  
//            out.println("<title>Servlet retriveImage</title>");  
//            out.println("</head>");  
//            out.println("<body>");  
           // rawBytes = rs.getBytes(1);  
            //out.write(rawBytes);  
//            out.println("</body>");  
//            out.println("</html>");
                     while(rs.next()){
                      im = rs.getBlob("image");
                                        response.setContentType("image/jpg");
  InputStream in = im.getBinaryStream();
  int length = (int) im.length();
  //out.println(length);
  int bufferSize = 1024;
  byte[] buffer = new byte[bufferSize];
  while((length=in.read(buffer))!=-1){
      out.write(buffer,0,length);
  }}
            //out.flush();  
            stmt.close();  
        } catch (Exception ex) {  
            out.println(ex.getMessage());  
        } 
    }
    @Override  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        processRequest(request, response);  
    }   
    /** 
     * Handles the HTTP 
     * <code>POST</code> method. 
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
    }// </editor-fold>  
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
    