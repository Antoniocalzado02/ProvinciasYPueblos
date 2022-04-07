package com.jacaranda.test;

import org.junit.jupiter.api.Test;

import com.jacaranda.utilities.Provincia;
import com.jacaranda.utilities.ProvinciaException;
import com.jacaranda.utilities.Pueblo;

class ProvinciaTest {

	@Test
	void testCrearProvinciaDatos() {
		Provincia pr = new Provincia("Sevilla","11");
		assert(pr instanceof Provincia && pr != null);
		
	}
	
	@Test
	void testCrearProvinciaNombreNull() {
		try {
			Provincia pr = new Provincia(null,"11445");
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}
	}
	
	@Test
	void testCrearProvinciaCodigoNull() {
		try {
			Provincia pr = new Provincia("Sevilla",null);
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}
	}
	
	@Test
	void testCrearProvinciaNombreConCaracter() {
		try {
			Provincia pr = new Provincia("Sevilla","1");
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}
	}
	
	@Test
	void testCrearProvinciaNombreCon3Caracteres() {
		try {
			Provincia pr = new Provincia("Sevilla","111");
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}
	}
	
	@Test
	void testaddPueblo() {
		try {
			Provincia pr = new Provincia("Sevilla","17");

			Pueblo pb = new Pueblo("Lora", "12341",1000,20.5,12005.3);

			
			pr.addPueblo(pb);
			
			assert(true);
		} catch (ProvinciaException pe) {
			assert(false);
		}
	}
	
	@Test
	void testaddPuebloRepetido() {
		try {
			Provincia pr = new Provincia("Sevilla","17");

			Pueblo pb = new Pueblo("Lora", "12341",1000,20.5,12005.3);
			Pueblo pb1 = new Pueblo("Lora", "12341",1000,20.5,12005.3);
			
			pr.addPueblo(pb);
			pr.addPueblo(pb1);
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}
	}
	
	
	@Test
	void testaddPuebloPorDefecto() {
		try {
			Provincia pr = new Provincia("Sevilla","17");

			Pueblo pb = new Pueblo("Lora", "12341");
			
			pr.addPueblo(pb);
			assert(true);
		} catch (ProvinciaException pe) {
			assert(false);
		}
	}
	
	@Test
	void testaddProvinciaPorDefecto() {
		try {
			Provincia pr = new Provincia("Sevilla","17");

			Pueblo pb = new Pueblo("Lora", "12341");
			
			pr.addPueblo(pb);
			assert(true);
		} catch (ProvinciaException pe) {
			assert(false);
		}
	}
	
	
	@Test
	void testGetInfoPueblo() {
		try {
			Provincia pr = new Provincia("Sevilla","17");

			Pueblo pb = new Pueblo("Lora", "12341");
			
			pr.addPueblo(pb);
			
			pr.getInformacionPueblo("Lora");
			assert(true);
		} catch (ProvinciaException pe) {
			assert(false);
		}
	}
	
	@Test
	void testProvinciaNegativa() {
		try {
			Provincia pr = new Provincia("Sevilla","17");

			pr.addPueblo("Lora", "10000", -21, -22.5, -54.6);
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}
	}
	
	
	

}
