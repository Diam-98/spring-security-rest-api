package diam.spring.sec.services;

import diam.spring.sec.Entities.User;
import diam.spring.sec.Entities.UserRoles;
import diam.spring.sec.Repositories.RoleRepository;
import diam.spring.sec.Repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Bean
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User addUser(User user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder().encode(password));
        return userRepository.save(user);
    }

    @Override
    public User LoadByUsername(String username) {
        return userRepository.findUserByUserName(username);
    }

    @Override
    public List<User> users() {
        return userRepository.findAll();
    }

    @Override
    public UserRoles addRoles(UserRoles userRoles) {
        return roleRepository.save(userRoles);
    }

    @Override
    public void addRolesToUser(String username, String roles) {
        User user = userRepository.findUserByUserName(username);
        UserRoles userRoles = roleRepository.findUserRolesByName(roles);
        user.getRole().add(userRoles);
    }
}
