package com.example.demo.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.DepartmentEntity;

@Repository
public interface DepartmentDAO extends JpaRepository<DepartmentEntity, Integer> {
	Optional<DepartmentEntity> findByName(String name);
	Optional<DepartmentEntity> findByWorkstationId(int workstationId);
	Optional<DepartmentEntity> findByIdAndWorkstationId(int id, int workstationId);
}
