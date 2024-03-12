package controller;

import java.lang.reflect.Array;

public class GanhadoresController {

	private double[] sapos;

	public GanhadoresController(double[] tempos) {
		this.sapos = tempos;
	}

	public void ordenarSapos() {
		double[] ordem = sapos.clone();
		double aux;

		for (int i = 0; i < ordem.length; i++) {
			for (int j = 0; j < 4; j++) {
				if (ordem[j] > ordem[j + 1]) {
					aux = ordem[j];
					ordem[j] = ordem[j + 1];
					ordem[j + 1] = aux;
				}

			}
		}

		for (int i = 0; i < ordem.length; i++) {
			for (int j = 0; j < sapos.length; j++) {
				if (ordem[i] == sapos[j]) {
					System.out.println("O sapo #" + (j + 1) + ", chegou em " + (i + 1) + "° lugar!");
				}
			}
		}

	}
}
