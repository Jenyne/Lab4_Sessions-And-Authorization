/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

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
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String curuser = (String) session.getAttribute("userloginname");
        if (curuser != null) {

            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
                    .forward(request, response);

        } else if ("adam".equals(curuser) || "betty".equals(curuser) || "admin".equals(curuser)) {
            session.setAttribute("userloginname", curuser);
            response.sendRedirect(request.getContextPath() + "/home");
        } else {

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if ("logout".equals(request.getParameter("logout"))) {
            if (session.getAttribute("userloginname") != null) {
                //session.removeAttribute("userloginname");
                session.invalidate();
                response.sendRedirect(request.getContextPath() + "/login");
            }
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
                    .forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
