package view;

import java.util.ArrayList;
import java.util.Collections;

import controller.ThreadEx3Controller;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Double> tempos = new ArrayList<Double>();
		
		for (int i = 0; i < 5; i++) {
			ThreadEx3Controller sapo = new ThreadEx3Controller(i+1,100);
			sapo.start();
			tempos.add(sapo.getTempo());
		}
		
		
		Collections.sort(tempos);
		
		System.out.println("Ordem de chegada foi: " + tempos);
		
		
	}

}
