package pe.com.aqsoft.config;
/**
 * Clase WebAppMvcConfig.
 *
 * @author Alex Camacho
 * @version 1.0
 */
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebAppMvcConfig extends WebMvcConfigurerAdapter{
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> lstconverters) {
		Jackson2ObjectMapperBuilder objBuilder = new Jackson2ObjectMapperBuilder();
		objBuilder.indentOutput(true);
		lstconverters.add(new MappingJackson2HttpMessageConverter(objBuilder.build()));

	}
}
