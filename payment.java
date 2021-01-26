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
@WebServlet(urlPatterns = {"/payment"})
public class payment extends HttpServlet {

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
        ServletOutputStream out=response.getOutputStream();
        try {
           
  HttpSession sess = request.getSession(false);
   HttpSession sess1 = request.getSession(false);
  HttpSession sess2 = request.getSession();

String email=(String)sess.getAttribute("ema");
out.println(email);
int bal=(int)sess1.getAttribute("sum");
out.println(bal);
//sess2.setAttribute("bal", bal);
request.setAttribute("bal",bal);
// RequestDispatcher = request.getRequestDispatcher("/payment.jsp");
//view.forward(request, response); `

//String selectQuery="SELECT balance FROM account";
//String selectemail="SELECT EMAIL FROM REGISTERUSER";
//rs=stmt.executeQuery(selectQuery);
            /* TODO output your page here. You may use following sample code. */
 out.println("<a style='float:right;' href='index.html'>home</a>");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<style>h1{text-align: center ;background:deeppink;font-size: 50px;margin-top: 0; margin-bottom: 0;}.col{margin-right: -15px;margin-left: -20px; margin-top: 0;margin-bottom: 0;padding-top:150px;padding-bottom:10px;padding-bottom:10px;margin-top:10px;margin-bottom:10px;}</style>");
            out.println("<h1>IndiaKart</h1>");  
            //out.println("<script>function check(){document.getElementById('myField').value = bal; alert(bal);}</script>");
            out.println("</head>");
            out.println("The total amount is"+bal);
            out.println("<body style='background:azure;text-align:center;'>");
            out.println("<form action='payment.jsp'>");
           out.println(" Choose mode of Payment:<select  style='margin-top:100px;width:100px;'id='mop' name='mop'><option  value='Credit Card'>Credit Card</option><option value='Debit Card'>Debit Card</option></select>");
            out.println("<div class='col'>Card No:<input type='text' name='cardno'/><br/><br/>");
            out.println("Pin:<input type='password' name='pin'/><br/><br/>");
            out.println("<input type='hidden' name='myField' id='myField' value='"+bal+"' />");
            out.println("<input type = 'submit' class='button button1' value='Pay'  name = 's2'></form>");
            //out.println("<h1>Servlet payment at " + request.getContextPath() + "</h1>");
           out.println(" <a href='payment.jsp'>Pay on Delivery</a>");
            out.println("</body>");
            out.println("</html>");
           // String arr=request.getParameter("myField");
            //out.println(arr);
           // out.println("<form action='purchasedetails.jsp'><input type='hidden' name='myField' id='myField' value='' /><input type='hidden' name='myField1' id='myField1' value='' /><input type='hidden' name='myField2' id='myField2' value='' /><input class='button button1' type='submit' value='OrderDetails'></form>");
        }
        catch (Exception e2) {System.out.println(e2);} 
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
    }// </editor-fold>

}
