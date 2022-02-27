package co.com.pts;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("co.com.pts.mappers")
@SpringBootApplication
public class PtsBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PtsBackApplication.class, args);
	}
	
	

}
