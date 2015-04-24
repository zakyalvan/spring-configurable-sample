package info.deakekure;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Sample {@link CredentialsPolicy} implementation which read policy items from
 * properties.file (In conjunction with Spring's {@link PropertySource}).
 * 
 * @author zakyalvan
 */
@Component
@Configurable
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PropertiesFileCredentialsPolicy implements CredentialsPolicy {
	@Value("${info.deakekure.credential.alwaysGenerateOnRegistration}")
	private boolean alwaysGenerateOnRegistration;
	
	@Value("${info.deakekure.credential.defaultPasswordGeneratorName}")
	private Class<PasswordGenerator> passwordGeneratorType;
	
	@Override
	public boolean alwaysGenerateOnRegistration() {
		return alwaysGenerateOnRegistration;
	}

	@Override
	public Class<PasswordGenerator> defaultPasswordGeneratorType() {
		return passwordGeneratorType;
	}
}
