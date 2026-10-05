package controller;

import dao.CustomerDAO;
import model.Customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customers")
public class CustomerListServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        CustomerDAO dao = new CustomerDAO();

        List<Customer> customers =
                dao.getAllCustomers();

        request.setAttribute("customers", customers);

        request.getRequestDispatcher(
                "customerList.jsp"
        ).forward(request, response);
    }
}