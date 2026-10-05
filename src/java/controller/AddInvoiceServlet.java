package controller;

import dao.InvoiceDAO;
import model.Invoice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addInvoice")
public class AddInvoiceServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int serviceId = Integer.parseInt(
                    request.getParameter("serviceId")
            );

            String invoiceDate =
                    request.getParameter("invoiceDate");

            double subtotal = Double.parseDouble(
                    request.getParameter("subtotal")
            );

            double taxAmount = Double.parseDouble(
                    request.getParameter("taxAmount")
            );

            double discountAmount = Double.parseDouble(
                    request.getParameter("discountAmount")
            );

            double totalAmount = Double.parseDouble(
                    request.getParameter("totalAmount")
            );

            String paymentStatus =
                    request.getParameter("paymentStatus");

            String paymentMethod =
                    request.getParameter("paymentMethod");

            Invoice invoice = new Invoice();

            invoice.setServiceId(serviceId);
            invoice.setInvoiceDate(invoiceDate);
            invoice.setSubtotal(subtotal);
            invoice.setTaxAmount(taxAmount);
            invoice.setDiscountAmount(discountAmount);
            invoice.setTotalAmount(totalAmount);
            invoice.setPaymentStatus(paymentStatus);
            invoice.setPaymentMethod(paymentMethod);

            InvoiceDAO dao = new InvoiceDAO();

            boolean result = dao.addInvoice(invoice);

            if (result) {

                response.sendRedirect("invoices");

            } else {

                response.getWriter().println(
                        "Failed to create invoice!"
                );
            }

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error while creating invoice: "
                    + e.getMessage()
            );
        }
    }
}