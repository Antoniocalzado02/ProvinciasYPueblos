package com.jacaranda.utilities;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

	public static void main(String[] args) {

		Provincia sevilla = new Provincia("Sevilla", "11");
		
		sevilla.addPueblo("Lora del rio", "11", 100, 20.3, 1200);
		
		
		sevilla.addPueblo("Villaverde del rio", "12", 120, 21.3, 1000);
		
		sevilla.addPueblo("Algo", "13", 200, 200.3, 200);
		
		System.out.println(sevilla.listadoPueblos());
		System.out.println("~~~~~~~~~~");
		System.out.println(sevilla.listadoNombrePueblo());
	}

}
