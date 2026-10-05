package controller;

import dao.CustomerDAO;
import model.Customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editCustomer")
public class EditCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        if (id == null || id.trim().isEmpty()) {

            response.getWriter().println(
                "<h2>Customer ID is missing!</h2>"
            );

            return;
        }

        int customerId = Integer.parseInt(id);

        CustomerDAO dao = new CustomerDAO();

        Customer customer =
                dao.getCustomerById(customerId);

        if (customer != null) {

            request.setAttribute("customer", customer);

            request.getRequestDispatcher(
                    "editCustomer.jsp"
            ).forward(request, response);

        } else {

            response.getWriter().println(
                "<h2>Customer not found!</h2>"
            );

            response.getWriter().println(
                "<a href='customers'>Back to Customer List</a>"
            );
        }
    }
}