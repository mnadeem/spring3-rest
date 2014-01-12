package com.nadeem.app.rest.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/com/nadeem/app/rest/config/service/rest-service-test.ctxt.xml",
                                        "classpath:/com/nadeem/app/rest/config/web/rest-web.ctxt.xml"})
@WebAppConfiguration
public class EmployeeControllerTest
{

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void doBeforeEachTestCase() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void test() throws Exception
    {
       this.mockMvc.perform(get("/emp/{id}", 1).accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk());          
    }
}
