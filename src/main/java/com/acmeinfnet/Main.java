package com.acmeinfnet;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.acmeinfnet.enums.DepartmentEnum;
import com.acmeinfnet.enums.ResponsibilityEnum;
import com.acmeinfnet.models.EmployeeInternal;
import com.acmeinfnet.models.EmployeeOutsourced;

public class Main {
    public static void main(String[] args) {
        System.out.println("===============================");
        System.out.println("Employee Internal");

        List<String> listPhonesEmployee1 = new ArrayList<String>(); 
        listPhonesEmployee1.add("62 99999-9999");
        listPhonesEmployee1.add("62 98888-8888");

        EmployeeInternal employee1 = new EmployeeInternal.Builder(
                "João", 
                BigDecimal.valueOf(5000)
            )
            .department(DepartmentEnum.DATABASE)
            .responsibility(ResponsibilityEnum.MID)
            .build();

        System.out.println(employee1.toString());
        System.out.println("salário inicial: " + employee1.getRemuneration());
        employee1.remunerationAdjustment(BigDecimal.valueOf(22.0F));
        System.out.println("salário após reajuste: " + employee1.getRemuneration());


        System.out.println("===============================");
        System.out.println("Employee Outsourced");

        List<String> listPhonesEmployee2 = new ArrayList<String>(); 
        listPhonesEmployee2.add("62 99999-9999");
        listPhonesEmployee2.add("62 98888-8888");

        EmployeeOutsourced employee2 = new EmployeeOutsourced.Builder(
            "Maria",
            "Company X", 
            BigDecimal.valueOf(3000)
            )
            .phones(listPhonesEmployee2)
            .address("Rua 2 Q 6")
            .department(DepartmentEnum.DEVELOPMENT)
            .responsibility(ResponsibilityEnum.INTERN)
            .build();
                
        System.out.println(employee2.toString());

    }
}