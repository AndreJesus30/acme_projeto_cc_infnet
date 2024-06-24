package com.acmeinfnet.decorators.implemented;

import java.math.BigDecimal;

import com.acmeinfnet.models.Employee;
import com.acmeinfnet.models.EmployeeInternal;

public abstract class EmployeeGratificationDecorator extends EmployeeInternal {
        protected Employee decoratedEmployee;

    public EmployeeGratificationDecorator(Employee decoratedEmployee) {
        super(
        decoratedEmployee.getName(),
         decoratedEmployee.getPhones(),
         decoratedEmployee.getAddress(),
         decoratedEmployee.getRemuneration(),
         decoratedEmployee.getDepartment(),
         decoratedEmployee.getResponsibility(),
         decoratedEmployee.getYearsOfService()
         );
        this.decoratedEmployee = decoratedEmployee;
    }

    public abstract BigDecimal getRemuneration();
}
