package jp.co.worksap.hue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAutoConfiguration
@PropertySource("classpath:/app-config.properties")
public class CiDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiDashboardApplication.class, args);
	}
}
