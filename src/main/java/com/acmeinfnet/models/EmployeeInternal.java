package com.acmeinfnet.models;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import com.acmeinfnet.enums.DepartmentEnum;
import com.acmeinfnet.enums.ResponsibilityEnum;
import com.acmeinfnet.exceptions.PercentageIsNotLessThen50;
import com.acmeinfnet.exceptions.PercentageIsNotPositiveException;

public class EmployeeInternal extends Employee {
    
    public EmployeeInternal(String name, List<String> phones, String address, BigDecimal remuneration,
            DepartmentEnum department, ResponsibilityEnum responsibility, int yearsOfService) {
        super(name, phones, address, remuneration, department, responsibility, yearsOfService);
    }

    public void remunerationAdjustment(BigDecimal percentAdded) {
        if(!percentageIsPositive(percentAdded)) {
           throw new PercentageIsNotPositiveException();
        } else if(!percentageIsLessThan50(percentAdded)) {
           throw new PercentageIsNotLessThen50();
        } else {
            calcRemuneration(percentAdded);
        }
    }

    private boolean percentageIsPositive(BigDecimal percentAdded) {
        if(percentAdded.compareTo(BigDecimal.ZERO) > 0) {
            return true;
        } 
        return false;
    }

    private boolean percentageIsLessThan50(BigDecimal percentAdded) {
        if(percentAdded.compareTo(BigDecimal.valueOf(50)) < 0) {
            return true;
        }
        return false;
    }

    private void calcRemuneration(BigDecimal percentAdded) {
        BigDecimal factor = percentAdded.divide(BigDecimal.valueOf(100)).add(BigDecimal.valueOf(1));
        super.remuneration = super.remuneration.multiply(factor).round(MathContext.DECIMAL32);
    }

}
