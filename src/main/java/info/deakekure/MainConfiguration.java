package info.deakekure;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Main configuration of this sample. {@link EnableSpringConfigured} is required
 * before using {@link Configurable}.
 * 
 * @author zakyalvan
 */
@Configuration
@ComponentScan
@EnableSpringConfigured
@PropertySource("classpath:application.properties")
public class MainConfiguration {
	/**
	 * {@link PropertySourcesPlaceholderConfigurer} have to define as static
	 * method so that can be initialized earlier on container startup time.
	 * 
	 * @return
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
