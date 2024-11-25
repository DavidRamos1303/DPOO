package logico;

import java.util.ArrayList;

public class GestionEvento {
	
	private ArrayList<Persona> misPersonas;
	private ArrayList<TrabajoCientifico> misTrabajosCientificos;
	private ArrayList<Comision> misComisiones;
	private ArrayList<Evento> misEventos;
	private ArrayList<Recurso> misRecursos;
	
	public static GestionEvento gestion = null;
	
	public static int codTrabajos = 1;
	public static int codComision = 1;
	public static int codEvento = 1;
	public static int codRecursos = 1;
	
	private GestionEvento() {
		super();
		misRecursos = new ArrayList<>();
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
	public ArrayList<Recurso> getMisRecursos() {
		return misRecursos;
	}
	public void setMisRecursos(ArrayList<Recurso> misRecursos) {
		this.misRecursos = misRecursos;
	}
	
	public void insertarPersonas(Persona obj) {
		
	}
	
	public void eliminarPersona(Persona obj) {
		
	}
	
	public Persona buscarPersonasCedula(String cedula) {
		
	}
		
}
