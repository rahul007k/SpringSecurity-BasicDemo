package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.demo.Repo.UserRepository;
import com.example.demo.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private UserRepository repository;

	@Autowired
	private TestEntityManager entityManager;

	/*
	 * @Test public void testCreateUser() { User user = new User();
	 * user.setEmail("durgavaranasi07@gmail.com"); user.setFirstName("Durga");
	 * user.setLastName("Varanasi"); user.setPassword("durga@143");
	 * 
	 * User saveduser = repository.save(user); User existuser =
	 * entityManager.find(User.class, saveduser.getId());
	 * 
	 * assertThat(existuser.getEmail()).isEqualTo(user.getEmail()); }
	 */

	@Test
	public void testFindUserByEmail() {
		String email = "abcxyz@gmail.com";
		User user = repository.findByEmail(email);
		assertThat(user).isNotNull();

	}

}
