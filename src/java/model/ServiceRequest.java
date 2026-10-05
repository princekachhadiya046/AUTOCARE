package model;

public class ServiceRequest {

    private int serviceId;
    private int vehicleId;
    private String vehicleNumber;
    private int mechanicId;
    private String mechanicName;
    private String serviceType;
    private String serviceDate;
    private String description;
    private String status;
    private double estimatedCost;

    public ServiceRequest() {
    }

    public ServiceRequest(
        int serviceId,
        int vehicleId,
        String vehicleNumber,
        int mechanicId,
        String mechanicName,
        String serviceType,
        String serviceDate,
        String description,
        String status,
        double estimatedCost) {

    this.serviceId = serviceId;
    this.vehicleId = vehicleId;
    this.vehicleNumber = vehicleNumber;
    this.mechanicId = mechanicId;
    this.mechanicName = mechanicName;
    this.serviceType = serviceType;
    this.serviceDate = serviceDate;
    this.description = description;
    this.status = status;
    this.estimatedCost = estimatedCost;
}

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public int getMechanicId() {
    return mechanicId;
}

public void setMechanicId(int mechanicId) {
    this.mechanicId = mechanicId;
}

public String getMechanicName() {
    return mechanicName;
}

public void setMechanicName(String mechanicName) {
    this.mechanicName = mechanicName;
}

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }
}