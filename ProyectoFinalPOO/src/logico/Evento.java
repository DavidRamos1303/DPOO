package logico;

import java.util.ArrayList;
import java.util.Date;

public class Evento {

	private String id;
	private String titulo;
	private String tipo;
	private Date fecha;
	private ArrayList<Comision> comisiones;
	private ArrayList<TrabajoCientifico> trabajosCientificos;
	private ArrayList<Recurso> recursos;
	
	public Evento(String id, String titulo, String tipo, Date fecha) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.tipo = tipo;
		this.fecha = fecha;
		comisiones = new ArrayList<>();
		trabajosCientificos = new ArrayList<>();
		recursos = new ArrayList<>();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public ArrayList<Comision> getComisiones() {
		return comisiones;
	}
	public void setComisiones(ArrayList<Comision> comisiones) {
		this.comisiones = comisiones;
	}
	public ArrayList<TrabajoCientifico> getTrabajosCientificos() {
		return trabajosCientificos;
	}
	public void setTrabajosCientificos(ArrayList<TrabajoCientifico> trabajosCientificos) {
		this.trabajosCientificos = trabajosCientificos;
	}
	public ArrayList<Recurso> getRecursos() {
		return recursos;
	}
	public void setRecursos(ArrayList<Recurso> recursos) {
		this.recursos = recursos;
	}
}
