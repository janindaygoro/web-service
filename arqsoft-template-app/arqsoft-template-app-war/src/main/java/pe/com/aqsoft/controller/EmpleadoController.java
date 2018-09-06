package pe.com.aqsoft.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.com.aqsoft.model.Empleado;

@RestController
public class EmpleadoController {
//	ProductoMapper maper;
	
	@Autowired
	@Qualifier("dbDataSource")
	private DataSource dataSource;
	
	@RequestMapping(value = "/listarEmpleados", method = RequestMethod.GET)
	public List<Empleado> listEmp() {
		System.out.println("Ejecuto");
		List<Empleado> lst = new ArrayList<Empleado>();
		Empleado emp1 = new Empleado(1, "Pancracio 1");
		Empleado emp2 = new Empleado(1, "Pancracio 2");
		lst.add(emp1);
		lst.add(emp2);
		String query = "select * from producto";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);
		System.out.println(empRows.size());

		return lst;
	}
	
//	@RequestMapping(value = "/Productos", method = RequestMethod.GET)
//	  public List<ProductoModel> listaProducto() {
////		ProductoModel mv = new ProductoModel();
//		
////	    mv.addObject("lista", ProductoService.traerTodos());
//	    return maper.traerTodos();
//	  }

}
