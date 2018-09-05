package pe.com.aqsoft.dao;

import java.util.List;

import pe.com.aqsoft.model.CategoriaModel;
import pe.com.aqsoft.model.ProductoModel;

public interface ProductoMapper {

	  void insertar(ProductoModel productoBean);

	  List<ProductoModel> traerTodos();

	  List<CategoriaModel> traerCategorias();
}
