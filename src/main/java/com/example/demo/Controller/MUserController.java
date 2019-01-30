package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.DTO.DepartmentDTO;
import com.example.demo.DTO.MUserDTO;
import com.example.demo.Entity.MUserEntity;
import com.example.demo.Service.MUserService;

@RestController
@RequestMapping("/user")
public class MUserController {
	
	public static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	Environment environment;
	
	@Autowired
	MUserService mUserService;
	
	@GetMapping("/fikri/{user_name}")
	public ResponseEntity<MUserDTO> retrieveMstUserById(@PathVariable("user_name") String user_name,
			@RequestHeader HttpHeaders headers) {
		
		//------------------------------------
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, String> uriVariable = new HashMap<>();
		uriVariable.put("user_name", user_name);
		logger.info("loadUserByUsername step 1");
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		logger.info("loadUserByUsername step 2");
		HttpEntity<String> entity = new HttpEntity<String>(header);
		
		ResponseEntity<MUserDTO[]> response = restTemplate.exchange("http://localhost:3000/api/users?filter[where][user_name]={username}",HttpMethod.GET, entity, MUserDTO[].class,uriVariable);
		logger.info("loadUserByUsername step 3");
		MUserDTO resp = response.getBody()[0];
		
		logger.info("loadUserByUsername: {}",resp.getPassword());
		
		//---------------------------------------------------------------
		MUserDTO dep = response.getBody()[0];
		logger.info("nama user: {}",dep.getUsername());
		
		if (!response.hasBody()) {
			return new ResponseEntity<MUserDTO> (dep, HttpStatus.OK);
		}else {
			logger.error("user_name not found: ",user_name);
			return new ResponseEntity<MUserDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	//  --------------- retreave single data ------------------
	@GetMapping("/{id}")
	public ResponseEntity<MUserDTO> retrieveMUser(@PathVariable("id") int id,
			@RequestHeader HttpHeaders headers) {
		
		logger.info("test id 1");
		Optional<MUserEntity> mUserEntity = mUserService.findById(id);
		logger.info("tets id 2");
		Map<String, String> uriVariable = new HashMap<>();
		uriVariable.put("id", String.valueOf(id));
		
		RestTemplate restTemplate = new RestTemplate();
		/*HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization: Bearer ", token); // add auth header with token
*/		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<DepartmentDTO> response = restTemplate.exchange("http://localhost:8060/department/{id}",HttpMethod.GET, entity, DepartmentDTO.class,uriVariable);
		
		//assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		
		DepartmentDTO dep = response.getBody();
		
		logger.info("nama department: {}",dep.getName());
		
		if (mUserEntity.isPresent()) {
			MUserDTO mUserDTO = new MUserDTO(mUserEntity.get().getId(), mUserEntity.get().getUsername(), mUserEntity.get().getPassword(), mUserEntity.get().getAccountExpired(), mUserEntity.get().getAccountLocked(), mUserEntity.get().getCredentialExpired(), mUserEntity.get().getEnabled());
			return new ResponseEntity<MUserDTO> (mUserDTO, HttpStatus.OK);
		}else {
			logger.error("id not found: ",id);
			return new ResponseEntity<MUserDTO>(HttpStatus.NOT_FOUND);
		}
	}

	// ---------------- retrieve all data ----------------------
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> getAllMUser(){
		logger.info("test 1");
		List<MUserEntity> mUserEntities = mUserService.findMUserAll();
		logger.info("test 2");
		if (mUserEntities.isEmpty()) {
			return new ResponseEntity<MUserEntity>(HttpStatus.NO_CONTENT);
		}
		
		logger.info("test 3");
		
		MUserDTO data;
		List<MUserDTO> listData = new ArrayList<MUserDTO>();
		
		for (MUserEntity model : mUserEntities) {
			data = new MUserDTO();
			data.setId(model.getId());
			data.setUsername(model.getUsername());
			data.setPassword(model.getPassword());
			data.setAccountExpired(model.getAccountExpired());
			data.setAccountLocked(model.getAccountLocked());
			data.setCredentialExpired(model.getCredentialExpired());
			data.setEnabled(model.getEnabled());
			listData.add(data);
		}
		
		return new ResponseEntity<>(listData,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/userprofiles/", method = RequestMethod.POST, produces= {MediaType.APPLICATION_JSON_VALUE},
			consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> createUserProfiles(@RequestBody MUserDTO mUserDTO, UriComponentsBuilder ucBuilder){
		try {
			MUserEntity mUserEntity = new MUserEntity();
			mUserEntity.setUsername(mUserDTO.getUsername());
			mUserEntity.setPassword(mUserDTO.getPassword());
			mUserEntity.setAccountExpired(mUserDTO.getAccountExpired());
			mUserEntity.setAccountLocked(mUserDTO.getAccountLocked());
			mUserEntity.setCredentialExpired(mUserDTO.getCredentialExpired());
			mUserEntity.setEnabled(mUserDTO.getEnabled());
			
			mUserService.saveMUser(mUserEntity);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(mUserEntity.getId()).toUri());
			
			return new ResponseEntity<>(headers, HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUserProfiles(@PathVariable("id") int id, @RequestBody MUserDTO mUserDTO){
		logger.info("Updating userProfiles with id {}",id);
		
		Optional<MUserEntity> mUser = mUserService.findById(id);
		if (mUser == null || mUser.isPresent()==false) {
			logger.error("Unable to update. UserProfiles with id {} not found",id);
			return new ResponseEntity<>("Unable to update. User with id "+id+" not found", HttpStatus.NOT_FOUND);
		}
		
		MUserEntity mUserEntity = new MUserEntity();
		mUserEntity.setId(mUserDTO.getId());
		mUserEntity.setUsername(mUserDTO.getUsername());
		mUserEntity.setPassword(mUserDTO.getPassword());
		mUserEntity.setAccountExpired(mUserDTO.getAccountExpired());
		mUserEntity.setAccountLocked(mUserDTO.getAccountLocked());
		mUserEntity.setCredentialExpired(mUserDTO.getCredentialExpired());
		mUserEntity.setEnabled(mUserDTO.getEnabled());
		
		mUserService.saveMUser(mUserEntity);
		
		return new ResponseEntity<>(mUser, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUserProfilesById(@PathVariable("id") int id){
		logger.info("Fetching & Deleting UserProfiles with id {}", id);
		
		Optional<MUserEntity> mUserEntity = mUserService.findById(id);
		if (mUserEntity == null || mUserEntity.isPresent()==false) {
			logger.error("Unable to update. UserProfiles with id {} not found",id);
			return new ResponseEntity<>("Unable to update. User with id "+id+" not found", HttpStatus.NOT_FOUND);
		}
		
		mUserService.deleteMUserById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public ResponseEntity<MUserEntity> deleteUserProfiles(){
		logger.info("Deleting All UserProfiles");
		
		mUserService.deleteMUserAll();
		
		return new ResponseEntity<MUserEntity>(HttpStatus.NO_CONTENT);
	}
}
