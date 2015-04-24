package info.deakekure;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MainConfiguration.class)
public class DefaultRegistrationServiceTest {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void testVerifyPasswordNewRegisteredUser() throws Exception {
		RegistrationService registrationService = new DefaultRegistrationService();
		
		User user = new User("Zaky Alvan", "zakyalvan", "password");
		User registeredUser = registrationService.register(user);
		boolean matches = passwordEncoder.matches("dumbpassword", registeredUser.getPassword());
		assertThat(matches, is(true));
	}
}
