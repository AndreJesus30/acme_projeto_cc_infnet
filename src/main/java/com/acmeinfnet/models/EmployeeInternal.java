package com.acmeinfnet.models;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import com.acmeinfnet.enums.DepartmentEnum;
import com.acmeinfnet.enums.ResponsibilityEnum;
import com.acmeinfnet.exceptions.PercentageIsNotLessThen50;
import com.acmeinfnet.exceptions.PercentageIsNotPositiveException;
import com.acmeinfnet.interfaces.RemunerationInterface;

public class EmployeeInternal extends Employee implements RemunerationInterface {

    private EmployeeInternal(Builder builder) {
        super(
            builder.name, 
            builder.phones, 
            builder.address, 
            builder.remuneration, 
            builder.department, 
            builder.responsibility
        );
    }

    public static class Builder {
        private String name;
        private List<String> phones;
        private String address;
        private BigDecimal remuneration;
        private DepartmentEnum department;
        private ResponsibilityEnum responsibility;


        public Builder (String name, BigDecimal remuneration) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
            }
            this.name = name;

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

        public EmployeeInternal build() {
            return new EmployeeInternal(this);
        }

    }

    @Override
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
