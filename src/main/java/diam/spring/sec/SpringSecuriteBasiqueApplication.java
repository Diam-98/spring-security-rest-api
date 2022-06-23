package diam.spring.sec;

import diam.spring.sec.Entities.User;
import diam.spring.sec.Entities.UserRoles;
import diam.spring.sec.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecuriteBasiqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecuriteBasiqueApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService){
        return args -> {

            userService.addRoles(new UserRoles(null, "ADMIN"));
            userService.addRoles(new UserRoles(null, "PATIENT"));

            userService.addUser(new User(null, "admin", "1234", new ArrayList<>()));
            userService.addUser(new User(null, "patient1", "1234", new ArrayList<>()));
            userService.addUser(new User(null, "patient2", "1234", new ArrayList<>()));
            userService.addUser(new User(null, "patient3", "1234", new ArrayList<>()));

//            userService.addRolesToUser("admin", "ADMIN");
//            userService.addRolesToUser("patient1", "PATIENT");
            userService.addRolesToUser("patient2", "PATIENT");
//            userService.addRolesToUser("patient3", "PATIENT");

        };
    }

}
