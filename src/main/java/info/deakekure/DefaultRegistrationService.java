package info.deakekure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

/**
 * Please note, create this service using new operator.
 * 
 * @author zakyalvan
 */
@Service
@Configurable
@Scope("prototype")
public class DefaultRegistrationService implements RegistrationService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private PasswordGenerator passwordGenerator;
	
	private CredentialsPolicy credentialsPolicy;
	
	@Override
	public User register(User user) throws Exception {
		if(credentialsPolicy == null) {
			credentialsPolicy = new PropertiesFileCredentialsPolicy();
		}
		
		String password = user.getPassword();
		
		if(credentialsPolicy.alwaysGenerateOnRegistration()) {
			if(passwordGenerator == null) {
				String passwordGeneratorTypeName =
						credentialsPolicy.defaultPasswordGeneratorType();

				@SuppressWarnings("unchecked")
				Class<PasswordGenerator> passwordGeneratorType = (Class<PasswordGenerator>)
						ClassUtils.forName(
								passwordGeneratorTypeName, 
								DefaultRegistrationService.class.getClassLoader());
				
				passwordGenerator = passwordGeneratorType.newInstance();
			}
			password = passwordGenerator.generate();
		}
		
		String encodedPassword = passwordEncoder.encode(password);
		return new User(user.getFullname(), user.getUsername(), encodedPassword);
	}

	public void setCredentialsPolicy(CredentialsPolicy credentialsPolicy) {
		this.credentialsPolicy = credentialsPolicy;
	}

	public void setPasswordGenerator(PasswordGenerator passwordGenerator) {
		this.passwordGenerator = passwordGenerator;
	}
}
