package jp.co.worksap.hue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CiDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiDashboardApplication.class, args);
	}
}
