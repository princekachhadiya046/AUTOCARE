package controller;

import dao.CustomerDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteCustomer")
public class DeleteCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int customerId = Integer.parseInt(
                request.getParameter("id")
        );

        CustomerDAO dao = new CustomerDAO();

        boolean success =
                dao.deleteCustomer(customerId);

        if (success) {

            response.sendRedirect("customers");

        } else {

            response.getWriter().println(
                "<h2>Failed to delete customer!</h2>"
            );
        }
    }
}