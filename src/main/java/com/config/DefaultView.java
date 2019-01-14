package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.util.SessionCookieUtil;
import com.util.StringUtil;

@SuppressWarnings("deprecation")
@Configuration
public class DefaultView extends WebMvcConfigurerAdapter {
	@Override
	public void addViewControllers(ViewControllerRegistry registry){
		if (StringUtil.isEmpty(SessionCookieUtil.getUserInfoByToken())) {
			registry.addViewController("/").setViewName("forward:/login/login.html");
			registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
			super.addViewControllers(registry);
		}else{
			registry.addViewController("/").setViewName("forward:/html/index.html");
			registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
			super.addViewControllers(registry);
		}
		

	}

}
