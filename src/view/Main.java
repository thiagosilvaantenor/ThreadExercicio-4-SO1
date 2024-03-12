package view;

import controller.GanhadoresController;
import controller.ThreadEx4Controller;

public class Main {

	public static void main(String[] args) {

		
		double[] tempo = new double[5];
		ThreadEx4Controller[] sapo = new ThreadEx4Controller[5];
		for (int i = 0; i < 5; i++) {
			sapo[i] = new ThreadEx4Controller(i + 1, 100);
			sapo[i].start();
		}

		while (sapo[0].isAlive() || sapo[1].isAlive() || sapo[2].isAlive() || sapo[3].isAlive() || sapo[4].isAlive()) {

		}
		
		for(int i = 0; i < 5; i++) {
			tempo[i] = sapo[i].getTempo();
		}
		

		GanhadoresController ganhadores = new GanhadoresController(tempo);
		ganhadores.ordenarSapos();

	}

}
