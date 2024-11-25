package logico;

public class Jurado extends Persona {
	
	private String area;

	public Jurado(String id, String nombre, String apellidos, String email, String telefono, String area) {
		super(id, nombre, apellidos, email, telefono);
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}
