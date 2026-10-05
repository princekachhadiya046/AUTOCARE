package controller;

import dao.ReportDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReportServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ReportDAO dao = new ReportDAO();

        request.setAttribute(
                "totalServices",
                dao.getTotalServices()
        );

        request.setAttribute(
                "pendingServices",
                dao.getPendingServices()
        );

        request.setAttribute(
                "inProgressServices",
                dao.getInProgressServices()
        );

        request.setAttribute(
                "completedServices",
                dao.getCompletedServices()
        );

        request.setAttribute(
                "cancelledServices",
                dao.getCancelledServices()
        );

        request.getRequestDispatcher(
                "serviceReport.jsp"
        ).forward(request, response);
    }
}