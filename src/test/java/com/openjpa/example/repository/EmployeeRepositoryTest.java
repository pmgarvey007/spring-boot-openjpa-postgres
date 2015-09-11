package com.openjpa.example.repository;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import com.openjpa.example.Application;
import com.openjpa.example.entity.Employee;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class EmployeeRepositoryTest {
	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void testEmployee() {

		Employee emp1 = new Employee("paul", "Doe");
		Employee emp2 = new Employee("Erica", "Doe");
		Employee emp3 = new Employee("Tami", "Doe");

		employeeRepository.save(Arrays.asList(emp1, emp2, emp3));

		List<Employee> empList = employeeRepository.findAll();
		assertThat(empList, is(not(nullValue())));
		assertThat(empList.size(), is(equalTo(3)));

		Page<Employee> employeePage = this.employeeRepository.findAll(new PageRequest(0, 10));

		assertThat(employeePage.getTotalElements(), is(greaterThan(2L)));

		employeeRepository.deleteAll();

		empList = employeeRepository.findAll();

		assertThat(empList.size(), is(equalTo(0)));

	}
}
