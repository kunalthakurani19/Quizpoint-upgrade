package com.exam;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Project Running");
//		User user = new User();
//		user.setFirstName("Kunal");
//		user.setLastName("Thakurani");
//		user.setEmail("kunal.thakurani2001@gmail.com");
//		user.setPassword(this.bCryptPasswordEncoder.encode("123"));
//		user.setUsername("kunal@123");
//		user.setPhone("7999910495");
//		user.setProfile("default.png");
//
//		Role role = new Role();
//		role.setRoleId(1);
//		role.setRoleName("ADMIN");
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//
//		UserRole userRole = new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//
//		userRoleSet.add(userRole);
//		User user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1);
	}
}
