package com.jacaranda.utilities;

public class MainApp {

	public static void main(String[] args) {

		
		Pueblo pas = new Pueblo("hola", "11111");
		
		
		Provincia sevilla = new Provincia("Sevilla", "90");
		
		sevilla.addPueblo("Lora del rio", "11120", 100, 20.3, 1200);
		
		sevilla.addPueblo("Villaverde del rio", "12122", 120, 21.3, 1000);
		
		sevilla.addPueblo("Algo", "13122", 200, 200.3, 200);
		
		System.out.println(sevilla.listadoPueblos());
		System.out.println("~~~~~~~~~~");
		System.out.println(sevilla.listadoNombrePueblo());
		System.out.println("~~~~~~~~~~");
		System.out.println(sevilla.getSuperficie());
		System.out.println(sevilla.getNumeroHabitantes());
		System.out.println(sevilla.getRentaPerCapita());
		System.out.println("~~~~~~~~~~");

		
		
	}

}
