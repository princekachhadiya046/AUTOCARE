package controller;

import dao.RevenueReportDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RevenueReportServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        RevenueReportDAO dao =
                new RevenueReportDAO();

        request.setAttribute(
                "totalInvoices",
                dao.getTotalInvoices()
        );

        request.setAttribute(
                "totalRevenue",
                dao.getTotalRevenue()
        );

        request.setAttribute(
                "paidRevenue",
                dao.getPaidRevenue()
        );

        request.setAttribute(
                "unpaidAmount",
                dao.getUnpaidAmount()
        );

        request.setAttribute(
                "totalDiscount",
                dao.getTotalDiscount()
        );

        request.setAttribute(
                "totalTax",
                dao.getTotalTax()
        );

        request.getRequestDispatcher(
                "revenueReport.jsp"
        ).forward(request, response);
    }
}