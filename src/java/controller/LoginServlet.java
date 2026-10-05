package controller;

import dao.UserDAO;
import model.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        System.out.println(
                "LOGIN ATTEMPT: " + email
        );

        UserDAO dao = new UserDAO();

        User user =
                dao.login(email, password);

        if (user == null) {

            System.out.println(
                    "LOGIN FAILED"
            );

            response.sendRedirect(
                    "login.jsp?error=invalid"
            );

            return;
        }

        System.out.println(
                "USER ROLE: " + user.getRole()
        );

        // Remove any old session
        HttpSession oldSession =
                request.getSession(false);

        if (oldSession != null) {
            oldSession.invalidate();
        }

        // Check user role
        if ("ADMIN".equalsIgnoreCase(
                user.getRole())) {

            HttpSession session =
                    request.getSession(true);

            session.setAttribute(
                    "userId",
                    user.getUserId()
            );

            session.setAttribute(
                    "fullName",
                    user.getFullName()
            );

            session.setAttribute(
                    "email",
                    user.getEmail()
            );

            session.setAttribute(
                    "role",
                    user.getRole()
            );

            System.out.println(
                    "ADMIN LOGIN - DASHBOARD"
            );

            response.sendRedirect(
                    "dashboard"
            );

        } else {

            System.out.println(
                    "NON-ADMIN LOGIN - ACCESS DENIED"
            );

            response.sendRedirect(
                    "accessDenied.jsp"
            );
        }
    }
}