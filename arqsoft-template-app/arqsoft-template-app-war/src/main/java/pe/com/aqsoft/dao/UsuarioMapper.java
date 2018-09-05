package pe.com.aqsoft.dao;

import org.apache.ibatis.annotations.Param;

import pe.com.aqsoft.model.UsuarioModel;

public interface UsuarioMapper {
	UsuarioModel traerUsuario(@Param("usuario") String usuario, @Param("clave") String clave);
	

}
