package dao;

import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PaymentReportDAO {

    public int getTotalInvoices() {

        String sql =
                "SELECT COUNT(*) FROM invoices";

        return getIntValue(sql);
    }

    public int getPaidInvoices() {

        String sql =
                "SELECT COUNT(*) "
              + "FROM invoices "
              + "WHERE payment_status = 'PAID'";

        return getIntValue(sql);
    }

    public int getUnpaidInvoices() {

        String sql =
                "SELECT COUNT(*) "
              + "FROM invoices "
              + "WHERE payment_status = 'UNPAID'";

        return getIntValue(sql);
    }

    public double getPaidAmount() {

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

    public double getCashAmount() {

        String sql =
                "SELECT NVL(SUM(total_amount), 0) "
              + "FROM invoices "
              + "WHERE payment_status = 'PAID' "
              + "AND payment_method = 'CASH'";

        return getDoubleValue(sql);
    }

    public double getCardAmount() {

        String sql =
                "SELECT NVL(SUM(total_amount), 0) "
              + "FROM invoices "
              + "WHERE payment_status = 'PAID' "
              + "AND payment_method = 'CARD'";

        return getDoubleValue(sql);
    }

    public double getOnlineAmount() {

        String sql =
                "SELECT NVL(SUM(total_amount), 0) "
              + "FROM invoices "
              + "WHERE payment_status = 'PAID' "
              + "AND payment_method = 'ONLINE'";

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