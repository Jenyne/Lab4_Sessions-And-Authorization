/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;


import Models.AccountService;
import Models.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nykke
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountService ac = new AccountService();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = ac.login(username,password);
        // pass user/password to accserv.login(). If user = user then do.
        
        if (user != null) {
            String curuser = user.getUsername();
            if(curuser == "adam" || curuser == "betty"){
                 //response.sendRedirect(request.getContextPath() + "/home");
                 getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
                .forward(request, response);
            }
            else if (curuser=="admin"){
            }
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
        }
            
        
            
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
