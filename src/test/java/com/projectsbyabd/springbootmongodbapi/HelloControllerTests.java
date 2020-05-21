package com.projectsbyabd.springbootmongodbapi;

import com.projectsbyabd.springbootmongodbapi.controller.HelloController;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTests {

	private MockMvc mockMvc;

	@InjectMocks
    HelloController helloController;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
	}

	@Test
	public void helloTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Hello World from Azure!"));
	}

}
