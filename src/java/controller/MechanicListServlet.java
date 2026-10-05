package controller;

import dao.MechanicDAO;
import model.Mechanic;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mechanics")
public class MechanicListServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        MechanicDAO dao = new MechanicDAO();

        List<Mechanic> mechanics =
                dao.getAllMechanics();

        request.setAttribute(
                "mechanics",
                mechanics
        );

        request.getRequestDispatcher(
                "mechanicList.jsp"
        ).forward(request, response);
    }
}