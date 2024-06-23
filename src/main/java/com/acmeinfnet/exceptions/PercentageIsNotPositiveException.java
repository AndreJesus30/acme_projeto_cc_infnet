package com.acmeinfnet.exceptions;

public class PercentageIsNotPositiveException extends RuntimeException {

    public PercentageIsNotPositiveException() {
        super("Percentual informado não é um valor positivo");
    }
    
}
