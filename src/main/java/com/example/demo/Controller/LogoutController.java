/**
 * 
 */
package com.example.demo.Controller;

import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FIKRI-PC
 *
 */
/*@RestController*/
public class LogoutController {
	
	/*Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AuthorizationServerTokenServices authorizationServerTokenServices;
	
	@Autowired
    private TokenStore tokenStore;
	
	@Autowired
	private ConsumerTokenServices consumerTokenServices;
	
	@RequestMapping(value = "/oauth/revoke-token", method = RequestMethod.GET)
    public ResponseEntity<?> logout(Principal principal, HttpServletRequest request) {
		logger.info("masjk log");
        String authHeader = request.getHeader("Authorization");
        logger.info("tkone: {}",authHeader);
        if (authHeader != null) {
            String tokenValue = authHeader.replace("Bearer", "").trim();
            logger.info("tkone2: {}",tokenValue);
            OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
            OAuth2AccessToken accessToken = authorizationServerTokenServices.getAccessToken(oAuth2Authentication);
            consumerTokenServices.revokeToken(accessToken.getValue());
            
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
            tokenStore.removeAccessToken(accessToken);
            consumerTokenServices.revokeToken(tokenValue);
            return new ResponseEntity<>("Success Logout",HttpStatus.OK);
        } else {
        	return new ResponseEntity<>("Error logout",HttpStatus.OK);
        }
    }
	
	@GetMapping(value="/signin")
	public ResponseEntity<?> signinLogout(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			HttpServletRequest request, Locale locale){
		logger.info("logout22");
		if (error != null) {
			logger.info("failed login");
		}

		if (logout != null) {
			logger.info("logged out successfully");
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}*/

}
