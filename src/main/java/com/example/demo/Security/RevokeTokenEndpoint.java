/**
 * 
 */
package com.example.demo.Security;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author FIKRI-PC
 *
 */

/*@FrameworkEndpoint*/
public class RevokeTokenEndpoint {
	
	/*Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ConsumerTokenServices consumerTokenServices;

    @RequestMapping(method = RequestMethod.DELETE, value = "/oauth/token")
    @ResponseBody
    public void revokeToken(HttpServletRequest request) {
    	logger.info("masuk revoke");
        String authorization = request.getHeader("Authorization");
        logger.info("header auth: {}",authorization);
        if (authorization != null && authorization.contains("Bearer")) {
            String tokenId = authorization.substring("Bearer".length() + 1);
            logger.info("tkone: {}",tokenId);
            consumerTokenServices.revokeToken(tokenId);
        }
    }*/

}
