package info.deakekure;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Just a simple implementations of {@link PasswordGenerator}. Always return
 * same static string every password generation.
 * 
 * @author zakyalvan
 */
@Component
@Configurable
@Scope("prototype")
public class DumbPasswordGenerator implements PasswordGenerator {
	@Override
	public String generate() {
		return "dumbpassword";
	}
}
