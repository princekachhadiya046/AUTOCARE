package dao;

import model.Mechanic;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MechanicReportDAO {

    public List<Mechanic> getMechanicPerformance() {

        List<Mechanic> mechanics = new ArrayList<>();

        String sql =
                "SELECT m.mechanic_id, "
              + "m.full_name, "
              + "m.phone, "
              + "m.email, "
              + "m.specialization, "
              + "m.experience_years, "
              + "m.status, "
              + "COUNT(s.service_id) AS total_services, "
              + "SUM(CASE WHEN s.status = 'COMPLETED' "
              + "THEN 1 ELSE 0 END) AS completed_services, "
              + "SUM(CASE WHEN s.status = 'PENDING' "
              + "THEN 1 ELSE 0 END) AS pending_services, "
              + "SUM(CASE WHEN s.status = 'IN PROGRESS' "
              + "THEN 1 ELSE 0 END) AS in_progress_services, "
              + "SUM(CASE WHEN s.status = 'CANCELLED' "
              + "THEN 1 ELSE 0 END) AS cancelled_services "
              + "FROM mechanics m "
              + "LEFT JOIN service_requests s "
              + "ON m.mechanic_id = s.mechanic_id "
              + "GROUP BY m.mechanic_id, "
              + "m.full_name, "
              + "m.phone, "
              + "m.email, "
              + "m.specialization, "
              + "m.experience_years, "
              + "m.status "
              + "ORDER BY m.mechanic_id";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Mechanic mechanic = new Mechanic();

                mechanic.setMechanicId(
                        rs.getInt("mechanic_id")
                );

                mechanic.setFullName(
                        rs.getString("full_name")
                );

                mechanic.setPhone(
                        rs.getString("phone")
                );

                mechanic.setEmail(
                        rs.getString("email")
                );

                mechanic.setSpecialization(
                        rs.getString("specialization")
                );

                mechanic.setExperienceYears(
                        rs.getInt("experience_years")
                );

                mechanic.setStatus(
                        rs.getString("status")
                );

                mechanics.add(mechanic);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mechanics;
    }

    public int getTotalServices(int mechanicId) {

        String sql =
                "SELECT COUNT(*) "
              + "FROM service_requests "
              + "WHERE mechanic_id = ?";

        return getCount(sql, mechanicId);
    }

    public int getCompletedServices(int mechanicId) {

        String sql =
                "SELECT COUNT(*) "
              + "FROM service_requests "
              + "WHERE mechanic_id = ? "
              + "AND status = 'COMPLETED'";

        return getCount(sql, mechanicId);
    }

    public int getPendingServices(int mechanicId) {

        String sql =
                "SELECT COUNT(*) "
              + "FROM service_requests "
              + "WHERE mechanic_id = ? "
              + "AND status = 'PENDING'";

        return getCount(sql, mechanicId);
    }

    public int getInProgressServices(int mechanicId) {

        String sql =
                "SELECT COUNT(*) "
              + "FROM service_requests "
              + "WHERE mechanic_id = ? "
              + "AND status = 'IN PROGRESS'";

        return getCount(sql, mechanicId);
    }

    public int getCancelledServices(int mechanicId) {

        String sql =
                "SELECT COUNT(*) "
              + "FROM service_requests "
              + "WHERE mechanic_id = ? "
              + "AND status = 'CANCELLED'";

        return getCount(sql, mechanicId);
    }

    private int getCount(
            String sql,
            int mechanicId) {

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(sql)
        ) {

            ps.setInt(1, mechanicId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getInt(1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}