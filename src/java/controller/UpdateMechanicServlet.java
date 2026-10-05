package controller;

import dao.MechanicDAO;
import model.Mechanic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateMechanic")
public class UpdateMechanicServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int mechanicId = Integer.parseInt(
                request.getParameter("mechanicId")
        );

        String fullName =
                request.getParameter("fullName");

        String phone =
                request.getParameter("phone");

        String email =
                request.getParameter("email");

        String specialization =
                request.getParameter("specialization");

        int experienceYears = Integer.parseInt(
                request.getParameter("experienceYears")
        );

        String status =
                request.getParameter("status");

        Mechanic mechanic =
                new Mechanic();

        mechanic.setMechanicId(mechanicId);
        mechanic.setFullName(fullName);
        mechanic.setPhone(phone);
        mechanic.setEmail(email);
        mechanic.setSpecialization(specialization);
        mechanic.setExperienceYears(experienceYears);
        mechanic.setStatus(status);

        MechanicDAO dao =
                new MechanicDAO();

        boolean success =
                dao.updateMechanic(mechanic);

        if (success) {

            response.sendRedirect("mechanics");

        } else {

            response.getWriter().println(
                "<h2>Failed to update mechanic!</h2>"
            );

            response.getWriter().println(
                "<br><a href='mechanics'>Back to Mechanic List</a>"
            );
        }
    }
}