package dao;

import model.Customer;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerDAO {

    public boolean addCustomer(Customer customer) {

        String sql = "INSERT INTO customers "
                   + "(customer_id, full_name, phone, email, address) "
                   + "VALUES (customers_seq.NEXTVAL, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, customer.getFullName());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getAddress());

            int result = ps.executeUpdate();

            ps.close();
            con.close();

            return result > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
    public java.util.List<Customer> getAllCustomers() {

        java.util.List<Customer> customers =
                new java.util.ArrayList<Customer>();

        String sql = "SELECT customer_id, full_name, phone, email, address "
               + "FROM customers ORDER BY customer_id";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            java.sql.ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Customer customer = new Customer();

                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setFullName(rs.getString("full_name"));
                customer.setPhone(rs.getString("phone"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("address"));

                customers.add(customer);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return customers;
    }

    public boolean updateCustomer(Customer customer) {

        String sql = "UPDATE customers SET "
               + "full_name = ?, "
               + "phone = ?, "
               + "email = ?, "
               + "address = ? "
               + "WHERE customer_id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, customer.getFullName());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getAddress());
            ps.setInt(5, customer.getCustomerId());

            int result = ps.executeUpdate();

            ps.close();
            con.close();

            return result > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
                    

    public Customer getCustomerById(int customerId) {

    String sql = "SELECT customer_id, full_name, phone, email, address "
               + "FROM customers "
               + "WHERE customer_id = ?";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, customerId);

        java.sql.ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            Customer customer = new Customer();

            customer.setCustomerId(rs.getInt("customer_id"));
            customer.setFullName(rs.getString("full_name"));
            customer.setPhone(rs.getString("phone"));
            customer.setEmail(rs.getString("email"));
            customer.setAddress(rs.getString("address"));

            rs.close();
            ps.close();
            con.close();

            return customer;
        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {

        e.printStackTrace();
    }

    return null;
}
    public boolean deleteCustomer(int customerId) {

        String sql = "DELETE FROM customers WHERE customer_id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, customerId);

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
        
                

            

                         
    

   



    

