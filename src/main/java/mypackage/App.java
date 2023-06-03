package mypackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import mypackage.services.fileuploading.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		
		SpringApplication.run(App.class, args);
		
	}

}
