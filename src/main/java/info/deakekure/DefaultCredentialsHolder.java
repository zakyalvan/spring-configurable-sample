package info.deakekure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Default implementation of {@link CredentialsHolder} sample strategy. This
 * bean type annotated with {@link Configurable} so that it can be created using
 * "new" operator and then allow spring to take control and configure further.
 * For example populate {@link Value @Value} or {@link Autowired @Autowired}.
 * 
 * @author zakyalvan
 */
@Component
@Configurable
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DefaultCredentialsHolder implements CredentialsHolder {
	@Value("${credentials.username}")
	private String username;
	
	@Value("${credentials.password}")
	private String password;
	
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "FromPropertiesCredendialsHolder [username=" + username
				+ ", password=" + password + "]";
	}
}
