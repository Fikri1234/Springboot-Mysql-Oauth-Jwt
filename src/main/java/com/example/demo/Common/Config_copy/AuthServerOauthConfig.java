/**
 * 
 */
package com.example.demo.Common.Config_copy;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

/**
 * @author FIKRI-PC
 *
 */
/*@Configuration
@EnableAuthorizationServer
@EnableGlobalMethodSecurity(prePostEnabled=true)
@Import(WebSecurityConfig.class)*/
public class AuthServerOauthConfig /*extends AuthorizationServerConfigurerAdapter*/ {
	
	/*@Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder oauthClientPasswordEncoder;

    @Bean
    public TokenStore tokenStore() {
    	return new JwtTokenStore(accessTokenConverter());
    }
    
    // Token converter to JWT
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
    	JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    	converter.setSigningKey("abc");
    	return converter;
    }
    
    @Bean
    @Primary
    public DefaultTokenServices tokenService() {
    	DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
    	defaultTokenServices.setTokenStore(tokenStore());
    	defaultTokenServices.setSupportRefreshToken(true);
    	defaultTokenServices.setTokenEnhancer(accessTokenConverter());
    	defaultTokenServices.setAccessTokenValiditySeconds(3600);
    	return defaultTokenServices;
    }
    // -----------------------------

    @Bean
    public OAuth2AccessDeniedHandler oauthAccessDeniedHandler() {
        return new OAuth2AccessDeniedHandler();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").passwordEncoder(oauthClientPasswordEncoder);
    }

    //configure your token
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore());
        endpoints.tokenServices(tokenService());
        endpoints.authenticationManager(authenticationManager);
        endpoints.userDetailsService(userDetailsService);
    }*/

}
