package controller;

import dao.ServiceRequestDAO;
import model.ServiceRequest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addService")
public class AddServiceServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int vehicleId = Integer.parseInt(
                request.getParameter("vehicleId")
        );
        int mechanicId = Integer.parseInt(
        request.getParameter("mechanicId")
);

        String serviceType =
                request.getParameter("serviceType");

        String serviceDate =
                request.getParameter("serviceDate");

        String description =
                request.getParameter("description");

        String status =
                request.getParameter("status");

        double estimatedCost = Double.parseDouble(
                request.getParameter("estimatedCost")
        );

        ServiceRequest service =
                new ServiceRequest();

        service.setVehicleId(vehicleId);
        service.setMechanicId(mechanicId);
        service.setServiceType(serviceType);
        service.setServiceDate(serviceDate);
        service.setDescription(description);
        service.setStatus(status);
        service.setEstimatedCost(estimatedCost);

        ServiceRequestDAO dao =
                new ServiceRequestDAO();

        boolean success =
                dao.addServiceRequest(service);

        if (success) {

            response.sendRedirect("services");

        } else {

            response.getWriter().println(
                "<h2>Failed to add service request!</h2>"
            );

            response.getWriter().println(
                "<br><a href='addService.jsp'>Back</a>"
            );
        }
    }
}