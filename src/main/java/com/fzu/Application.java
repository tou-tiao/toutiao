package com.fzu;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.util.List;

@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

	// 指定fastjson传输, 在 controller 层使用 @ResponseBody 时会将数据解析为json 写入响应(Response)
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

		super.configureMessageConverters(converters);
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(
				SerializerFeature.PrettyFormat
		);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		converters.add(fastConverter);
	}
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
	}
}
