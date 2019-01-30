package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.MUserEntity;

public interface MUserService {
	Optional<MUserEntity> findById(int id);
	Optional<MUserEntity> findByUsername(String name);
	void saveMUser(MUserEntity mUserEntity);
    void updateMUser(MUserEntity mUserEntity);
    void deleteMUserById(int id);
    void deleteMUserAll();
    List<MUserEntity> findMUserAll();
}
