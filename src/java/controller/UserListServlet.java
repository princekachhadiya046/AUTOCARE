package controller;

import dao.UserDAO;
import model.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class UserListServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        UserDAO dao = new UserDAO();

        List<User> users = dao.getAllUsers();

        request.setAttribute(
                "users",
                users
        );

        request.getRequestDispatcher(
                "userList.jsp"
        ).forward(request, response);
    }
}