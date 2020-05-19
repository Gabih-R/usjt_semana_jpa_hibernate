package br.usjt.usjt_semana_jpa_hibernate;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.usjt.usjt_semana_jpa_hibernate.interceptor.LoginInterceptor;

@Configuration
public class AppConfig implements WebMvcConfigurer{
	public void addInterceptors(InterceptorRegistry registry) {
		((Object) registry.addInterceptor(new LoginInterceptor()))
		.addPathPatterns("/**")
		.excludePathPatterns("/login","/","/logar");
	}
}