package controller;

import dao.MechanicDAO;
import model.Mechanic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editMechanic")
public class EditMechanicServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        if (id == null || id.trim().isEmpty()) {
            response.getWriter().println(
                "<h2>Mechanic ID is missing!</h2>"
            );
            return;
        }

        int mechanicId = Integer.parseInt(id);

        MechanicDAO dao =
                new MechanicDAO();

        Mechanic mechanic =
                dao.getMechanicById(mechanicId);

        if (mechanic != null) {

            request.setAttribute(
                    "mechanic",
                    mechanic
            );

            request.getRequestDispatcher(
                    "editMechanic.jsp"
            ).forward(request, response);

        } else {

            response.getWriter().println(
                "<h2>Mechanic not found!</h2>"
            );

            response.getWriter().println(
                "<br><a href='mechanics'>Back to Mechanic List</a>"
            );
        }
    }
}