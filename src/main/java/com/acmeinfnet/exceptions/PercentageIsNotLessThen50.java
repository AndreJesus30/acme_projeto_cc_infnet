package com.acmeinfnet.exceptions;

public class PercentageIsNotLessThen50 extends RuntimeException{

    public PercentageIsNotLessThen50() {
        super("Percentual de reajuste informado não é menor que 50");
    }
    
}
