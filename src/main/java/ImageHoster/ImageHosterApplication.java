package ImageHoster;

import ImageHoster.validators.PasswordValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ImageHosterApplication {
    @Bean
    public PasswordValidator validator() {
        return new PasswordValidator();
    }
    public static void main(String[] args) {
        SpringApplication.run(ImageHosterApplication.class, args);

    }
}
