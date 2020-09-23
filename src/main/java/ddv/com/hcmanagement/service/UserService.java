package ddv.com.hcmanagement.service;

import ddv.com.hcmanagement.security.User;
import ddv.com.hcmanagement.security.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface UserService {

    User createUser(User user, Set<UserRole> userRole);
}
