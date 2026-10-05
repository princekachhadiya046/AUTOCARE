package controller;

import dao.VehicleDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteVehicle")
public class DeleteVehicleServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        if (id == null || id.trim().isEmpty()) {
            response.getWriter().println(
                "<h2>Vehicle ID is missing!</h2>"
            );
            return;
        }

        int vehicleId = Integer.parseInt(id);

        VehicleDAO dao = new VehicleDAO();

        boolean success =
                dao.deleteVehicle(vehicleId);

        if (success) {

            response.sendRedirect("vehicles");

        } else {

            response.getWriter().println(
                "<h2>Failed to delete vehicle!</h2>"
            );

            response.getWriter().println(
                "<br><a href='vehicles'>Back to Vehicle List</a>"
            );
        }
    }
}