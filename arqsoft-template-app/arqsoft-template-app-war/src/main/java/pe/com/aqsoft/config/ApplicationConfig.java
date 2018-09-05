package pe.com.aqsoft.config;
/**
 * Clase ApplicationConfig.
 *
 * @author Alex Camacho
 * @version 1.0
 */


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@ComponentScan(basePackages = "pe.com.aqsoft.*")
@PropertySource(value = { "classpath:application.properties" })
//@PropertySource({ "classpath:com/javaetmoi/sample/config/datasource.properties" })
public class ApplicationConfig {
	
	
//	public static void main(String[] args) {
//		SpringApplication.run(ApplicationConfig.class, args);
//    }
	
	@Autowired
    private Environment env;

    @Bean
    @Profile("javaee")
    public JndiObjectFactoryBean dataSource() throws IllegalArgumentException {
        JndiObjectFactoryBean dataSource = new JndiObjectFactoryBean();
        dataSource.setExpectedType(DataSource.class);
        dataSource.setJndiName(env.getProperty("jdbc.jndiDataSource"));
        System.out.println("=========Base de datos conectada=============");
        return dataSource;
    }

    @Bean
    @Profile("test")
    public DataSource testDataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	
	
//	private DataSource dataSource;
//	 
//    public ApplicationConfig() {
//        try {
// 
//            InitialContext context = new InitialContext();
////            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jelasticDb");
//            dataSource = (DataSource) context.lookup("jdbc/ventas");
// System.out.println("=========Base de datos conectada=============");
//        } catch (NamingException ex) {
//            Logger.getLogger(ApplicationConfig.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
// 
//    public Connection getConnection() {
//        Connection conn = null;
//        try {
//            conn = dataSource.getConnection();
//        } catch (SQLException ex) {
//            Logger.getLogger(ApplicationConfig.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return conn;
//    }

}

