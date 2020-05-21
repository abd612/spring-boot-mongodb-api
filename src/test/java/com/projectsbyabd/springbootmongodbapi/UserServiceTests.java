package com.projectsbyabd.springbootmongodbapi;

import com.projectsbyabd.springbootmongodbapi.model.User;
import com.projectsbyabd.springbootmongodbapi.respository.UserRepository;
import com.projectsbyabd.springbootmongodbapi.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

	@InjectMocks
	UserService userService;

	@Mock
    UserRepository userRepository;

	@Test
	public void testGetAllUsers() {
		List<User> expectedUsers = new ArrayList<User>();
		User expectedUser1 = new User("Clint Barton", "44", "Waverly");
		User expectedUser2 = new User("Natasha Romanoff", "38", "Moscow");

		expectedUsers.add(expectedUser1);
		expectedUsers.add(expectedUser2);

		Mockito.when(userRepository.findAll()).thenReturn(expectedUsers);

		List<User> actualUsers = userService.getAllUsers();

		Assert.assertEquals(expectedUsers, actualUsers);

		for (User user: actualUsers) {
			System.out.println(user.toString());
		}
	}

}
