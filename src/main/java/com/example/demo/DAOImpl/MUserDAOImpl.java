package com.example.demo.DAOImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.MUserDAO;
import com.example.demo.Entity.MUserEntity;
import com.example.demo.Service.MUserService;

@Service("MUserService")
@Transactional
public class MUserDAOImpl implements MUserService {
	
	@Autowired
	MUserDAO mUserDAO;
	
	@Override
	public Optional<MUserEntity> findById(int id) {
		return mUserDAO.findById(id);
	}
	
	@Override
	public Optional<MUserEntity> findByUsername(String username) {
		return mUserDAO.findByUsername(username);
	}

	@Override
    public void saveMUser(MUserEntity mUserEntity) {
        mUserDAO.save(mUserEntity);
    }
	
	@Override
	public void updateMUser(MUserEntity mUserEntity) {
		saveMUser(mUserEntity);
	}
	
	@Override
	public void deleteMUserById(int id) {
		mUserDAO.deleteById(id);
	}
	
	@Override
	public void deleteMUserAll() {
		mUserDAO.deleteAll();
	}
	
	@Override
	public List<MUserEntity> findMUserAll(){
		return mUserDAO.findAll();
	}
}
