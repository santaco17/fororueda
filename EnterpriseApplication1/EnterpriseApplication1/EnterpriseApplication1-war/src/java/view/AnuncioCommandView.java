/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author santa
 */
public class AnuncioCommandView extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!DOCTYPE html>");
            out.println("<script type = module src=Styles/main.js></script>\n" +
            "<my-header>\n" +
            "</my-header>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"Styles/style.css\">");
            out.println("<title>Servlet AnuncioCommandView</title>");            
            out.println("</head>");
            out.println("<body>");
            
            HttpSession session= request.getSession(true);
            
            String nombre = (String) session.getAttribute("name");
            String marca = (String) session.getAttribute("carBrand");
            String modelo = (String) session.getAttribute("carModel");
            String marcaModelo = marca + " " + modelo;
            
            
            out.println("<form action= \"FrontController\" > "
                    + "<input type= \"text\" name=\"title\" placeholder=\"Título\" required >"
                    + "<input type= \"text\" name=\"description\" placeholder=\"Descripción\" required >"
                    + "<input type= \"text\" name=\"car\" value=" + marcaModelo + " contenteditable= 'false' >"
                    + "<input type= \"text\" name=\"author\" value=" + nombre + " contenteditable= 'false' >"
                    + " <input type= \"hidden\" name= \"command\" value= \"VerHilosCommand\" >"
                    + "<input type= \"submit\" value= \"Publicar hilo\" >"
                    + " </form>");
           
            
            out.println("</body>");
            out.println("<my-footer></my-footer>");
            out.println("</html>");
            
        }
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
