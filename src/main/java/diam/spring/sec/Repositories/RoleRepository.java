package diam.spring.sec.Repositories;

import diam.spring.sec.Entities.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<UserRoles, Long> {
    UserRoles findUserRolesByName(String roleName);
}
