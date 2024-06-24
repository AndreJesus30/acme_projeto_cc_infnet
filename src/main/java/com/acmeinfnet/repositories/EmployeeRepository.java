package com.acmeinfnet.repositories;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository<T> {
    
    private List<T> listEmployees;

    private static EmployeeRepository<?> instance;

    private EmployeeRepository() {
        this.listEmployees = new ArrayList<>();
    }

    public static EmployeeRepository<?> getInstance() {
        if(instance == null) {
            instance = new EmployeeRepository<>();
        }

        return instance;
    }

    public void save(T employee) {
        this.listEmployees.add(employee);
    }

    public List<T> getAll() {
        return this.listEmployees;
    }

}
