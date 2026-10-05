package dao;

import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReportDAO {

    // =========================
    // TOTAL SERVICES
    // =========================
    public int getTotalServices() {

        String sql =
                "SELECT COUNT(*) "
              + "FROM service_requests";

        return getCount(sql);
    }


    // =========================
    // PENDING SERVICES
    // =========================
    public int getPendingServices() {

        String sql =
                "SELECT COUNT(*) "
              + "FROM service_requests "
              + "WHERE status = 'PENDING'";

        return getCount(sql);
    }


    // =========================
    // IN PROGRESS SERVICES
    // =========================
    public int getInProgressServices() {

        String sql =
                "SELECT COUNT(*) "
              + "FROM service_requests "
              + "WHERE status = 'IN PROGRESS'";

        return getCount(sql);
    }


    // =========================
    // COMPLETED SERVICES
    // =========================
    public int getCompletedServices() {

        String sql =
                "SELECT COUNT(*) "
              + "FROM service_requests "
              + "WHERE status = 'COMPLETED'";

        return getCount(sql);
    }


    // =========================
    // CANCELLED SERVICES
    // =========================
    public int getCancelledServices() {

        String sql =
                "SELECT COUNT(*) "
              + "FROM service_requests "
              + "WHERE status = 'CANCELLED'";

        return getCount(sql);
    }


    // =========================
    // COMMON COUNT METHOD
    // =========================
    private int getCount(String sql) {

        try (
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery()
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