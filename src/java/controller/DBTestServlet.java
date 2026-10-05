package controller;

import util.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dbtest")
public class DBTestServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        Connection con = DBConnection.getConnection();

        if (con != null) {

            out.println("<h1>Database Connected Successfully!</h1>");
            out.println("<p>AUTOCARE → Oracle JDBC Connection Working</p>");

        } else {

            out.println("<h1>Database Connection Failed!</h1>");
        }
    }
}