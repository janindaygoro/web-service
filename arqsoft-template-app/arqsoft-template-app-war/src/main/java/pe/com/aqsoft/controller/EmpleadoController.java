package pe.com.aqsoft.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pe.com.aqsoft.dao.ProductoMapper;
import pe.com.aqsoft.model.Empleado;
import pe.com.aqsoft.model.ProductoModel;
import pe.com.aqsoft.servise.ProductoService;

@RestController
public class EmpleadoController {
//	ProductoMapper maper;
	
	@RequestMapping(value = "/listarEmpleados", method = RequestMethod.GET)
	public List<Empleado> listEmp() {
		System.out.println("Ejecuto");
		List<Empleado> lst = new ArrayList<Empleado>();
		Empleado emp1 = new Empleado(1, "Pancracio 1");
		Empleado emp2 = new Empleado(1, "Pancracio 2");
		lst.add(emp1);
		lst.add(emp2);
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
