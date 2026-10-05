package controller;

import dao.UserDAO;
import model.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String fullName =
                    request.getParameter("fullName");

            String email =
                    request.getParameter("email");

            String password =
                    request.getParameter("password");

            String role =
                    request.getParameter("role");

            User user = new User();

            user.setFullName(fullName);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole(role);

            UserDAO dao = new UserDAO();

            boolean result =
                    dao.addUser(user);

            if (result) {

                response.sendRedirect("users");

            } else {

                response.getWriter().println(
                        "Failed to add user!"
                );
            }

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error while adding user: "
                    + e.getMessage()
            );
        }
    }
}