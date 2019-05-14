/**
 * 
 */
package com.devs4j.mvc.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.devs4j.mvc.interceptors.PostInterceptor;

/**
 * By default HandlerInterceptors apply to all the @Controllers
 * 
 * @author raidentrance
 *
 */
@Configuration
public class Devs4jConfiguration implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(postInterceptor()).addPathPatterns("/posts*");
		registry.addInterceptor(localeChangeInterceptor());
	}

	/**
	 * Local resolver by using a session
	 * 
	 * @return
	 */
	// @Bean
	public LocaleResolver localeResolverBySession() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("en"));
		return localeResolver;
	}

	/**
	 * Local resolver by using a cookie
	 * 
	 * @return
	 */
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setCookieName("language");
		localeResolver.setCookieMaxAge(3600);
		localeResolver.setDefaultLocale(new Locale("en"));
		return localeResolver;
	}

	/**
	 * Load the corresponding message sources based on the current locale from
	 * the i18n folder
	 * 
	 * @return
	 */
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messages = new ResourceBundleMessageSource();
		messages.setBasename("i18n/messages");
		return messages;
	}

	/**
	 * Allows to change the locale based on a parameter named language
	 * 
	 * @return
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("language");
		return interceptor;
	}

	@Bean
	public PostInterceptor postInterceptor() {
		return new PostInterceptor();
	}
}
