package controller;

import dao.UserDAO;
import model.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int userId = Integer.parseInt(
                    request.getParameter("id")
            );

            UserDAO dao = new UserDAO();

            User user =
                    dao.getUserById(userId);

            if (user != null) {

                request.setAttribute(
                        "user",
                        user
                );

                request.getRequestDispatcher(
                        "editUser.jsp"
                ).forward(request, response);

            } else {

                response.getWriter().println(
                        "User not found!"
                );
            }

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error loading user: "
                    + e.getMessage()
            );
        }
    }
}