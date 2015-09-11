package com.openjpa.example.repository;

import com.openjpa.example.Application;
import com.openjpa.example.entity.Manager;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
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
public class ManagerRepositoryTest {
	@Autowired
	ManagerRepository managerRepository;

	@Test
	public void testManager() {

		Manager m1 = new Manager("paul", "Doe");
		Manager m2 = new Manager("Erica", "Jones");
		Manager m3 = new Manager("Tami", "Brown");

		managerRepository.save(Arrays.asList(m1, m2, m3));

		List<Manager> managers = managerRepository.findAll();
		assertThat(managers, is(not(nullValue())));
		assertThat(managers.size(), is(equalTo(3)));

		Page<Manager> managerPage = this.managerRepository.findAll(new PageRequest(0, 10));
		assertThat(managerPage.getTotalElements(), is(greaterThan(2L)));

		managerRepository.deleteAll();

		managers = managerRepository.findAll();

		assertThat(managers.size(), is(equalTo(0)));
	}
}
