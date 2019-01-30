package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.DepartmentEntity;

public interface DepartmentService {

	Optional<DepartmentEntity> findById(int id);
	Optional<DepartmentEntity> findByName(String name);
	Optional<DepartmentEntity> findByWorkstationId(int workstationId);
	Optional<DepartmentEntity> findByIdAndWorkstationId(int id, int workstationId);
	void saveDepartment(DepartmentEntity departmentEntity);
    void updateDepartment(DepartmentEntity departmentEntity);
    void deleteDepartmentById(int id);
    void deleteDepartmentAll();
    List<DepartmentEntity> findDepartmentAll();
}
