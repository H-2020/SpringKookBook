package be.intec.SpringCookBook03;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// http://localhost:8080/posts/ -> use this in browser.
// http://localhost:8080/authors/ -> use this in browser.

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Post API", version = "1.0", description = "Post Api Information"))
public class MainView {

	public static void main(String[] args) {
		SpringApplication.run(MainView.class, args);
	}

}


