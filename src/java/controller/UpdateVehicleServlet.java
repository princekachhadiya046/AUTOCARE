package controller;

import dao.VehicleDAO;
import model.Vehicle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateVehicle")
public class UpdateVehicleServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int vehicleId = Integer.parseInt(
                request.getParameter("vehicleId")
        );

        int customerId = Integer.parseInt(
                request.getParameter("customerId")
        );

        String vehicleNumber =
                request.getParameter("vehicleNumber");

        String brand =
                request.getParameter("brand");

        String model =
                request.getParameter("model");

        String vehicleType =
                request.getParameter("vehicleType");

        int manufacturingYear = Integer.parseInt(
                request.getParameter("manufacturingYear")
        );

        Vehicle vehicle = new Vehicle();

        vehicle.setVehicleId(vehicleId);
        vehicle.setCustomerId(customerId);
        vehicle.setVehicleNumber(vehicleNumber);
        vehicle.setBrand(brand);
        vehicle.setModel(model);
        vehicle.setVehicleType(vehicleType);
        vehicle.setManufacturingYear(manufacturingYear);

        VehicleDAO dao = new VehicleDAO();

        boolean success =
                dao.updateVehicle(vehicle);

        if (success) {

            response.sendRedirect("vehicles");

        } else {

            response.getWriter().println(
                "<h2>Failed to update vehicle!</h2>"
            );

            response.getWriter().println(
                "<br><a href='vehicles'>Back to Vehicle List</a>"
            );
        }
    }
}