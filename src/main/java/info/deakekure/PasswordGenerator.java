package info.deakekure;

/**
 * Contract password generating strategy type.
 * 
 * @author zakyalvan
 */
public interface PasswordGenerator {
	/**
	 * Generate password.
	 * 
	 * @return
	 */
	String generate();
}
