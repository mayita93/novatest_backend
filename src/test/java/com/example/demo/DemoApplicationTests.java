package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { DemoApplication.class })
public class DemoApplicationTests {

	private MockMvc mockMvc;
	
	
	@Before
	public void init() {
		DemoApplication mainApplication = new DemoApplication();
		DemoApplication.main(new String[] {});
		Assert.assertNotNull(mainApplication);
	}
	
	
	@Test
	public void main() {
		DemoApplication mainApplication = new DemoApplication();
		DemoApplication.main(new String[] {});
		Assert.assertNotNull(mainApplication);
	}	
	
    @Test
    public void testCorsMapping() throws Exception {
    	DemoApplication app = new DemoApplication();
        mockMvc = MockMvcBuilders.standaloneSetup(app).build();

        mockMvc.perform(MockMvcRequestBuilders.options("/*")
            .header("Access-Control-Request-Method", "POST")
            .header("Origin", "http://localhost:4200"))
            .andExpect(status().isOk())
            .andExpect(header().string("Access-Control-Allow-Origin", "http://localhost:4200"))
            .andExpect(header().string("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"))
            .andExpect(header().string("Access-Control-Max-Age", "3600"))
            .andExpect(header().string("Access-Control-Allow-Headers", "content-type, authorization"));
    }	

}