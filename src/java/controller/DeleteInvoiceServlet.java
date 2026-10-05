package controller;

import dao.InvoiceDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteInvoice")
public class DeleteInvoiceServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int invoiceId = Integer.parseInt(
                    request.getParameter("id")
            );

            InvoiceDAO dao = new InvoiceDAO();

            boolean result =
                    dao.deleteInvoice(invoiceId);

            if (result) {

                response.sendRedirect("invoices");

            } else {

                response.getWriter().println(
                        "Failed to delete invoice!"
                );
            }

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error while deleting invoice: "
                    + e.getMessage()
            );
        }
    }
}