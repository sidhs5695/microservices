package com.citi.departmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.departmentservice.entity.Department;
import com.citi.departmentservice.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}
	public Department findDepartmentById(Long departmentId) {
		
        return departmentRepository.findByDepartmentId(departmentId);
    }

}
