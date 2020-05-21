package com.projectsbyabd.springbootmongodbapi;

import com.projectsbyabd.springbootmongodbapi.controller.UserController;
import com.projectsbyabd.springbootmongodbapi.respository.UserRepository;
import com.projectsbyabd.springbootmongodbapi.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTests {

	private MockMvc mockMvc;

	@InjectMocks
    UserController userController;

	@Mock
    UserService userService;
	UserRepository userRepository;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void testGetAllUsers() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getAllUsers"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
