package info.deakekure;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes=MainConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PropertiesFileCredentialsPolicyTest {
	@Test
	public void testVerifyLoadedProperties() {
		CredentialsPolicy credentialsPolicy = new PropertiesFileCredentialsPolicy();
		
		assertThat(credentialsPolicy.defaultPasswordGeneratorType(), 
				is(equalTo("info.deakekure.DumbPasswordGenerator")));
	}
}
