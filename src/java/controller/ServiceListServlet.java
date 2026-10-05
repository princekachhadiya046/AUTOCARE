package controller;

import dao.ServiceRequestDAO;
import model.ServiceRequest;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/services")
public class ServiceListServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ServiceRequestDAO dao =
                new ServiceRequestDAO();

        List<ServiceRequest> services =
                dao.getAllServiceRequests();

        request.setAttribute(
                "services",
                services
        );

        request.getRequestDispatcher(
                "serviceList.jsp"
        ).forward(request, response);
    }
}