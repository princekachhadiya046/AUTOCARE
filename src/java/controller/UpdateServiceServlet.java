package controller;

import dao.ServiceRequestDAO;
import model.ServiceRequest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateService")
public class UpdateServiceServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int serviceId = Integer.parseInt(
                    request.getParameter("serviceId")
            );

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

            double estimatedCost =
                    Double.parseDouble(
                            request.getParameter("estimatedCost")
                    );

            ServiceRequest service =
                    new ServiceRequest();

            service.setServiceId(serviceId);
            service.setVehicleId(vehicleId);
            service.setMechanicId(mechanicId);
            service.setServiceType(serviceType);
            service.setServiceDate(serviceDate);
            service.setDescription(description);
            service.setStatus(status);
            service.setEstimatedCost(estimatedCost);

            ServiceRequestDAO dao =
                    new ServiceRequestDAO();

            boolean result =
                    dao.updateServiceRequest(service);

            if (result) {

                response.sendRedirect("services");

            } else {

                response.getWriter().println(
                        "Failed to update service request!"
                );
            }

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error while updating service request: "
                    + e.getMessage()
            );
        }
    }
}