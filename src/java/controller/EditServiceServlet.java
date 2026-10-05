package controller;

import dao.ServiceRequestDAO;
import model.ServiceRequest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editService")
public class EditServiceServlet extends HttpServlet {

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

        ServiceRequest service =
                dao.getServiceRequestById(serviceId);

        if (service != null) {

            request.setAttribute(
                    "service",
                    service
            );

            request.getRequestDispatcher(
                    "editService.jsp"
            ).forward(request, response);

        } else {

            response.getWriter().println(
                "<h2>Service request not found!</h2>"
            );

            response.getWriter().println(
                "<br><a href='services'>Back to Service List</a>"
            );
        }
    }
}