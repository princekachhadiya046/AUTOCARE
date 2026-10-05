package controller;

import dao.VehicleDAO;
import model.Vehicle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vehicles")
public class VehicleListServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        VehicleDAO dao = new VehicleDAO();

        List<Vehicle> vehicles =
                dao.getAllVehicles();

        request.setAttribute(
                "vehicles",
                vehicles
        );

        request.getRequestDispatcher(
                "vehicleList.jsp"
        ).forward(request, response);
    }
}