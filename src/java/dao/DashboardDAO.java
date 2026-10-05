package dao;

import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DashboardDAO {

    public int getTotalCustomers() {

        String sql = "SELECT COUNT(*) FROM customers";

        return getCount(sql);
    }

    public int getTotalVehicles() {

        String sql = "SELECT COUNT(*) FROM vehicles";

        return getCount(sql);
    }

    public int getTotalMechanics() {

        String sql = "SELECT COUNT(*) FROM mechanics";

        return getCount(sql);
    }

    public int getTotalServices() {

        String sql = "SELECT COUNT(*) FROM service_requests";

        return getCount(sql);
    }

    public int getPendingServices() {

        String sql =
                "SELECT COUNT(*) FROM service_requests "
              + "WHERE status = 'PENDING'";

        return getCount(sql);
    }

    public int getCompletedServices() {

        String sql =
                "SELECT COUNT(*) FROM service_requests "
              + "WHERE status = 'COMPLETED'";

        return getCount(sql);
    }

    public int getTotalInvoices() {

        String sql = "SELECT COUNT(*) FROM invoices";

        return getCount(sql);
    }

    public double getTotalRevenue() {

        String sql =
                "SELECT NVL(SUM(total_amount), 0) "
              + "FROM invoices "
              + "WHERE payment_status = 'PAID'";

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

        return 0;
    }

    private int getCount(String sql) {

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
}