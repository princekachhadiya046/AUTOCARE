package controller;

import dao.UserDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {

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

            boolean result =
                    dao.deleteUser(userId);

            if (result) {

                response.sendRedirect("users");

            } else {

                response.getWriter().println(
                        "Failed to delete user!"
                );
            }

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error while deleting user: "
                    + e.getMessage()
            );
        }
    }
}