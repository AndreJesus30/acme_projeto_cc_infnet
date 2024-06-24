package com.acmeinfnet.decorators.implemented;

import java.math.BigDecimal;

import com.acmeinfnet.models.EmployeeInternal;

public class FiveYearGratificationDecorator  extends EmployeeGratificationDecorator {
        public FiveYearGratificationDecorator(EmployeeInternal decoratedEmployee) {
        super(decoratedEmployee);
    }

    @Override
    public BigDecimal getRemuneration() {
        if(decoratedEmployee.getYearsOfService() >= 5) {
            return decoratedEmployee.getRemuneration().multiply(BigDecimal.valueOf(1.30));
        } else {
            return decoratedEmployee.getRemuneration();
        }
    }
}
