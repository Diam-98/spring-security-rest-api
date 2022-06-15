package diam.spring.sec.services;

import diam.spring.sec.Entities.User;
import diam.spring.sec.Entities.UserRoles;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User LoadByUsername(String username);
    List<User> users();
    UserRoles addRoles(UserRoles userRoles);
    void addRolesToUser(String username, String roles);
}
