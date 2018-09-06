package pe.com.aqsoft.config;
/**
 * Clase ApplicationInitializer.
 *
 * @author Alex Camacho
 * @version 1.0
 */
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext objDispatcherContext = new AnnotationConfigWebApplicationContext();
		objDispatcherContext.register(ApplicationConfig.class);
		System.out.println("---------------------Iniciando------------------------------");
		objDispatcherContext.setServletContext(servletContext);
		ServletRegistration.Dynamic objDispatcher = servletContext.addServlet("dispatcher",
				new DispatcherServlet(objDispatcherContext));
		objDispatcher.addMapping("/"); 
		objDispatcher.setLoadOnStartup(1);

	}

}
