package info.deakekure;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsEqual.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MainConfiguration.class)
public class DefaultCredentialsHolderTest {
	@Value("${credentials.username}")
	private String username;
	
	@Value("${credentials.password}")
	private String password;
	
	@Test
	public void testInstantiateUsingNewOperator() {
		CredentialsHolder holder = new DefaultCredentialsHolder();
		assertThat(holder.getUsername(), is(equalTo(username)));
		assertThat(holder.getPassword(), is(equalTo(password)));
	}
}
