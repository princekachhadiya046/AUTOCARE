package model;

public class Invoice {

    private int invoiceId;
    private int serviceId;
    private String serviceType;
    private String vehicleNumber;
    private String mechanicName;
    private String invoiceDate;

    private double subtotal;
    private double taxAmount;
    private double discountAmount;
    private double totalAmount;

    private String paymentStatus;
    private String paymentMethod;


    // Default Constructor
    public Invoice() {
    }


    // Parameterized Constructor
    public Invoice(
            int invoiceId,
            int serviceId,
            String serviceType,
            String vehicleNumber,
            String mechanicName,
            String invoiceDate,
            double subtotal,
            double taxAmount,
            double discountAmount,
            double totalAmount,
            String paymentStatus,
            String paymentMethod) {

        this.invoiceId = invoiceId;
        this.serviceId = serviceId;
        this.serviceType = serviceType;
        this.vehicleNumber = vehicleNumber;
        this.mechanicName = mechanicName;
        this.invoiceDate = invoiceDate;
        this.subtotal = subtotal;
        this.taxAmount = taxAmount;
        this.discountAmount = discountAmount;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
    }


    // Invoice ID
    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }


    // Service ID
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }


    // Service Type
    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }


    // Vehicle Number
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }


    // Mechanic Name
    public String getMechanicName() {
        return mechanicName;
    }

    public void setMechanicName(String mechanicName) {
        this.mechanicName = mechanicName;
    }


    // Invoice Date
    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }


    // Subtotal
    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }


    // Tax Amount
    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }


    // Discount Amount
    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }


    // Total Amount
    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }


    // Payment Status
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


    // Payment Method
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}