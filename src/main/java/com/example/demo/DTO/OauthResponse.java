package com.example.demo.DTO;

public class OauthResponse {

	private String access_token;
	private Integer expires_in;
	private Integer refresh_expires_in;
	private String token_type;
	private String session_state;
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public Integer getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}
	public Integer getRefresh_expires_in() {
		return refresh_expires_in;
	}
	public void setRefresh_expires_in(Integer refresh_expires_in) {
		this.refresh_expires_in = refresh_expires_in;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public String getSession_state() {
		return session_state;
	}
	public void setSession_state(String session_state) {
		this.session_state = session_state;
	}
}
