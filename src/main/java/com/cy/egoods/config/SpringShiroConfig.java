package com.cy.egoods.config;

import java.util.LinkedHashMap;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class SpringShiroConfig {

	@Bean
	public SecurityManager newSecurityManager() {
		DefaultWebSecurityManager sManager = new DefaultWebSecurityManager();
		return sManager;
	}

	@Bean("shiroFilterFactory")
	public ShiroFilterFactoryBean newShiroFilterFactoryBean(@Autowired SecurityManager securityManager) {

		ShiroFilterFactoryBean sfBean = new ShiroFilterFactoryBean();
		sfBean.setSecurityManager(securityManager);
		sfBean.setLoginUrl("/login");
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		// 静态资源允许匿名访问:"anon"
		map.put("/css/**", "anon");
		map.put("/data/**", "anon");
		map.put("/fonts/**", "anon");
		map.put("/img/**", "anon");
		map.put("/js/**", "anon");
		map.put("/plugins/**", "anon");
		map.put("/index1", "anon");
		map.put("/item", "anon");
		map.put("/register.html", "anon");
		map.put("/search", "anon");
		map.put("/shop", "anon");
		map.put("/do*", "anon");
		// 除了匿名访问的资源,其它都要认证("authc")后访问
		map.put("/**", "user");
		sfBean.setFilterChainDefinitionMap(map);
		return sfBean;
	}

	@Bean
	public SecurityManager newSecurityManager(@Autowired Realm realm,@Autowired CacheManager cacheManager) {
		DefaultWebSecurityManager sManager = new DefaultWebSecurityManager();
		sManager.setRealm(realm);
		sManager.setCacheManager(cacheManager);
		//sManager.setRememberMeManager(newRememberMeManager());
		sManager.setSessionManager(newSessionManager());
		return sManager;
	}

	@Bean("lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor newLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

//	@DependsOn("lifecycleBeanPostProcessor")
//	@Bean
//	public DefaultAdvisorAutoProxyCreator newDefaultAdvisorAutoProxyCreator() {
//		return new DefaultAdvisorAutoProxyCreator();
//	}
	
	@Bean
	public AuthorizationAttributeSourceAdvisor 
	newAuthorizationAttributeSourceAdvisor(
				@Autowired SecurityManager securityManager) {
			        AuthorizationAttributeSourceAdvisor advisor=
					new AuthorizationAttributeSourceAdvisor();
			        advisor.setSecurityManager(securityManager);
			return advisor;
	}
	
	//配置缓存对象
	@Bean
	public CacheManager newCacheManager(){
			return new MemoryConstrainedCacheManager();
		 }
	
	//配置cookie对象
//	public CookieRememberMeManager newRememberMeManager() {
//		SimpleCookie c=new SimpleCookie("rememberMe");
//		c.setMaxAge(10*60);
//
//		 CookieRememberMeManager cManager=
//		new CookieRememberMeManager();
//		cManager.setCookie(c);
//		return cManager;
//	 }
	
	public DefaultWebSessionManager newSessionManager() {
		 DefaultWebSessionManager sManager=
				new DefaultWebSessionManager();
		sManager.setGlobalSessionTimeout(60*60*1000);
		return sManager;
	 }





}
