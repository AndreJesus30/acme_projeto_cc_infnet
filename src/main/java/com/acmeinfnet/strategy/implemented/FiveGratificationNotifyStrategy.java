package com.acmeinfnet.strategy.implemented;
import com.acmeinfnet.strategy.GratificationNotifyStrategy;

public class FiveGratificationNotifyStrategy implements GratificationNotifyStrategy {
    
    @Override
    public void sendNotifyGratification(String employeeName) {
      System.out.println(employeeName +" "+ "você será gratificado(a) com um aumento por completar 3 anos de empresa");
    }
}
