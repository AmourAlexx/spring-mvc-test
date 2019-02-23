package ua.com.levelup.test.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(WebConfig.class)
public class App {

    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }
}
