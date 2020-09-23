package ddv.com.hcmanagement;

import ddv.com.hcmanagement.config.SecurityUtility;
import ddv.com.hcmanagement.security.Role;
import ddv.com.hcmanagement.security.User;
import ddv.com.hcmanagement.security.UserRole;
import ddv.com.hcmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableJdbcHttpSession
public class HcmanagementApplication implements CommandLineRunner {

	@Autowired
	public UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(HcmanagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setUsername("koko");
		user1.setLastName("dragos");
		user1.setEmail("eduedk c");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("3122"));
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setName("Role User");
		userRoles.add(new UserRole(user1,role1));
		userService.createUser(user1,userRoles);
		userRoles.clear();

	}
}
