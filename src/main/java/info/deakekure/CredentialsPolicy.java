package info.deakekure;

/**
 * 
 * 
 * @author zakyalvan
 */
public interface CredentialsPolicy {
	boolean alwaysGenerateOnRegistration();
	String defaultPasswordGeneratorType();
}
