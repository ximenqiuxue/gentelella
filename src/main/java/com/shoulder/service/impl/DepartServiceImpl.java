package com.shoulder.service.impl;

import com.shoulder.mapper.DepartMapper;
import com.shoulder.model.department;
import com.shoulder.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartServiceImpl implements DepartService {

    @Autowired
    DepartMapper departMapper;

    @Override
    public List<department> getAll() throws Exception {
        return departMapper.findAll();
    }
}
