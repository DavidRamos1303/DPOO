package logico;

public class Recurso {
	
	protected String id;
	protected String nombre;
	protected String tipo;
	protected Boolean disponibilidad;
	
	public Recurso(String id, String nombre, String tipo, Boolean disponibilidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.disponibilidad = disponibilidad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
}
