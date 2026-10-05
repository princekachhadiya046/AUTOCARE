package dao;

import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RevenueReportDAO {

    public int getTotalInvoices() {

        String sql =
                "SELECT COUNT(*) FROM invoices";

        return getIntValue(sql);
    }

    public double getTotalRevenue() {

        String sql =
                "SELECT NVL(SUM(total_amount), 0) "
              + "FROM invoices";

        return getDoubleValue(sql);
    }

    public double getPaidRevenue() {

        String sql =
                "SELECT NVL(SUM(total_amount), 0) "
              + "FROM invoices "
              + "WHERE payment_status = 'PAID'";

        return getDoubleValue(sql);
    }

    public double getUnpaidAmount() {

        String sql =
                "SELECT NVL(SUM(total_amount), 0) "
              + "FROM invoices "
              + "WHERE payment_status = 'UNPAID'";

        return getDoubleValue(sql);
    }

    public double getTotalDiscount() {

        String sql =
                "SELECT NVL(SUM(discount_amount), 0) "
              + "FROM invoices";

        return getDoubleValue(sql);
    }

    public double getTotalTax() {

        String sql =
                "SELECT NVL(SUM(tax_amount), 0) "
              + "FROM invoices";

        return getDoubleValue(sql);
    }

    private int getIntValue(String sql) {

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    private double getDoubleValue(String sql) {

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            if (rs.next()) {
                return rs.getDouble(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0.0;
    }
}