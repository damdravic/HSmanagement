package ddv.com.hcmanagement.service.impl;

import ddv.com.hcmanagement.repository.RoleRepository;
import ddv.com.hcmanagement.repository.UserRepository;
import ddv.com.hcmanagement.security.User;
import ddv.com.hcmanagement.security.UserRole;
import ddv.com.hcmanagement.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Transactional
    public User createUser(User user, Set<UserRole> userRole) {
      User localUser = userRepository.findByUsername(user.getUsername());

      if(localUser != null){
          LOG.info("User Exist");
      }else{
          for(UserRole ur :userRole){
              roleRepository.save(ur.getRole());
          }
          user.getUserRoles().addAll(userRole);
          localUser = userRepository.save(user);
      }
      return localUser;
    }
}
