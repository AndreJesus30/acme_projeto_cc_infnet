package com.acmeinfnet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.acmeinfnet.decorators.ThreeYearGratificationDecorator;
import com.acmeinfnet.decorators.implemented.FiveYearGratificationDecorator;
import com.acmeinfnet.decorators.implemented.OneYearGratificationDecorator;
import com.acmeinfnet.enums.DepartmentEnum;
import com.acmeinfnet.enums.ResponsibilityEnum;
import com.acmeinfnet.models.EmployeeInternal;
import com.acmeinfnet.strategy.GratificationNotifyStrategy;
import com.acmeinfnet.strategy.implemented.FiveGratificationNotifyStrategy;
import com.acmeinfnet.strategy.implemented.OneGratificationNotifyStrategy;
import com.acmeinfnet.strategy.implemented.ThreeGratificationNotifyStrategy;

public class Runner {
    public static void main(String[] args) {
          List<EmployeeInternal> listEmployeeInternal = new ArrayList<EmployeeInternal>();

        EmployeeInternal employee1 = new EmployeeInternal(
            "Felipe", 
            new ArrayList<>(Arrays.asList("62 98888-7777", "62 96666-5555")),
            "Rua 2 Q 6", BigDecimal.valueOf(5000), 
            DepartmentEnum.DATABASE, 
            ResponsibilityEnum.MID,
            1
            );

        EmployeeInternal employee2 = new EmployeeInternal(
            "Maria", 
            new ArrayList<>(Arrays.asList("63 95555-7777")),
            "Rua 2 Q 6", BigDecimal.valueOf(5000), 
            DepartmentEnum.DATABASE, 
            ResponsibilityEnum.MID,
            3
            );

        EmployeeInternal employee3 = new EmployeeInternal(
            "George", 
            new ArrayList<>(Arrays.asList("63 94444-5555")),
            "Rua 2 Q 6", BigDecimal.valueOf(5000), 
            DepartmentEnum.DATABASE, 
            ResponsibilityEnum.MID,
            0
            );

        EmployeeInternal employee4 = new EmployeeInternal(
            "Carla", 
            new ArrayList<>(Arrays.asList("63 93333-2222")),
            "Rua 2 Q 6", BigDecimal.valueOf(5000), 
            DepartmentEnum.DATABASE, 
            ResponsibilityEnum.MID,
            7
            );

        listEmployeeInternal.add(employee1);
        listEmployeeInternal.add(employee2);
        listEmployeeInternal.add(employee3);
        listEmployeeInternal.add(employee4);

        
       //PATTERN DECORATOR

       List<EmployeeInternal> listEmployeeInternalGratification = listEmployeeInternal.stream().map((e) -> {

                if(isYearsMoreThenOneAndLessThree(e)) {
                    e = new OneYearGratificationDecorator(e);
                }

                if(isYearsMoreThenThreeAndLessFive(e)) {
                    e = new ThreeYearGratificationDecorator(e);
                }

                if(isYearsMoreThenFive(e)) {
                    e = new FiveYearGratificationDecorator(e);
                }

                return e;
            }
        ).toList();

        listEmployeeInternalGratification.forEach((e) -> System.out.println(e.getName() +" "+ e.getRemuneration()));
        //


        //PATTERN STRATEGY

        Map<Integer, GratificationNotifyStrategy> mapGratificationStrategy = Map.of(
            1, new OneGratificationNotifyStrategy(),
            3, new ThreeGratificationNotifyStrategy(),
            5, new FiveGratificationNotifyStrategy()
        );
    
        listEmployeeInternal.forEach((e) -> {
            if(mapGratificationStrategy.containsKey(e.getYearsOfService())) {
                mapGratificationStrategy.get(e.getYearsOfService()).sendNotifyGratification(e.getName());;
            }
        });

        //
    }

    
    public static boolean isYearsMoreThenOneAndLessThree(EmployeeInternal employee) {
        if(employee.getYearsOfService() >= 1 && employee.getYearsOfService() < 3) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isYearsMoreThenThreeAndLessFive(EmployeeInternal employee) {
        if(employee.getYearsOfService() >= 3 && employee.getYearsOfService() < 5) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isYearsMoreThenFive(EmployeeInternal employee) {
        if(employee.getYearsOfService() >= 5) {
            return true;
        } else {
            return false;
        }
    }
}
