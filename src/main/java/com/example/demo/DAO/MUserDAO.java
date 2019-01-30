package com.example.demo.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.MUserEntity;

@Repository
public interface MUserDAO extends JpaRepository<MUserEntity, Integer> {
	Optional<MUserEntity> findByUsername(String username);
}
