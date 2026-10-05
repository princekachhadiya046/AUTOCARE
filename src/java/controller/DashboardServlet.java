package controller;

import dao.DashboardDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        DashboardDAO dao = new DashboardDAO();

        request.setAttribute(
                "totalCustomers",
                dao.getTotalCustomers()
        );

        request.setAttribute(
                "totalVehicles",
                dao.getTotalVehicles()
        );

        request.setAttribute(
                "totalMechanics",
                dao.getTotalMechanics()
        );

        request.setAttribute(
                "totalServices",
                dao.getTotalServices()
        );

        request.setAttribute(
                "pendingServices",
                dao.getPendingServices()
        );

        request.setAttribute(
                "completedServices",
                dao.getCompletedServices()
        );

        request.setAttribute(
                "totalInvoices",
                dao.getTotalInvoices()
        );

        request.setAttribute(
                "totalRevenue",
                dao.getTotalRevenue()
        );

        request.getRequestDispatcher(
                "dashboard.jsp"
        ).forward(request, response);
    }
}