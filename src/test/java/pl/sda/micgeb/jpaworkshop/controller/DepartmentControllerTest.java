package pl.sda.micgeb.jpaworkshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.sda.micgeb.jpaworkshop.model.Address;
import pl.sda.micgeb.jpaworkshop.model.dto.DepartmentDto;
import pl.sda.micgeb.jpaworkshop.model.entity.Department;
import pl.sda.micgeb.jpaworkshop.service.DepartmentService;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private DepartmentService departmentService;

    @Test
    void findByName() throws Exception {
        //given
        String departmentName = "IT";
        var department = new Department();
        department.setName(departmentName);

        Mockito.when(departmentService.findDepartmentByName(departmentName)).thenReturn(department);

        //when //then
        mockMvc.perform(get("/department/findByName")
                .param("departmentName", departmentName))
//                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(departmentName));
    }

    @Test
    void addNew() throws Exception {
        //given
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName("IT");
        departmentDto.setAddress(
                new Address("Anglia", "Londyn", "some street", "11222"));

        Mockito.doNothing().when(departmentService).addNewDepartment(departmentDto);

        //when //then
        mockMvc.perform(post("/department/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(departmentDto))
        ).andExpect(status().isOk());
    }
}