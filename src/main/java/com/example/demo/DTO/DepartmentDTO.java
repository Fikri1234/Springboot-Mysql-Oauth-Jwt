package com.example.demo.DTO;

public class DepartmentDTO {
	
	private int id;
	private String name;
	private int workstationId;
	
	public DepartmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DepartmentDTO(int id, String name, int workstationId) {
		super();
		this.id = id;
		this.name = name;
		this.workstationId = workstationId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWorkstationId() {
		return workstationId;
	}
	public void setWorkstationId(int workstationId) {
		this.workstationId = workstationId;
	}

}
