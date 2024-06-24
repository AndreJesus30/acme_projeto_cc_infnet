package com.acmeinfnet.decorators.implemented;

import java.math.BigDecimal;
import com.acmeinfnet.models.EmployeeInternal;

public class OneYearGratificationDecorator extends EmployeeGratificationDecorator {

    public OneYearGratificationDecorator(EmployeeInternal decoratedEmployee) {
        super(decoratedEmployee);
    }

    @Override
    public BigDecimal getRemuneration() {
        if(decoratedEmployee.getYearsOfService() >= 1 && decoratedEmployee.getYearsOfService() < 3) {
            return decoratedEmployee.getRemuneration().multiply(BigDecimal.valueOf(1.10));
        } else {
            return decoratedEmployee.getRemuneration();
        }
    }

}


