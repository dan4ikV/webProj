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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        Enumeration<String> names = request.getParameterNames();
        PrintWriter show = response.getWriter();


        show.print(
                "<html>\n" +
                        "<head><title> Parameters</title></head>\n"+
                        "<body>" +
                        "<table width=\"70%\" border = \"1\" align = \"center\">"+
                        "<tr><th>Param name</th><th>Values</th></tr>\n"
        );


        while(names.hasMoreElements()){
            String tempName = names.nextElement();
            show.print("<tr><td>"+tempName+"</td><td>");
            String[] paramValues = request.getParameterValues(tempName);

            if(paramValues.length == 1){
                String paramValue = paramValues[0];
                if (paramValue.length() == 0){
                    show.print("No values");
                }else{
                    show.print(paramValue);
                }
            }else{
                show.print("<ul>");
                for (int i = 0; i <paramValues.length ; i++) {
                    show.print("<li>"+paramValues[i]);
                }
                show.print("</ul>");
            }
        }

        show.print("</tr></table></body></html>");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("checkboxJSP.jsp").forward(request, response);
        doPost(request, response);
    }
}
