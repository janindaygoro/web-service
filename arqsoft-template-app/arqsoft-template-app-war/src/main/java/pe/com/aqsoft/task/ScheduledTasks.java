package pe.com.aqsoft.task;
/**
 * Clase ScheduledTasks.
 *
 * @author Alex Camacho
 * @version 1.0
 */
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
//@EnableScheduling
public class ScheduledTasks {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private ApplicationContext applicationContext;

	@Value("${properties.prueba}")
	private String strPrueba;

	@Autowired
	private Environment env;

	private Logger logger = Logger.getLogger(ScheduledTasks.class);

	@Scheduled(fixedRate = 500000)
	public void reportCurrentTime() {
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			logger.error("beanName  --> " + applicationContext.getBean(beanName).getClass().toString());
		}
		logger.info("La hora es --->" + dateFormat.format(new Date()) + " - " + strPrueba + " + "
				+ env.getRequiredProperty("properties.prueba"));

	}
}
