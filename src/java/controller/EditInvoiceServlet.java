package controller;

import dao.InvoiceDAO;
import model.Invoice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editInvoice")
public class EditInvoiceServlet extends HttpServlet {

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

            Invoice invoice =
                    dao.getInvoiceById(invoiceId);

            if (invoice != null) {

                request.setAttribute(
                        "invoice",
                        invoice
                );

                request.getRequestDispatcher(
                        "editInvoice.jsp"
                ).forward(request, response);

            } else {

                response.getWriter().println(
                        "Invoice not found!"
                );
            }

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error loading invoice: "
                    + e.getMessage()
            );
        }
    }
}