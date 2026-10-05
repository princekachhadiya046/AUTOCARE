package controller;

import dao.MechanicReportDAO;
import model.Mechanic;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MechanicReportServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        MechanicReportDAO dao =
                new MechanicReportDAO();

        List<Mechanic> mechanics =
                dao.getMechanicPerformance();

        request.setAttribute(
                "mechanics",
                mechanics
        );

        request.setAttribute(
                "dao",
                dao
        );

        request.getRequestDispatcher(
                "mechanicReport.jsp"
        ).forward(request, response);
    }
}