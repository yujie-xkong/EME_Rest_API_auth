package com.example.eme_oauth_frontend.security;

import com.example.eme_oauth_frontend.endpoint.AjaxAwareAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.filter.CompositeFilter;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;



@Configuration
@EnableOAuth2Client
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final OAuth2ClientContext oauth2ClientContext;

    private final SecurityAuthSuccessHandler mAuthSuccessHandler;

    private final PrincipalExtractor mPrincipalExtractor;

    private final AuthoritiesExtractor mAuthoritiesExtractor;


    @Autowired
    public WebSecurityConfig(@Qualifier("oauth2ClientContext") OAuth2ClientContext oauth2ClientContext,
                             SecurityAuthSuccessHandler authSuccessHandler, PrincipalExtractor principalExtractor,
                             AuthoritiesExtractor authoritiesExtractor) {
        this.oauth2ClientContext = oauth2ClientContext;
        mAuthSuccessHandler = authSuccessHandler;
        mPrincipalExtractor = principalExtractor;
        mAuthoritiesExtractor = authoritiesExtractor;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable();
             /*   .authorizeRequests()
                .antMatchers("/eme/dashboard","/Access_Denied","/static/eme")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler(myClient()))
                .accessDeniedPage("/Access_Denied")
                .and().addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class)
                .logout().logoutSuccessHandler((new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK)))
                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());*/
    }

    @Bean
    @ConfigurationProperties("my-client")
    public ClientResources myClient() {
        return new ClientResources();
    }

    private Filter ssoFilter(ClientResources client) {
        OAuth2ClientAuthenticationProcessingFilter filter = new OAuth2ClientAuthenticationProcessingFilter(client.getClient().getUserAuthorizationUri());
        OAuth2RestTemplate template = new OAuth2RestTemplate(client.getClient(), oauth2ClientContext);
        filter.setRestTemplate(template);
        UserInfoTokenServices tokenServices = new UserInfoTokenServices(client.getResource().getUserInfoUri(),
                client.getClient().getClientId());
        tokenServices.setRestTemplate(template);
        tokenServices.setPrincipalExtractor(mPrincipalExtractor);
        tokenServices.setAuthoritiesExtractor(mAuthoritiesExtractor);
        filter.setTokenServices(tokenServices);
        filter.setAuthenticationSuccessHandler(mAuthSuccessHandler);
        return (Filter) filter;
    }

    private Filter ssoFilter() {
        CompositeFilter filter = new CompositeFilter();
        List<Filter> filters = new ArrayList<>();
        filters.add(ssoFilter(myClient()));
        filter.setFilters(filters);
        return (Filter) filter;
    }
    @Bean
    public AjaxAwareAuthenticationEntryPoint unauthorizedHandler(ClientResources myClient) {
        return new AjaxAwareAuthenticationEntryPoint(myClient.getClient().getUserAuthorizationUri());
    }
}
