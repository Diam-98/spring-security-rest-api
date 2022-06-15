package diam.spring.sec.Controller;

import diam.spring.sec.Entities.User;
import diam.spring.sec.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class SecurityRestController {
    private final UserService userService;

    public SecurityRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public List<User> users(){
        return userService.users();
    }

}
