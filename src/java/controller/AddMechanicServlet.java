package controller;

import dao.MechanicDAO;
import model.Mechanic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addMechanic")
public class AddMechanicServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

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

        mechanic.setFullName(fullName);
        mechanic.setPhone(phone);
        mechanic.setEmail(email);
        mechanic.setSpecialization(specialization);
        mechanic.setExperienceYears(experienceYears);
        mechanic.setStatus(status);

        MechanicDAO dao =
                new MechanicDAO();

        boolean success =
                dao.addMechanic(mechanic);

        if (success) {

            response.sendRedirect("mechanics");

        } else {

            response.getWriter().println(
                "<h2>Failed to add mechanic!</h2>"
            );

            response.getWriter().println(
                "<br><a href='addMechanic.jsp'>Back</a>"
            );
        }
    }
}