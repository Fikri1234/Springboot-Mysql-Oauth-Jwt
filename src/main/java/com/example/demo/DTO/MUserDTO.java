package com.example.demo.DTO;

public class MUserDTO {
	
	private int id;
	private String username;
	private String password;
	private boolean accountExpired;
	private boolean accountLocked;
	private boolean credentialExpired;
	private boolean enabled;
	
	public MUserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MUserDTO(int id, String username, String password, boolean accountExpired, boolean accountLocked,
			boolean credentialExpired, boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.accountExpired = accountExpired;
		this.accountLocked = accountLocked;
		this.credentialExpired = credentialExpired;
		this.enabled = enabled;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getAccountExpired() {
		return accountExpired;
	}
	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}
	public boolean getAccountLocked() {
		return accountLocked;
	}
	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}
	public boolean getCredentialExpired() {
		return credentialExpired;
	}
	public void setCredentialExpired(boolean credentialExpired) {
		this.credentialExpired = credentialExpired;
	}
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
