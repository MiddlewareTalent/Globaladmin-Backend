package com.middleware.global_admin.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CompanyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String companyCode;
    private String companyEmail;
    private String companyMobile;
    private String companyDomain;
    private String companyServer;
    private String companyLocation;
    private Date registeredDate;

    private boolean OrganisationChart;
    private boolean Tasks;
    private boolean LeaveManagement;
    private boolean TimeSheet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyMobile() {
        return companyMobile;
    }

    public void setCompanyMobile(String companyMobile) {
        this.companyMobile = companyMobile;
    }

    public String getCompanyDomain() {
        return companyDomain;
    }

    public void setCompanyDomain(String companyDomain) {
        this.companyDomain = companyDomain;
    }

    public String getCompanyServer() {
        return companyServer;
    }

    public void setCompanyServer(String companyServer) {
        this.companyServer = companyServer;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public boolean isOrganisationChart() {
        return OrganisationChart;
    }

    public void setOrganisationChart(boolean organisationChart) {
        OrganisationChart = organisationChart;
    }

    public boolean isTasks() {
        return Tasks;
    }

    public void setTasks(boolean tasks) {
        Tasks = tasks;
    }

    public boolean isLeaveManagement() {
        return LeaveManagement;
    }

    public void setLeaveManagement(boolean leaveManagement) {
        LeaveManagement = leaveManagement;
    }

    public boolean isTimeSheet() {
        return TimeSheet;
    }

    public void setTimeSheet(boolean timeSheet) {
        TimeSheet = timeSheet;
    }
}
