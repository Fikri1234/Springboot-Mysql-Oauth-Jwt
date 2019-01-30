package com.example.demo.DAOImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.demo.DAO.MUserDAO;
import com.example.demo.DTO.OauthResponse;
import com.example.demo.Entity.MUserEntity;



@Service
public class AccountDAOImpl implements UserDetailsService {
	
	public static final Logger logger = LoggerFactory.getLogger(AccountDAOImpl.class);
	
	@Autowired
	MUserDAO mUserDAO;

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("username: {}",username);
		Optional<MUserEntity>  user = mUserDAO.findByUsername(username);
		logger.info("user: {} pass: {} ", user.get().getUsername(), user.get().getPassword());
	
		user.
			orElseThrow(() -> new UsernameNotFoundException("username not found"));
		
		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
		logger.info("auth: {}",authorities.toArray().toString());
		return new User (user.get().getUsername(), user.get().getPassword(), authorities);
	}
	
	public String getWsAccessToken(){
		/*String oautUrl = mstRepo.findOneByParamName("OAUTH_TOKEN_URL").getParamValue();
		String oautClientSec = mstRepo.findOneByParamName("OAUTH_CREDENTIALS").getParamValue();
		String oautClientId = mstRepo.findOneByParamName("OAUTH_CLIENT_ID").getParamValue();
		String oautUsername = mstRepo.findOneByParamName("OAUTH_USERNAME").getParamValue();
		String oautPassword = mstRepo.findOneByParamName("OAUTH_PASSWORD").getParamValue();
		String oautGrant = mstRepo.findOneByParamName("OAUTH_GRANT").getParamValue();
		logger.debug("Fikri Url : "+oautUrl+" client : "+oautClientSec+" client id : "+oautClientId);
		logger.debug("fikri user "+oautUsername+" pass: "+oautPassword+" gr: "+oautGrant);*/
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("username", "fikriuser");
		map.add("password", "fikripass");
		map.add("client_id", "fikri-client-id");
		map.add("grant_type", "password");
		//map.add("client_secret", oautClientSec);
		//logger.debug("user: {} pass: {} clientId: {} grantType: {} clientSecret: {}",oautUsername,oautPassword,oautClientId,oautGrant,oautClientSec);
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		logger.debug("req: {}",request.toString());
		ResponseEntity<OauthResponse> response = restTemplate.postForEntity("http://localhost:8060/oauth/token", request, OauthResponse.class);
		logger.debug("resp: {} bodi: {}",response.getClass().getName(), response.getBody().toString());
		OauthResponse resp = response.getBody();
		
//		httpSession.setAttribute(IConstants.ACCESS_TOKEN, resp.getAccess_token());
		logger.info("resp token: "+resp.getAccess_token()+" str "+resp.toString());
		logger.info("resp token type: "+resp.getToken_type()+" exp "+resp.getExpires_in());
		return resp.getAccess_token();
	}

}
