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
import objects.Hilo;

/**
 *
 * @author santa
 */
public class VerHilosCommandView extends HttpServlet {

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
            out.println("<title>Servlet VerHilosCommandView</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
            
            HttpSession session= request.getSession(true);
            
            String nombre = (String) session.getAttribute("name");
            String marca = (String) session.getAttribute("carBrand");
            String modelo = (String) session.getAttribute("carModel");
            String titulo = (String) request.getParameter("title");
            String descripcion = (String) request.getParameter("description");

            out.println("<form action= \"FrontController\" > "
                    + "<input type= \"submit\" value= \"Crear hilo.\" >"
                    + " <input type= \"hidden\" name= \"command\" value= \"AnuncioCommand\" >"
                    + " </form>");
            
            
            
            
            ArrayList arrayHilos = (ArrayList) session.getAttribute("hilos");
            
            
            if( arrayHilos == null){
                
                arrayHilos = new ArrayList();
                session.setAttribute("hilos", arrayHilos);
            }
    
            if(titulo != null || descripcion != null){
                Hilo hilo = new Hilo (titulo, descripcion, nombre, marca, modelo);
                session.setAttribute("hilo", hilo);
                arrayHilos.add((Hilo) session.getAttribute("hilo"));
            }
            
            
            for(int i = 0; i< arrayHilos.size(); i++ ){
                    out.println("<h4>" + arrayHilos.get(i) + "</h4>");
            }
            
           out.println("<my-footer></my-footer>");
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
