/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import objects.Hilo;

/**
 *
 * @author santa
 */
public class VerHilosCommand extends FrontCommand{
    @Override
    public void process() {
        try {
            
            HttpSession session= request.getSession(true);
            
            String nombre = (String) session.getAttribute("name");
            String marca = (String) session.getAttribute("carBrand");
            String modelo = (String) session.getAttribute("carModel");
            String titulo = (String) request.getParameter("title");
            String descripcion = (String) request.getParameter("description");
            
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
            
            forward("/VerHilosCommandView");
        } catch (ServletException ex) {
            Logger.getLogger(VerHilosCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VerHilosCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
