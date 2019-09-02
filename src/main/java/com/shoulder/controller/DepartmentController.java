package com.shoulder.controller;

import com.shoulder.model.Department;
import com.shoulder.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/dept")
public class DepartmentController {

    @Autowired
    private DepartService departService;

    @RequestMapping(value = "/index")
    public String getDepts() throws Exception {
        List<Department> departments = departService.getAll();
        return "department/list";
    }
}
