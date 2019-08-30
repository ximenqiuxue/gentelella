package com.shoulder.service;

import com.shoulder.model.department;

import java.util.List;

public interface DepartService {
    List<department> getAll() throws Exception;
}
