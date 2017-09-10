package com.danylo.webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by rebell9191 on 08.09.2017.
 */
@WebServlet(name = "CheckboxServlet")
public class CheckboxServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("-----------------------------");
        System.out.println("call init method for class CheckBox Servlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Enumeration<String> names = request.getParameterNames();
        PrintWriter show = response.getWriter();
        Answers score = new Answers();
        int sc = 0;


        while (names.hasMoreElements()) {
            String tempName = names.nextElement();
            System.out.println(tempName);
            if (score.getA1() == tempName) {
                sc++;
            } else if (score.getA2() == tempName) {
                sc++;
            } else if (score.getA3() == tempName) {
                sc++;
            }
        }

        show.print("<b>Your score is " + sc + "out of 3</b>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("checkboxJSP.jsp").forward(request, response);
        doPost(request, response);
    }
}
