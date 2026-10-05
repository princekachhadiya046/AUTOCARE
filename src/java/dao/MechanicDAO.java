package dao;

import model.Mechanic;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MechanicDAO {

    // ADD MECHANIC
    public boolean addMechanic(Mechanic mechanic) {

        String sql =
                "INSERT INTO mechanics "
              + "(mechanic_id, full_name, phone, email, "
              + "specialization, experience_years, status) "
              + "VALUES (mechanics_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, mechanic.getFullName());
            ps.setString(2, mechanic.getPhone());
            ps.setString(3, mechanic.getEmail());
            ps.setString(4, mechanic.getSpecialization());
            ps.setInt(5, mechanic.getExperienceYears());
            ps.setString(6, mechanic.getStatus());

            int result = ps.executeUpdate();

            ps.close();
            con.close();

            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // GET ALL MECHANICS
    public List<Mechanic> getAllMechanics() {

        List<Mechanic> mechanics =
                new ArrayList<Mechanic>();

        String sql =
                "SELECT mechanic_id, full_name, phone, email, "
              + "specialization, experience_years, status "
              + "FROM mechanics "
              + "ORDER BY mechanic_id";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Mechanic mechanic =
                        new Mechanic();

                mechanic.setMechanicId(
                        rs.getInt("mechanic_id"));

                mechanic.setFullName(
                        rs.getString("full_name"));

                mechanic.setPhone(
                        rs.getString("phone"));

                mechanic.setEmail(
                        rs.getString("email"));

                mechanic.setSpecialization(
                        rs.getString("specialization"));

                mechanic.setExperienceYears(
                        rs.getInt("experience_years"));

                mechanic.setStatus(
                        rs.getString("status"));

                mechanics.add(mechanic);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mechanics;
    }


    // GET MECHANIC BY ID
    public Mechanic getMechanicById(int mechanicId) {

        Mechanic mechanic = null;

        String sql =
                "SELECT mechanic_id, full_name, phone, email, "
              + "specialization, experience_years, status "
              + "FROM mechanics "
              + "WHERE mechanic_id = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, mechanicId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                mechanic = new Mechanic();

                mechanic.setMechanicId(
                        rs.getInt("mechanic_id"));

                mechanic.setFullName(
                        rs.getString("full_name"));

                mechanic.setPhone(
                        rs.getString("phone"));

                mechanic.setEmail(
                        rs.getString("email"));

                mechanic.setSpecialization(
                        rs.getString("specialization"));

                mechanic.setExperienceYears(
                        rs.getInt("experience_years"));

                mechanic.setStatus(
                        rs.getString("status"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mechanic;
    }


    // UPDATE MECHANIC
    public boolean updateMechanic(Mechanic mechanic) {

        String sql =
                "UPDATE mechanics SET "
              + "full_name = ?, "
              + "phone = ?, "
              + "email = ?, "
              + "specialization = ?, "
              + "experience_years = ?, "
              + "status = ? "
              + "WHERE mechanic_id = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, mechanic.getFullName());
            ps.setString(2, mechanic.getPhone());
            ps.setString(3, mechanic.getEmail());
            ps.setString(4, mechanic.getSpecialization());
            ps.setInt(5, mechanic.getExperienceYears());
            ps.setString(6, mechanic.getStatus());
            ps.setInt(7, mechanic.getMechanicId());

            int result = ps.executeUpdate();

            ps.close();
            con.close();

            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // DELETE MECHANIC
    public boolean deleteMechanic(int mechanicId) {

        String sql =
                "DELETE FROM mechanics "
              + "WHERE mechanic_id = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, mechanicId);

            int result = ps.executeUpdate();

            ps.close();
            con.close();

            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}