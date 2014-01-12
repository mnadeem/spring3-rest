package com.nadeem.app.rest.web.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.nadeem.app.rest.repository.entitiy.Employee;
import com.nadeem.app.rest.service.EmployeeService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/com/nadeem/app/rest/config/service/rest-service-test.ctxt.xml",
                                        "classpath:/com/nadeem/app/rest/config/web/rest-web.ctxt.xml"})
@WebAppConfiguration
public class EmployeeControllerTest
{

    private MockMvc mockMvc;

    @Autowired
    private MockServletContext servletContext;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void doBeforeEachTestCase() {
        //We have to reset our mock between tests because the mock objects
        //are managed by the Spring container. If we would not reset them,
        //stubbing and verified behavior would "leak" from one test to another.
        Mockito.reset(this.employeeService);

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void AdminShouldSuccessfullyGetEmployeeById() throws Exception
    {
        this.servletContext.declareRoles("Admin");
        when(this.employeeService.findById(1l)).thenReturn(newEmployee(1l));
        this.mockMvc.perform(get("/emp/{id}", 1l).accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.id").value(1));;          
    }

    private Employee newEmployee(long id)
    {
        return new Employee(id);
    }
}
