package br.mackenzie.ProejtoN2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.mackenzie.ProjetoN2"})
public class ProejtoN2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProejtoN2Application.class, args);
	}

}
