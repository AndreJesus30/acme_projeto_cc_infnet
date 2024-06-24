package com.acmeinfnet;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.acmeinfnet.enums.DepartmentEnum;
import com.acmeinfnet.enums.ResponsibilityEnum;
import com.acmeinfnet.models.EmployeeInternal;
import com.acmeinfnet.repositories.EmployeeRepository;

@SuppressWarnings("unchecked")
public class Main {
    public static void main(String[] args) {
        EmployeeRepository<EmployeeInternal> employeeRepository = (EmployeeRepository<EmployeeInternal>) EmployeeRepository.getInstance();

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

        employeeRepository.save(employee1);
            
        EmployeeInternal employee2 = new EmployeeInternal.Builder(
            "Tulio", 
            BigDecimal.valueOf(7000)
        )
        .department(DepartmentEnum.DEVOPS)
        .responsibility(ResponsibilityEnum.MID)
        .build();

        employeeRepository.save(employee2);

        List<EmployeeInternal> listEmployeeInternal = employeeRepository.getAll(); 
        
        listEmployeeInternal.forEach((e) -> System.out.println(e));

        System.out.println("salário João inicial : " + employee1.getRemuneration());
        employee1.remunerationAdjustment(BigDecimal.valueOf(22.0F));
        System.out.println("salário João após reajuste: " + employee1.getRemuneration());


    }
}