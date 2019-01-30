/**
 * 
 */
package com.example.demo.Common.Config_copy;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

/**
 * @author FIKRI-PC
 *
 */

/*@Configuration
@EnableResourceServer*/
public class ResourceServerConfig /*extends ResourceServerConfigurerAdapter*/ {
	
	/*private static final String RESOURCE_ID = "resource-server-rest-api";
    private static final String SECURED_READ_SCOPE = "#oauth2.hasScope('read')";
    private static final String SECURED_WRITE_SCOPE = "#oauth2.hasScope('write')";
    private static final String SECURED_PATTERN = "/**";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
    }
    
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity
			.authorizeRequests()
				.antMatchers("/", "/resources/**", "/logout", "/oauth/token").permitAll()
				.antMatchers(HttpMethod.POST, SECURED_PATTERN).access(SECURED_WRITE_SCOPE)
				.antMatchers(HttpMethod.PUT, SECURED_PATTERN).access(SECURED_WRITE_SCOPE)
				.antMatchers(HttpMethod.DELETE, SECURED_PATTERN).access(SECURED_WRITE_SCOPE)
                .anyRequest().access(SECURED_READ_SCOPE)
				.and()
			.logout()
				.logoutUrl("/logout")
	            .permitAll()
	            .logoutSuccessUrl("/logout")
	            .and();
	}*/

}
