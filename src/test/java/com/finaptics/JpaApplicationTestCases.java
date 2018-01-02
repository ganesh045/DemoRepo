package com.finaptics;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.finaptics.entity.Mobile;
import com.finaptics.entity.User;
import com.finaptics.repo.ApplicationService;


public class JpaApplicationTestCases extends JpaRelationships2ApplicationTests {

	private MockMvc mockMvc;
	
	@Mock
	private ApplicationService service;
	
	@InjectMocks
	private ApplicationController controller;
	
	@Before
	public void setUp() {
		
		MockitoAnnotations.initMocks(this);
		
		mockMvc=MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Ignore
	@Test
	public void testFindAll() throws Exception {
		
		List<User> users=Arrays.asList(new User(1,"kabali"),new User(2,"Bahubali"));
		
		when(service.findAllUsers()).thenReturn(users);
		
		mockMvc.perform(get("/findall")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0].userId",is(1)))
				.andExpect(jsonPath("$[0].userName",is("kabali"))).andExpect(jsonPath("$[1].userName",is("bahubali"))).andExpect(jsonPath("$[1].id",is(2)));
	//	fail("Not yet implemented");
	}
	
	@Test
	public void testFindObject() throws Exception {
		
		/*List<User> users=Arrays.asList(new User(1,"kabali"),new User(2,"Bahubali"));
		*/
		Mobile mobile =new Mobile(1,"Moto");
		when(service.findOneObject(1)).thenReturn(mobile);
		
		mockMvc.perform(get("/findonemobile/1")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.mobile_id",is(1)))
				.andExpect(jsonPath("$.brandName",is("Moto")));
				
	//	fail("Not yet implemented");
	}

}