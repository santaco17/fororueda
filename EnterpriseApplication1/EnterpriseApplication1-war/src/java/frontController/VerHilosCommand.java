/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontController;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

/**
 *
 * @author santa
 */
public class VerHilosCommand extends FrontCommand{
    @Override
    public void process() {
        try {
            forward("/VerHilosCommandView");
        } catch (ServletException ex) {
            Logger.getLogger(VerHilosCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VerHilosCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
