package com.example.demo.Configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
@EnableGlobalMethodSecurity(prePostEnabled=true)
@Import(SecurityConfig.class)
public class AuthServerOAuthConfig extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
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
        //return new JdbcTokenStore(dataSource);
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
    	defaultTokenServices.setAccessTokenValiditySeconds(300);
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
        /*clients.inMemory()
        .withClient("javadeveloperzone")
        .secret("secret")
        .accessTokenValiditySeconds(2000)        // expire time for access token
        .refreshTokenValiditySeconds(-1)         // expire time for refresh token
        .scopes("read", "write")                         // scope related to resource server
        .authorizedGrantTypes("password", "refresh_token");      // grant type
*/    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore());
        endpoints.tokenServices(tokenService());
        endpoints.authenticationManager(authenticationManager);
        endpoints.userDetailsService(userDetailsService);
    }

}
