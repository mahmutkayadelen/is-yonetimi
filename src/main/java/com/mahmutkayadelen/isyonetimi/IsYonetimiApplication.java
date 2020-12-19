package com.mahmutkayadelen.isyonetimi;


import org.apache.catalina.servlets.WebdavServlet;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class IsYonetimiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsYonetimiApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
	return new ModelMapper();
}

}
