package com.example.demo.DAOImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.DepartmentDAO;
import com.example.demo.Entity.DepartmentEntity;
import com.example.demo.Service.DepartmentService;

@Service("DepartmentService")
@Transactional
public class DepartmentDAOImpl implements DepartmentService{
	
	@Autowired
	DepartmentDAO departmentDAO;

	@Override
	public Optional<DepartmentEntity> findById(int id) {
		return departmentDAO.findById(id);
	}
	
	@Override
	public Optional<DepartmentEntity> findByName(String name) {
		return departmentDAO.findByName(name);
	}
	
	@Override
	public Optional<DepartmentEntity> findByWorkstationId(int workstationId) {
		return departmentDAO.findByWorkstationId(workstationId);
	}
	
	@Override
	public Optional<DepartmentEntity> findByIdAndWorkstationId(int id, int workstationId) {
		return departmentDAO.findByIdAndWorkstationId(id, workstationId);
	}
	
	@Override
    public void saveDepartment(DepartmentEntity departmentEntity) {
        departmentDAO.save(departmentEntity);
    }
	
	@Override
	public void updateDepartment(DepartmentEntity departmentEntity) {
		saveDepartment(departmentEntity);
	}
	
	@Override
	public void deleteDepartmentById(int id) {
		departmentDAO.deleteById(id);
	}
	
	@Override
	public void deleteDepartmentAll() {
		departmentDAO.deleteAll();
	}
	
	@Override
	public List<DepartmentEntity> findDepartmentAll(){
		return departmentDAO.findAll();
	}
}
