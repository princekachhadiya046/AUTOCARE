package dao;

import model.Invoice;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO {

    // ADD INVOICE
    public boolean addInvoice(Invoice invoice) {

        String sql =
                "INSERT INTO invoices "
              + "(invoice_id, service_id, invoice_date, subtotal, "
              + "tax_amount, discount_amount, total_amount, "
              + "payment_status, payment_method) "
              + "VALUES (invoice_seq.NEXTVAL, ?, "
              + "TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?, ?, ?, ?)";

        try {
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, invoice.getServiceId());
            ps.setString(2, invoice.getInvoiceDate());
            ps.setDouble(3, invoice.getSubtotal());
            ps.setDouble(4, invoice.getTaxAmount());
            ps.setDouble(5, invoice.getDiscountAmount());
            ps.setDouble(6, invoice.getTotalAmount());
            ps.setString(7, invoice.getPaymentStatus());
            ps.setString(8, invoice.getPaymentMethod());

            int result =
                    ps.executeUpdate();

            ps.close();
            con.close();

            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // GET ALL INVOICES
    public List<Invoice> getAllInvoices() {

        List<Invoice> invoices =
                new ArrayList<Invoice>();

        String sql =
                "SELECT i.invoice_id, "
              + "i.service_id, "
              + "s.service_type, "
              + "v.vehicle_number, "
              + "m.full_name AS mechanic_name, "
              + "TO_CHAR(i.invoice_date, 'YYYY-MM-DD') AS invoice_date, "
              + "i.subtotal, "
              + "i.tax_amount, "
              + "i.discount_amount, "
              + "i.total_amount, "
              + "i.payment_status, "
              + "i.payment_method "
              + "FROM invoices i "
              + "JOIN service_requests s "
              + "ON i.service_id = s.service_id "
              + "JOIN vehicles v "
              + "ON s.vehicle_id = v.vehicle_id "
              + "LEFT JOIN mechanics m "
              + "ON s.mechanic_id = m.mechanic_id "
              + "ORDER BY i.invoice_id";

        try {
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                Invoice invoice =
                        new Invoice();

                invoice.setInvoiceId(
                        rs.getInt("invoice_id"));

                invoice.setServiceId(
                        rs.getInt("service_id"));

                invoice.setServiceType(
                        rs.getString("service_type"));

                invoice.setVehicleNumber(
                        rs.getString("vehicle_number"));

                invoice.setMechanicName(
                        rs.getString("mechanic_name"));

                invoice.setInvoiceDate(
                        rs.getString("invoice_date"));

                invoice.setSubtotal(
                        rs.getDouble("subtotal"));

                invoice.setTaxAmount(
                        rs.getDouble("tax_amount"));

                invoice.setDiscountAmount(
                        rs.getDouble("discount_amount"));

                invoice.setTotalAmount(
                        rs.getDouble("total_amount"));

                invoice.setPaymentStatus(
                        rs.getString("payment_status"));

                invoice.setPaymentMethod(
                        rs.getString("payment_method"));

                invoices.add(invoice);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return invoices;
    }


    // GET INVOICE BY ID
    public Invoice getInvoiceById(int invoiceId) {

        Invoice invoice = null;

        String sql =
                "SELECT i.invoice_id, "
              + "i.service_id, "
              + "s.service_type, "
              + "v.vehicle_number, "
              + "m.full_name AS mechanic_name, "
              + "TO_CHAR(i.invoice_date, 'YYYY-MM-DD') AS invoice_date, "
              + "i.subtotal, "
              + "i.tax_amount, "
              + "i.discount_amount, "
              + "i.total_amount, "
              + "i.payment_status, "
              + "i.payment_method "
              + "FROM invoices i "
              + "JOIN service_requests s "
              + "ON i.service_id = s.service_id "
              + "JOIN vehicles v "
              + "ON s.vehicle_id = v.vehicle_id "
              + "LEFT JOIN mechanics m "
              + "ON s.mechanic_id = m.mechanic_id "
              + "WHERE i.invoice_id = ?";

        try {
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, invoiceId);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                invoice =
                        new Invoice();

                invoice.setInvoiceId(
                        rs.getInt("invoice_id"));

                invoice.setServiceId(
                        rs.getInt("service_id"));

                invoice.setServiceType(
                        rs.getString("service_type"));

                invoice.setVehicleNumber(
                        rs.getString("vehicle_number"));

                invoice.setMechanicName(
                        rs.getString("mechanic_name"));

                invoice.setInvoiceDate(
                        rs.getString("invoice_date"));

                invoice.setSubtotal(
                        rs.getDouble("subtotal"));

                invoice.setTaxAmount(
                        rs.getDouble("tax_amount"));

                invoice.setDiscountAmount(
                        rs.getDouble("discount_amount"));

                invoice.setTotalAmount(
                        rs.getDouble("total_amount"));

                invoice.setPaymentStatus(
                        rs.getString("payment_status"));

                invoice.setPaymentMethod(
                        rs.getString("payment_method"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return invoice;
    }


    // UPDATE INVOICE
    public boolean updateInvoice(Invoice invoice) {

        String sql =
                "UPDATE invoices SET "
              + "service_id = ?, "
              + "invoice_date = TO_DATE(?, 'YYYY-MM-DD'), "
              + "subtotal = ?, "
              + "tax_amount = ?, "
              + "discount_amount = ?, "
              + "total_amount = ?, "
              + "payment_status = ?, "
              + "payment_method = ? "
              + "WHERE invoice_id = ?";

        try {
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, invoice.getServiceId());
            ps.setString(2, invoice.getInvoiceDate());
            ps.setDouble(3, invoice.getSubtotal());
            ps.setDouble(4, invoice.getTaxAmount());
            ps.setDouble(5, invoice.getDiscountAmount());
            ps.setDouble(6, invoice.getTotalAmount());
            ps.setString(7, invoice.getPaymentStatus());
            ps.setString(8, invoice.getPaymentMethod());
            ps.setInt(9, invoice.getInvoiceId());

            int result =
                    ps.executeUpdate();

            ps.close();
            con.close();

            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // DELETE INVOICE
    public boolean deleteInvoice(int invoiceId) {

        String sql =
                "DELETE FROM invoices "
              + "WHERE invoice_id = ?";

        try {
            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, invoiceId);

            int result =
                    ps.executeUpdate();

            ps.close();
            con.close();

            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}