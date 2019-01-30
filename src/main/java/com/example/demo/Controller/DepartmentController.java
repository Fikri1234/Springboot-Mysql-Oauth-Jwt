package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.DepartmentDTO;
import com.example.demo.Entity.DepartmentEntity;
import com.example.demo.Service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	public static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	Environment environment;
	
	@Autowired
	DepartmentService departmentService;
	
//  --------------- retreave single data ------------------
	@GetMapping("/{id}")
	public ResponseEntity<DepartmentDTO> retrieveDepartment(@PathVariable("id") int id) {
		
		logger.info("test id 1");
		Optional<DepartmentEntity> departmentEntity = departmentService.findById(id);
		logger.info("tets id 2");
		
		if (departmentEntity.isPresent()) {
			DepartmentDTO departmentDTO = new DepartmentDTO(departmentEntity.get().getId(), departmentEntity.get().getName(), departmentEntity.get().getWorkstationId());
			return new ResponseEntity<DepartmentDTO> (departmentDTO, HttpStatus.OK);
		}else {
			logger.error("id not found: ",id);
			return new ResponseEntity<DepartmentDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	// ---------------- retrieve all data ----------------------
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> getAllDepartment(){
		logger.info("test 1");
		List<DepartmentEntity> departmentEntities = departmentService.findDepartmentAll();
		logger.info("test 2");
		if (departmentEntities.isEmpty()) {
			return new ResponseEntity<DepartmentEntity>(HttpStatus.NO_CONTENT);
		}
		
		logger.info("test 3");
		
		DepartmentDTO data;
		List<DepartmentDTO> listData = new ArrayList<DepartmentDTO>();
		
		for (DepartmentEntity model : departmentEntities) {
			data = new DepartmentDTO();
			data.setId(model.getId());
			data.setName(model.getName());
			data.setWorkstationId(model.getWorkstationId());
			listData.add(data);
		}
		
		return new ResponseEntity<>(listData,HttpStatus.OK);
	}

}
