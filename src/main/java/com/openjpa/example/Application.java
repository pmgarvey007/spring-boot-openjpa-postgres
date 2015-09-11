package com.openjpa.example;

import com.openjpa.example.entity.Employee;
import com.openjpa.example.entity.Manager;
import com.openjpa.example.repository.EmployeeRepository;
import com.openjpa.example.repository.ManagerRepository;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.OpenJpaVendorAdapter;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application extends JpaBaseConfiguration {
    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
        OpenJpaVendorAdapter jpaVendorAdapter = new OpenJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(true);
        return jpaVendorAdapter;
    }

    @Override
    protected Map<String, Object> getVendorProperties() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        return map;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(new Object[]{ Application.class }, args);
        EmployeeRepository empRepo = ctx.getBean(EmployeeRepository.class);
        ManagerRepository manRepo = ctx.getBean(ManagerRepository.class);

        Employee emp1 = new Employee("paul", "Doe");
        Employee emp2 = new Employee("Mike", "Brown");
        Employee emp3 = new Employee("Tim", "Hardy");

        empRepo.save(Arrays.asList(emp1, emp2, emp3));


        Manager m1 = new Manager("James", "Brown");
        Manager m2 = new Manager("Erica", "Martin");
        Manager m3 = new Manager("Tami", "Bell");

        manRepo.save(Arrays.asList(m1, m2, m3));

        List<Employee> list = empRepo.findAll();

        for (Employee emp : list) {
            System.out.println("employee ==> " + emp.toString());
        }

        List<Manager> listm = manRepo.findAll();

        for (Manager m : listm) {
            System.out.println("manager ==> " + m.toString());
        }

    }
}
