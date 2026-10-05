package model;

public class Mechanic {

    private int mechanicId;
    private String fullName;
    private String phone;
    private String email;
    private String specialization;
    private int experienceYears;
    private String status;

    public Mechanic() {
    }

    public Mechanic(
            int mechanicId,
            String fullName,
            String phone,
            String email,
            String specialization,
            int experienceYears,
            String status) {

        this.mechanicId = mechanicId;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
        this.status = status;
    }

    public int getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(int mechanicId) {
        this.mechanicId = mechanicId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}