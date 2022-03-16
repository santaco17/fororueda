/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontController;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author santa
 */
public class LogInCommand extends FrontCommand{
    @Override
    public void process() {
        try {
            HttpSession session= request.getSession(true);
            
            String nombre = (String) request.getParameter("name");
            String marca = (String) request.getParameter("carBrand");
            String modelo = (String) request.getParameter("carModel");
            
            session.setAttribute("name", nombre);
            session.setAttribute("carBrand", marca);
            session.setAttribute("carModel", modelo);
            forward("/LogInCommandView");
        } catch (ServletException ex) {
            Logger.getLogger(LogInCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LogInCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
