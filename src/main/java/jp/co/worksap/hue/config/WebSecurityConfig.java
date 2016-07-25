package jp.co.worksap.hue.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jp.co.worksap.hue.system.AuthenticationProviderImpl;
import jp.co.worksap.hue.system.WapUserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AuthenticationProviderImpl authenticationProvider;
	@Autowired
	private WapUserDetailServiceImpl userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/login", "/account", "/apps/css/**", "/apps/js/**", "/apps/fonts/**", "/partials/**")
				.permitAll()
				.antMatchers(HttpMethod.POST, "/account").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/home")
				.failureUrl("/login?error")
				.usernameParameter("userId")
				.permitAll()
				.and()
			.rememberMe()
				.tokenValiditySeconds(86400)			// 1ヶ月間
				.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID", "remember-me")
				.invalidateHttpSession(true)
				.permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
	        .authenticationProvider(authenticationProvider)
	        .userDetailsService(userDetailsService);
	}
}
