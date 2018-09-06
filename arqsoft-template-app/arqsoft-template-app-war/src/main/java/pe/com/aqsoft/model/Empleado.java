package pe.com.aqsoft.model;

public class Empleado {

	private int id;
	private String nombre;
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Empleado(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
