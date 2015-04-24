package info.deakekure;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Sample {@link CredentialsPolicy} which read data from properties.file (Using
 * Spring's {@link PropertySource}).
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
	private String passwordGeneratorType;
	
	@Override
	public boolean alwaysGenerateOnRegistration() {
		return alwaysGenerateOnRegistration;
	}

	@Override
	public String defaultPasswordGeneratorType() {
		return passwordGeneratorType;
	}
}
