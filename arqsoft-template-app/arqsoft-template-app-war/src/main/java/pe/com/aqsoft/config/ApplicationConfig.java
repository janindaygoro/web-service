package pe.com.aqsoft.config;
/**
 * Clase ApplicationConfig.
 *
 * @author Alex Camacho
 * @version 1.0
 */


import javax.sql.DataSource;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

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
    public JndiObjectFactoryBean dataSource() throws IllegalArgumentException {
        JndiObjectFactoryBean dataSource = new JndiObjectFactoryBean();
        dataSource.setExpectedType(DataSource.class);
        dataSource.setJndiName("jdbc/jndiDataSource");
        System.out.println("=========Base de datos conectada=============  "+dataSource.getJndiName());
        return dataSource;
    }
    
    @Bean(name ="dbDataSource")
	public DataSource fnDataSource() {
		Context objContext;
		DataSource objDatasource = null;
		try {
			objContext = new InitialContext();
//			objDatasource = (DataSource) objContext.lookup("java:comp/env/jdbc/ds_oracle_fn_db");
			objDatasource = (DataSource) objContext.lookup("java:comp/env/jdbc/jndiDataSource");
			
			System.out.println("-----> " + objDatasource.getConnection().isClosed());
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(" --- "+e.getMessage());
			e.printStackTrace();
		}
		return objDatasource;
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

