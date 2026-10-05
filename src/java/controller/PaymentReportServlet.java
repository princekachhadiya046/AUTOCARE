package controller;

import dao.PaymentReportDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaymentReportServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        PaymentReportDAO dao =
                new PaymentReportDAO();

        request.setAttribute(
                "totalInvoices",
                dao.getTotalInvoices()
        );

        request.setAttribute(
                "paidInvoices",
                dao.getPaidInvoices()
        );

        request.setAttribute(
                "unpaidInvoices",
                dao.getUnpaidInvoices()
        );

        request.setAttribute(
                "paidAmount",
                dao.getPaidAmount()
        );

        request.setAttribute(
                "unpaidAmount",
                dao.getUnpaidAmount()
        );

        request.setAttribute(
                "cashAmount",
                dao.getCashAmount()
        );

        request.setAttribute(
                "cardAmount",
                dao.getCardAmount()
        );

        request.setAttribute(
                "onlineAmount",
                dao.getOnlineAmount()
        );

        request.getRequestDispatcher(
                "paymentReport.jsp"
        ).forward(request, response);
    }
}