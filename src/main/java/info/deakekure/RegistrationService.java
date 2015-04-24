package info.deakekure;

import org.springframework.stereotype.Service;

/**
 * Contract of {@link Service} compenent for registering user.
 * 
 * @author zakyalvan
 */
public interface RegistrationService {
	/**
	 * Register user.
	 * 
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	User register(User user) throws Exception;
}
