package com.acmeinfnet.models;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.acmeinfnet.enums.DepartmentEnum;
import com.acmeinfnet.enums.ResponsibilityEnum;

public class EmployeeOutsourced extends Employee {

    private String hiredCompany;
    private LocalDate daysOfStay;

    private EmployeeOutsourced(Builder builder) {
        super(
            builder.name, 
            builder.phones, 
            builder.address, 
            builder.remuneration, 
            builder.department, 
            builder.responsibility
        );
        this.hiredCompany = builder.hiredCompany;
        this.daysOfStay = builder.daysOfStay;
    }

    public static class Builder {
        private String name;
        private List<String> phones;
        private String address;
        private BigDecimal remuneration;
        private DepartmentEnum department;
        private ResponsibilityEnum responsibility;
        private String hiredCompany;
        private LocalDate daysOfStay;


        public Builder (String name, String hiredCompany, BigDecimal remuneration) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
            }
            this.name = name;

            if (hiredCompany == null || hiredCompany.isEmpty()) {
                throw new IllegalArgumentException("Empresa não pode ser nulo ou vazio");
            }
            this.hiredCompany = hiredCompany;

            if (remuneration == null || remuneration.equals(BigDecimal.ZERO)) {
                throw new IllegalArgumentException("Remuneração não pode ser nula ou zero");
            }
            this.remuneration = remuneration;
        }

        public Builder phones(List<String> phones) {
            this.phones = phones;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder department(DepartmentEnum department) {
            this.department = department;
            return this;
        }

        public Builder responsibility(ResponsibilityEnum responsibility) {
            this.responsibility = responsibility;
            return this;
        }

        public EmployeeOutsourced build() {
            return new EmployeeOutsourced(this);
        }

    }


    @Override
    public String toString() {
        return super.toString() + "Outsourced [hiredCompany=" + hiredCompany + ", daysOfStay=" + daysOfStay + "]";
    }


}
