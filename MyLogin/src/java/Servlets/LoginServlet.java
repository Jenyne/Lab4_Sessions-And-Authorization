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
import java.util.HashSet;
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

    String userloginname;
    String loggedin = "false";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String url = request.getServletPath();
        if ("true".equals(session.getAttribute(loggedin)) && url == "/login") {
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            if (session.isNew()) {
                if (session.getAttribute(userloginname) != null) {

                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                            .forward(request, response);

                } else if (session.getAttribute(userloginname) == null) {
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                            .forward(request, response);
                } else {
                    getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
                            .forward(request, response);
                }

            } else {

                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                        .forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        AccountService ac = new AccountService();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = ac.login(username, password);
        if (user != null) {
            String curuser = user.getUsername();
            if ("adam".equals(curuser) || "betty".equals(curuser)) {
                session.setAttribute("userloginname", curuser);
                session.setAttribute("loggedin", "true");
                response.sendRedirect(request.getContextPath() + "/home");

            } else if (curuser == "admin") {
                session.setAttribute("userloginname", curuser);
                session.setAttribute("loggedin", "true");
                response.sendRedirect(request.getContextPath() + "/home");
            }
        } else {
            try{ 
                request.setAttribute("message", user.getUsername());
            }catch(NullPointerException e) {
                request.setAttribute("message","Wrong username or Password"); 
            String curuser = request.getParameter("username");
            request.setAttribute("username", curuser);
            session.setAttribute("loggedin", "false");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }
        

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
