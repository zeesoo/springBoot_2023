package board.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import board.interceptor.LoggerInterceptor;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{
	
	// Interceptor 이동 여부 체크
	// Interceptor 생성
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(new LoggerInterceptor())
		//.addPathPatterns("/**");	// Interceptor 적용 대상
		.excludePathPatterns("/error", "/index.html");	// Interceptor 적용 제외 대상
	}
}