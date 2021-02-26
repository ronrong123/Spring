package com.company.yedam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.company.yedam.di.SamsungTV;
import com.company.yedam.di.SonySpeaker;
import com.company.yedam.di.Speaker;
import com.company.yedam.di.TV;

//@Configuration
public class AppConfig {
	@Bean
	public Speaker speaker() {
		return new SonySpeaker();
	}
	@Bean
	@Scope("prototype")
	public TV tvSvc() {
		SamsungTV tv = new SamsungTV();
		tv.setSpeaker(speaker());
		return tv;
	}
}
