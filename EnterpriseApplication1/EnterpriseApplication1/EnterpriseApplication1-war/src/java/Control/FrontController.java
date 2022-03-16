/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import frontController.UnknownCommand;
import frontController.FrontCommand;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Entrar
 */
public class FrontController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            
            FrontCommand command = (FrontCommand) getCommand(request);
            command.init(getServletContext(), request, response);
            command.process();
            
        } catch (Exception ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private FrontCommand getCommand(HttpServletRequest request) throws Exception{
        try{
            FrontCommand f = (FrontCommand) getCommandClass(request).newInstance();
            return f;
        }catch (Exception e){
            throw e;
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private Class getCommandClass(HttpServletRequest request) {
        Class result;
        final String command = "frontController."+(String)request.getParameter("command");
        try{
            result = Class.forName(command);
        }
        catch(ClassNotFoundException e){
            result=UnknownCommand.class;
        }
        return result;
    }



}
