package controller;

import dao.CustomerDAO;
import model.Customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateCustomer")
public class UpdateCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int customerId = Integer.parseInt(
                request.getParameter("customerId")
        );

        String fullName =
                request.getParameter("fullName");

        String phone =
                request.getParameter("phone");

        String email =
                request.getParameter("email");

        String address =
                request.getParameter("address");

        Customer customer = new Customer();

        customer.setCustomerId(customerId);
        customer.setFullName(fullName);
        customer.setPhone(phone);
        customer.setEmail(email);
        customer.setAddress(address);

        CustomerDAO dao = new CustomerDAO();

        boolean success =
                dao.updateCustomer(customer);

        if (success) {

            response.sendRedirect("customers");

        } else {

            response.getWriter().println(
                "<h2>Failed to update customer!</h2>"
            );
        }
    }
}