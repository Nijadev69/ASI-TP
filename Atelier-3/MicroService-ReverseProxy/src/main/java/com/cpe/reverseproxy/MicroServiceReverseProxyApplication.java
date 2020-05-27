package com.cpe.reverseproxy;

import com.cpe.reverseproxy.filters.pre.ProxyFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class MicroServiceReverseProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceReverseProxyApplication.class, args);
	}

	@Bean
	public ProxyFilter simpleFilter() {
		return new ProxyFilter();
	}

}
