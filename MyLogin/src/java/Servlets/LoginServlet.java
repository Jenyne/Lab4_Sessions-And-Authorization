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
import java.util.Set;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.getAttribute("user");
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
                    .forward(request, response);
        } else {
            session = request.getSession(true);
            session.setAttribute("user", null);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);

            AccountService ac = new AccountService();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = ac.login(username, password);
            if (user != null) {
                String curuser = user.getUsername();
                if (curuser == null || curuser == "") {
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                            .forward(request, response);
                }
                if (curuser == "adam" || curuser == "betty") {
                    String capuser = curuser.substring(0, 1).toUpperCase() + curuser.substring(1);
                    request.setAttribute("user", capuser);
                    session.setAttribute("userloginname", capuser);
                    //response.sendRedirect(request.getContextPath() + "/home");
                    getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
                            .forward(request, response);
                } else if (curuser == "admin") {
                    String capuser = curuser.substring(0, 1).toUpperCase() + curuser.substring(1);
                    request.setAttribute("user", capuser);
                    session.setAttribute("userloginname", curuser);
                }
                session = request.getSession();
                session.setAttribute("userloginname", user);
            } else {
                String curuser = request.getParameter("username");
                request.setAttribute("username", curuser);
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                        .forward(request, response);

            }
        }catch (NullPointerException e){
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                        .forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public static void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();

        }

    }

}
