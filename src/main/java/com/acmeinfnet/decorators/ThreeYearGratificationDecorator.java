package com.acmeinfnet.decorators;

import java.math.BigDecimal;

import com.acmeinfnet.decorators.implemented.EmployeeGratificationDecorator;
import com.acmeinfnet.models.EmployeeInternal;

public class ThreeYearGratificationDecorator  extends EmployeeGratificationDecorator {
        public ThreeYearGratificationDecorator(EmployeeInternal decoratedEmployee) {
        super(decoratedEmployee);
    }

    @Override
    public BigDecimal getRemuneration() {
        if(decoratedEmployee.getYearsOfService() >= 3 && decoratedEmployee.getYearsOfService() < 5) {
            return decoratedEmployee.getRemuneration().multiply(BigDecimal.valueOf(1.20));
        } else {
            return decoratedEmployee.getRemuneration();
        }
    }
}
