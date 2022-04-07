package com.jacaranda.utilities;

import java.util.ArrayList;
import java.util.Collection;

public class Provincia{

	//Atributos de Provincia
	private String nombre;
	private String codigo;
	private Integer numeroHabitantes;
	private Double rentaPerCapita;
	private Double superficie;
		
	private final Integer LONGITUD_CODIGO = 2;
	
	private Collection<Pueblo> pueblos;
		
	
	//Constructores de Provincia
	public Provincia (String nombre, String codigo) {
		if(nombre!=null && codigo!=null) {
			this.nombre = nombre.toUpperCase();
			if (codigo.length()==2) {
				this.setCodigo(codigo);
			}else {
				throw new ProvinciaException("No se ha añadido el codigo");
			}
		}else {
			throw new ProvinciaException("No se ha podido añadir el nombre");
		}
		
		this.numeroHabitantes = 0;
		this.rentaPerCapita = 0.0;
		this.superficie = 0.0;
		this.pueblos = new ArrayList<>();
	}
	
	
	//Metodos de Provincia 
	public boolean addPueblo(String nombrePueblo, String codigo, int numeroHabitantes, 
							 double rentaPerCapita, double superficie)  throws ProvinciaException {
		
		try {
			boolean anadirPueblo = false;
				
				int codigoNuevo = Integer.valueOf(this.codigo) + Integer.valueOf(codigo);
			
			if (nombre == null) {
				throw new ProvinciaException("El codigo no puede ser nulo");
			}
			if (existePueblo(nombre)) {
				throw new ProvinciaException("El pueblo ya existe");
			} else {
				try {
					Pueblo p1 = new Pueblo(nombrePueblo, String.valueOf(codigoNuevo), numeroHabitantes, rentaPerCapita, superficie );
					pueblos.add(p1);
					anadirPueblo = true;
					this.superficie += superficie;
					this.numeroHabitantes += numeroHabitantes;
					this.rentaPerCapita += rentaPerCapita;
				}catch (PuebloException e) {
					throw new ProvinciaException("No se ha podido crear el pueblo",e);
				}
				
			}
			
			
			return anadirPueblo;
			}
			catch (Exception e) {
				throw new ProvinciaException("[ERROR] El codigo debe ser numerico");
			}
		}
		
		
		public boolean addPueblo(Pueblo pueblo)  throws ProvinciaException {
	
			try {
				
		int codigoNuevo = Integer.valueOf(this.codigo) + Integer.valueOf(pueblo.getCodigo());;	
			
		boolean anadirPueblo = false;
		
		if (pueblo.getNombre() == null) {
		
			throw new ProvinciaException("El codigo no puede ser nulo");
		}
		if (existePueblo(pueblo.getNombre())) {
		
			throw new ProvinciaException("El pueblo ya existe");
		} 
		else {
		
			anadirPueblo = true;
			pueblos.add(pueblo);
			this.superficie += pueblo.getSuperficie();
			this.numeroHabitantes += pueblo.getNumeroHabitantes();
			this.rentaPerCapita += pueblo.getRentaPerCapita();
			}
	
			return anadirPueblo;
		}
		catch (Exception e) {
			throw new ProvinciaException("[ERROR] El codigo debe ser numerico");
		}
		
		

	}
	 
	
	
	public boolean delPueblo(String nombre) {
		boolean eliminado = false;
		
		for(Pueblo p : this.pueblos) {
			if(p.getNombre().equalsIgnoreCase(nombre)) {
				this.pueblos.remove(p);
				this.superficie -= p.getSuperficie();
				this.rentaPerCapita -= p.getRentaPerCapita();
				this.numeroHabitantes -= p.getNumeroHabitantes();
			}
		}
		return eliminado;
	}
	
	private boolean existePueblo(String nombre) throws ProvinciaException {
		boolean resultado = false;
		if (nombre==null) {
			throw new ProvinciaException("El nombre del pueblo no puede ser nulo");
		}
		for (Pueblo pueblo : this.pueblos) {
			if (pueblo.getNombre().equalsIgnoreCase(nombre)) {
				resultado = true;
			}

		}
		return resultado;
	}

	
	
	public String getInformacionPueblo(String nombre) throws ProvinciaException {
		String resultado="";
		if (!existePueblo(nombre) || nombre==null) {
			resultado=null;
		}else {
			for (Pueblo p:this.pueblos) {
				if (p.getNombre().equalsIgnoreCase(nombre)) {
					resultado=p.toString();
				}
			}
		}
		return resultado;
	}

	
	public String getProvincia() {
		
		return this.nombre;
	}
	
	
	public String listadoNombrePueblo() {
		StringBuilder cadenaNueva = new StringBuilder("");
		for (Pueblo p : this.pueblos) {
			cadenaNueva.append(p.getNombre() + "\n");
		}
		return cadenaNueva.toString();
	}
	
	
	public String listadoPueblos() {
		StringBuilder cadenaNueva = new StringBuilder("");
		for (Pueblo p : this.pueblos) {
			cadenaNueva.append(p+"\n");
		}
		return cadenaNueva.toString();
	}
	
	
	public Integer numPueblos() {
		
		return pueblos.size();
	}
	
	
	
	//Getters-Setters de Provincia
	public String getCodigo() {
		return codigo;
	}


	private void setCodigo(String codigo) throws ProvinciaException {
		
		boolean esValido = codigo.length() == LONGITUD_CODIGO;		
		if (esValido) {
			for (int i = 0;i<codigo.length();i++) {
				if (!Character.isDigit(codigo.charAt(i))) {
					esValido = false;
				}
				
			}
			if(esValido) {
				this.codigo=codigo;
			}
		}
		else {
			throw new PuebloException("[ERROR] El codigo no es valido");
			}
	}


	public Integer getNumeroHabitantes() {
		return numeroHabitantes;
	}


	public void setNumeroHabitantes(String pueblo, Integer numeroHabitantes) {
	
		this.numeroHabitantes = numeroHabitantes;
	}


	public Double getRentaPerCapita() {
		return rentaPerCapita;
	}


	public void setRentaPerCapita(Double rentaPerCapita) {
		this.rentaPerCapita = rentaPerCapita;
	}


	public Double getSuperficie() {
		return superficie;
	}


	public void setSuperficie(String pueblo, Double superficie) {
		
		for(Pueblo p : this.pueblos) {
			if(p.getNombre().equalsIgnoreCase(nombre)) {
				p.setSuperficie(superficie);
				this.superficie += p.getSuperficie();
			}
		}
	}

	
	//toString() de Provincia
	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + "]";
	}
	
	
	
}
