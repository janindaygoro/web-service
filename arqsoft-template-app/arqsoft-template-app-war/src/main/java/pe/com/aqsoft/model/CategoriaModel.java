package pe.com.aqsoft.model;

/**
 * 
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 *
 */
public class CategoriaModel {

  private Integer idcat;
  private String nombre;

  public CategoriaModel() {
  }

  public CategoriaModel(Integer idcat, String nombre) {
    this.idcat = idcat;
    this.nombre = nombre;
  }

  public Integer getIdcat() {
    return idcat;
  }

  public void setIdcat(Integer idcat) {
    this.idcat = idcat;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

}
