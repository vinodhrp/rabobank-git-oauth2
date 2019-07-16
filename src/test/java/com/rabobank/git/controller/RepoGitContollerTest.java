package com.rabobank.git.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



/**
 * 
 * @author vinodhrp
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RepoGitContollerTest {
	public Logger logger = LoggerFactory.getLogger(RepoGitContollerTest.class);
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.webApplicationContext);
		this.mockMvc = builder.build();
	}
	
	
	
	@Test
    public void getRepos() throws Exception {
		MvcResult result = mockMvc
				.perform(get("/repos/vinodhrp").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		logger.info(resultContent);
		int status = result.getResponse().getStatus();
		Assert.assertTrue(status == HttpStatus.SC_OK);
        
    }
	
	@Test
    public void getRepoDetail() throws Exception {
		MvcResult result = mockMvc
				.perform(get("/repos/pulls/spring/spring").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		logger.info(resultContent);
		int status = result.getResponse().getStatus();
		Assert.assertTrue(status == HttpStatus.SC_OK);
        
    }

}
