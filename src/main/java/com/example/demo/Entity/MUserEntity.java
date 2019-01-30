package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_user", schema = "ms_account_dev")
public class MUserEntity {
	
	private int id;
	private String username;
	private String password;
	private boolean accountExpired;
	private boolean accountLocked;
	private boolean credentialExpired;
	private boolean enabled;
	
	@Id
	@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "user_name")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "account_expired")
	public boolean getAccountExpired() {
		return accountExpired;
	}
	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}
	
	@Column(name = "account_locked")
	public boolean getAccountLocked() {
		return accountLocked;
	}
	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}
	
	@Column(name = "credential_expired")
	public boolean getCredentialExpired() {
		return credentialExpired;
	}
	public void setCredentialExpired(boolean credentialExpired) {
		this.credentialExpired = credentialExpired;
	}
	
	@Column(name = "enabled")
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (accountExpired ? 1231 : 1237);
		result = prime * result + (accountLocked ? 1231 : 1237);
		result = prime * result + (credentialExpired ? 1231 : 1237);
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MUserEntity other = (MUserEntity) obj;
		if (accountExpired != other.accountExpired)
			return false;
		if (accountLocked != other.accountLocked)
			return false;
		if (credentialExpired != other.credentialExpired)
			return false;
		if (enabled != other.enabled)
			return false;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "MUserEntity [id=" + id + ", username=" + username + ", password=" + password + ", accountExpired="
				+ accountExpired + ", accountLocked=" + accountLocked + ", credentialExpired=" + credentialExpired
				+ ", enabled=" + enabled + "]";
	}
}
