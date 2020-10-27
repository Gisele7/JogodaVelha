package jogo;

import javax.swing.JFrame;

public class Janela {

	public static void main(String[] args) {

		JFrame frame = new JFrame ("Jogo da Velha");
		frame.setSize(600,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false); //Não deixa o usuário redimensionar a janela

		JogoDaVelha velha = new JogoDaVelha();
		velha.setBounds(0, 0, 600, 630);
		frame.add(velha);
		
		frame.addMouseListener(velha);
	}

}
