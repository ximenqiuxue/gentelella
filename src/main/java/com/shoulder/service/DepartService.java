package com.shoulder.service;

import com.shoulder.model.Department;

import java.util.List;

public interface DepartService {
    List<Department> getAll() throws Exception;
}
