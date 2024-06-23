package com.acmeinfnet.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.acmeinfnet.enums.DepartmentEnum;
import com.acmeinfnet.enums.ResponsibilityEnum;

public class EmployeeOutsourced extends Employee {

    private String hiredCompany;
    private LocalDate daysOfStay;

    public EmployeeOutsourced(String name, List<String> phones, String address, BigDecimal remuneration,
    DepartmentEnum department, ResponsibilityEnum responsibility, String hiredCompany) {
        super(name, phones, address, remuneration, department, responsibility);
        this.hiredCompany = hiredCompany;
        this.daysOfStay = ChronoUnit.DAYS.addTo(LocalDate.now(), 60);
    }


    public String getHiredCompany() {
        return hiredCompany;
    }


    public void setHiredCompany(String hiredCompany) {
        this.hiredCompany = hiredCompany;
    }


    public LocalDate getDaysOfStay() {
        return daysOfStay;
    }


    public void setDaysOfStay(LocalDate daysOfStay) {
        this.daysOfStay = daysOfStay;
    }


    @Override
    public String toString() {
        return super.toString() + "Outsourced [hiredCompany=" + hiredCompany + ", daysOfStay=" + daysOfStay + "]";
    }


}
