package dao;

import model.Vehicle;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class VehicleDAO {

    // =========================
    // ADD VEHICLE
    // =========================
    public boolean addVehicle(Vehicle vehicle) {

        String sql = "INSERT INTO vehicles "
                   + "(vehicle_id, customer_id, vehicle_number, brand, "
                   + "model, vehicle_type, manufacturing_year) "
                   + "VALUES (vehicles_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, vehicle.getCustomerId());
            ps.setString(2, vehicle.getVehicleNumber());
            ps.setString(3, vehicle.getBrand());
            ps.setString(4, vehicle.getModel());
            ps.setString(5, vehicle.getVehicleType());
            ps.setInt(6, vehicle.getManufacturingYear());

            int result = ps.executeUpdate();

            ps.close();
            con.close();

            return result > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }


    // =========================
    // GET ALL VEHICLES
    // =========================
    public java.util.List<Vehicle> getAllVehicles() {

        java.util.List<Vehicle> vehicles =
                new java.util.ArrayList<Vehicle>();

        String sql =
                "SELECT v.vehicle_id, "
              + "v.customer_id, "
              + "c.full_name AS customer_name, "
              + "v.vehicle_number, "
              + "v.brand, "
              + "v.model, "
              + "v.vehicle_type, "
              + "v.manufacturing_year "
              + "FROM vehicles v "
              + "JOIN customers c "
              + "ON v.customer_id = c.customer_id "
              + "ORDER BY v.vehicle_id";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            java.sql.ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                Vehicle vehicle =
                        new Vehicle();

                vehicle.setVehicleId(
                        rs.getInt("vehicle_id")
                );

                vehicle.setCustomerId(
                        rs.getInt("customer_id")
                );

                vehicle.setCustomerName(
                        rs.getString("customer_name")
                );

                vehicle.setVehicleNumber(
                        rs.getString("vehicle_number")
                );

                vehicle.setBrand(
                        rs.getString("brand")
                );

                vehicle.setModel(
                        rs.getString("model")
                );

                vehicle.setVehicleType(
                        rs.getString("vehicle_type")
                );

                vehicle.setManufacturingYear(
                        rs.getInt("manufacturing_year")
                );

                vehicles.add(vehicle);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return vehicles;
    }
    public Vehicle getVehicleById(int vehicleId) {

    Vehicle vehicle = null;

    String sql =
            "SELECT v.vehicle_id, "
          + "v.customer_id, "
          + "c.full_name AS customer_name, "
          + "v.vehicle_number, "
          + "v.brand, "
          + "v.model, "
          + "v.vehicle_type, "
          + "v.manufacturing_year "
          + "FROM vehicles v "
          + "JOIN customers c "
          + "ON v.customer_id = c.customer_id "
          + "WHERE v.vehicle_id = ?";

    try {

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, vehicleId);

        java.sql.ResultSet rs =
                ps.executeQuery();

        if (rs.next()) {

            vehicle = new Vehicle();

            vehicle.setVehicleId(
                    rs.getInt("vehicle_id")
            );

            vehicle.setCustomerId(
                    rs.getInt("customer_id")
            );

            vehicle.setCustomerName(
                    rs.getString("customer_name")
            );

            vehicle.setVehicleNumber(
                    rs.getString("vehicle_number")
            );

            vehicle.setBrand(
                    rs.getString("brand")
            );

            vehicle.setModel(
                    rs.getString("model")
            );

            vehicle.setVehicleType(
                    rs.getString("vehicle_type")
            );

            vehicle.setManufacturingYear(
                    rs.getInt("manufacturing_year")
            );
        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {

        e.printStackTrace();
    }

    return vehicle;
}
    public boolean updateVehicle(Vehicle vehicle) {

    String sql =
            "UPDATE vehicles SET "
          + "customer_id = ?, "
          + "vehicle_number = ?, "
          + "brand = ?, "
          + "model = ?, "
          + "vehicle_type = ?, "
          + "manufacturing_year = ? "
          + "WHERE vehicle_id = ?";

    try {

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, vehicle.getCustomerId());
        ps.setString(2, vehicle.getVehicleNumber());
        ps.setString(3, vehicle.getBrand());
        ps.setString(4, vehicle.getModel());
        ps.setString(5, vehicle.getVehicleType());
        ps.setInt(6, vehicle.getManufacturingYear());
        ps.setInt(7, vehicle.getVehicleId());

        int result = ps.executeUpdate();

        ps.close();
        con.close();

        return result > 0;

    } catch (Exception e) {

        e.printStackTrace();

        return false;
    }
}
    public boolean deleteVehicle(int vehicleId) {

    String sql =
            "DELETE FROM vehicles WHERE vehicle_id = ?";

    try {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, vehicleId);

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