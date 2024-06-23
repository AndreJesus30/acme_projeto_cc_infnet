package com.acmeinfnet.models;
import java.math.BigDecimal;
import java.util.List;

import com.acmeinfnet.enums.DepartmentEnum;
import com.acmeinfnet.enums.ResponsibilityEnum;

public abstract class Employee {

    private String name;
    private List<String> phones;
    private String address;
    protected BigDecimal remuneration;
    private DepartmentEnum department;
    private ResponsibilityEnum responsibility;
    

    public Employee(String name, List<String> phones, String address, BigDecimal remuneration,
            DepartmentEnum department, ResponsibilityEnum responsibility) {
        this.name = name;
        this.phones = phones;
        this.address = address;
        this.remuneration = remuneration;
        this.department = department;
        this.responsibility = responsibility;
    }

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getPhones() {
        return phones;
    }
    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public BigDecimal getRemuneration() {
        return remuneration;
    }
    public void setRemuneration(BigDecimal remuneration) {
        this.remuneration = remuneration;
    }
    public DepartmentEnum getDepartment() {
        return department;
    }
    public void setDepartment(DepartmentEnum department) {
        this.department = department;
    }
    public ResponsibilityEnum getResponsibility() {
        return responsibility;
    }
    public void setResponsibility(ResponsibilityEnum responsibility) {
        this.responsibility = responsibility;
    }

    public String toString() {
        return "Employee [name=" + name + ", phones=" + phones + ", address=" + address + ", remuneration="
                + remuneration + ", department=" + department + ", responsibility=" + responsibility + "]";
    }

}
