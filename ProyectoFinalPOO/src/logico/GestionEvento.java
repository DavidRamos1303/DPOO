package logico;

import java.util.ArrayList;

public class GestionEvento {
	
	private ArrayList<Persona> misPersonas;
	private ArrayList<TrabajoCientifico> misTrabajosCientificos;
	private ArrayList<Comision> misComisiones;
	private ArrayList<Evento> misEventos;
	
	public static GestionEvento gestion = null;
	
	private GestionEvento() {
		super();
		misPersonas = new ArrayList<>();
		misTrabajosCientificos = new ArrayList<>();
		misComisiones = new ArrayList<>();
		misEventos = new ArrayList<>();
	}
	
	public static GestionEvento getInstance() {
		if(gestion == null) {
			gestion = new GestionEvento();
		}return gestion;
	}
	
	
	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}
	public void setMisPersonas(ArrayList<Persona> misPersonas) {
		this.misPersonas = misPersonas;
	}
	public ArrayList<TrabajoCientifico> getMisTrabajosCientificos() {
		return misTrabajosCientificos;
	}
	public void setMisTrabajosCientificos(ArrayList<TrabajoCientifico> misTrabajosCientificos) {
		this.misTrabajosCientificos = misTrabajosCientificos;
	}
	public ArrayList<Comision> getMisComisiones() {
		return misComisiones;
	}
	public void setMisComisiones(ArrayList<Comision> misComisiones) {
		this.misComisiones = misComisiones;
	}
	public ArrayList<Evento> getMisEventos() {
		return misEventos;
	}
	public void setMisEventos(ArrayList<Evento> misEventos) {
		this.misEventos = misEventos;
	}
	
	

}
