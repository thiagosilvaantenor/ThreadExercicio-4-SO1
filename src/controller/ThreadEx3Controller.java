package controller;

public class ThreadEx3Controller extends Thread {
//	Fazer uma aplicação de uma corrida de sapos, com 5 Threads, cada Thread
//	controlando 1 sapo. Deve haver um tamanho máximo para cada pulo do sapo (em
//	metros) e a distância máxima para que os sapos percorram. A cada salto, um sapo pode
//	dar um salto de 0 até o tamanho máximo do salto (valor aleatório). Após dar um salto, a
//	Thread, para cada sapo, deve mostrar no console, qual foi o tamanho do salto e quanto
//	o sapo percorreu. Assim que o sapo percorrer a distância máxima, a Thread deve
//	apresentar que o sapo chegou e qual sua colocação.
//	Dica: O exercício deve ser resolvido todo em console, ou seja, como se estivesse sendo
//	narrado. Atenção para a forma de definir a ordem de chegada.

	private int sapo;
	private double distanciaSaltoMax;
	private double distanciaPercorrida = 0;
	private final double distanciaCorrida = 300;
	private double tempo;

	public ThreadEx3Controller(int sapo, double distanciaSaltoMax) {
		this.sapo = sapo;
		this.distanciaSaltoMax = distanciaSaltoMax;
	}

	public double getDistanciaSaltoMax() {
		return distanciaSaltoMax;
	}

	private void setDistanciaPercorrida(double distancia) {
		this.distanciaPercorrida += distancia;
	}

	public double getDistanciaPercorrida() {
		return distanciaPercorrida;
	}

	public double getDistanciaCorrida() {
		return distanciaCorrida;
	}

	public double getTempo() {
		return tempo;
	}

	@Override
	public void run() {
		Boolean chegada = false;
		double percorreu;
		pular();
		while (!chegada) {
			pular();
			percorreu = getDistanciaPercorrida();
			if (percorreu >= getDistanciaCorrida()) {
				System.out.println("O sapo N° " + sapo + " chegou a linha de chegada!");
				tempo = System.nanoTime();
				tempo = tempo / Math.pow(10, 9);
				chegada = true;
			}
		}
	}

	private void pular() {
		try {
			sleep((sapo + 1));
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		double salto = (Math.random() * distanciaSaltoMax) + 1;
		setDistanciaPercorrida(salto);
		salto = Math.round(salto);
		System.out.println("O sapo N° " + sapo + " pulou: " + salto + " metros!");
	}

}
