package controller;

import dao.ServiceRequestDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteService")
public class DeleteServiceServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        if (id == null || id.trim().isEmpty()) {
            response.getWriter().println(
                "<h2>Service ID is missing!</h2>"
            );
            return;
        }

        int serviceId = Integer.parseInt(id);

        ServiceRequestDAO dao =
                new ServiceRequestDAO();

        boolean success =
                dao.deleteServiceRequest(serviceId);

        if (success) {

            response.sendRedirect("services");

        } else {

            response.getWriter().println(
                "<h2>Failed to delete service request!</h2>"
            );

            response.getWriter().println(
                "<br><a href='services'>Back to Service List</a>"
            );
        }
    }
}