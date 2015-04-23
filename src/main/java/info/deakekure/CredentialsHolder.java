package info.deakekure;

/**
 * Sample of strategy contract. On this type, object could hold credentials
 * information and could be retrieved using provided method. Not so real example indeed.
 * 
 * @author zakyalvan
 */
public interface CredentialsHolder {
	/**
	 * Get username.
	 * 
	 * @return
	 */
	String getUsername();
	
	/**
	 * Get password.
	 * 
	 * @return
	 */
	String getPassword();
}
