package pe.com.aqsoft.model;

public class UsuarioModel {
	
	private Integer idemp;
	private String usuario;
	
	public UsuarioModel() {
	}

	public UsuarioModel(Integer idemp, String usuario) {
		super();
		this.idemp = idemp;
		this.usuario = usuario;
	}

	public Integer getIdemp() {
		return idemp;
	}

	public void setIdemp(Integer idemp) {
		this.idemp = idemp;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
