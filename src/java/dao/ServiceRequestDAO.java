package dao;

import model.ServiceRequest;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServiceRequestDAO {

    // ADD SERVICE REQUEST
    public boolean addServiceRequest(ServiceRequest service) {

        String sql =
                "INSERT INTO service_requests "
              + "(service_id, vehicle_id, mechanic_id, service_type, "
              + "service_date, description, status, estimated_cost) "
              + "VALUES (service_seq.NEXTVAL, ?, ?, ?, "
              + "TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, service.getVehicleId());
            ps.setInt(2, service.getMechanicId());
            ps.setString(3, service.getServiceType());
            ps.setString(4, service.getServiceDate());
            ps.setString(5, service.getDescription());
            ps.setString(6, service.getStatus());
            ps.setDouble(7, service.getEstimatedCost());

            int result = ps.executeUpdate();

            ps.close();
            con.close();

            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // GET ALL SERVICE REQUESTS
    public List<ServiceRequest> getAllServiceRequests() {

        List<ServiceRequest> services =
                new ArrayList<ServiceRequest>();

        String sql =
                "SELECT s.service_id, "
              + "s.vehicle_id, "
              + "v.vehicle_number, "
              + "s.mechanic_id, "
              + "m.full_name AS mechanic_name, "
              + "s.service_type, "
              + "TO_CHAR(s.service_date, 'YYYY-MM-DD') AS service_date, "
              + "s.description, "
              + "s.status, "
              + "s.estimated_cost "
              + "FROM service_requests s "
              + "JOIN vehicles v "
              + "ON s.vehicle_id = v.vehicle_id "
              + "LEFT JOIN mechanics m "
              + "ON s.mechanic_id = m.mechanic_id "
              + "ORDER BY s.service_id";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ServiceRequest service =
                        new ServiceRequest();

                service.setServiceId(
                        rs.getInt("service_id"));

                service.setVehicleId(
                        rs.getInt("vehicle_id"));

                service.setVehicleNumber(
                        rs.getString("vehicle_number"));

                service.setMechanicId(
                        rs.getInt("mechanic_id"));

                service.setMechanicName(
                        rs.getString("mechanic_name"));

                service.setServiceType(
                        rs.getString("service_type"));

                service.setServiceDate(
                        rs.getString("service_date"));

                service.setDescription(
                        rs.getString("description"));

                service.setStatus(
                        rs.getString("status"));

                service.setEstimatedCost(
                        rs.getDouble("estimated_cost"));

                services.add(service);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return services;
    }


    // GET SERVICE REQUEST BY ID
    public ServiceRequest getServiceRequestById(int serviceId) {

        ServiceRequest service = null;

        String sql =
                "SELECT s.service_id, "
              + "s.vehicle_id, "
              + "v.vehicle_number, "
              + "s.mechanic_id, "
              + "m.full_name AS mechanic_name, "
              + "s.service_type, "
              + "TO_CHAR(s.service_date, 'YYYY-MM-DD') AS service_date, "
              + "s.description, "
              + "s.status, "
              + "s.estimated_cost "
              + "FROM service_requests s "
              + "JOIN vehicles v "
              + "ON s.vehicle_id = v.vehicle_id "
              + "LEFT JOIN mechanics m "
              + "ON s.mechanic_id = m.mechanic_id "
              + "WHERE s.service_id = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, serviceId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                service = new ServiceRequest();

                service.setServiceId(
                        rs.getInt("service_id"));

                service.setVehicleId(
                        rs.getInt("vehicle_id"));

                service.setVehicleNumber(
                        rs.getString("vehicle_number"));

                service.setMechanicId(
                        rs.getInt("mechanic_id"));

                service.setMechanicName(
                        rs.getString("mechanic_name"));

                service.setServiceType(
                        rs.getString("service_type"));

                service.setServiceDate(
                        rs.getString("service_date"));

                service.setDescription(
                        rs.getString("description"));

                service.setStatus(
                        rs.getString("status"));

                service.setEstimatedCost(
                        rs.getDouble("estimated_cost"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return service;
    }


    // UPDATE SERVICE REQUEST
    public boolean updateServiceRequest(ServiceRequest service) {

        String sql =
                "UPDATE service_requests SET "
              + "vehicle_id = ?, "
              + "mechanic_id = ?, "
              + "service_type = ?, "
              + "service_date = TO_DATE(?, 'YYYY-MM-DD'), "
              + "description = ?, "
              + "status = ?, "
              + "estimated_cost = ? "
              + "WHERE service_id = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, service.getVehicleId());
            ps.setInt(2, service.getMechanicId());
            ps.setString(3, service.getServiceType());
            ps.setString(4, service.getServiceDate());
            ps.setString(5, service.getDescription());
            ps.setString(6, service.getStatus());
            ps.setDouble(7, service.getEstimatedCost());
            ps.setInt(8, service.getServiceId());

            int result = ps.executeUpdate();

            ps.close();
            con.close();

            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // DELETE SERVICE REQUEST
    public boolean deleteServiceRequest(int serviceId) {

        String sql =
                "DELETE FROM service_requests "
              + "WHERE service_id = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, serviceId);

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