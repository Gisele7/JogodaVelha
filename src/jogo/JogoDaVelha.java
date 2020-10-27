package jogo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JogoDaVelha extends JPanel implements MouseListener {
	 
	Font minhaFontGrande = new Font("Consolas", Font.BOLD, 80);
	Font minhaFontMedia = new Font("Consolas", Font.BOLD, 30);
	Font minhaFontPeq = new Font("Consolas", Font.BOLD, 15);
	
	int matriz [][];
	int jogador;
	int ganhador = 0;
	boolean jogarNov;
	
	int v1;
	int v2;
	int empates;
	
	Color cor1; 
	
	public JogoDaVelha() {
		
		matriz = new int [3][3];
		jogador = 1;
		ganhador = 0;
		jogarNov = false;
		cor1 = new Color(0, 160, 0);
		v1 = 0;
		v2 = 0;
		empates = 0;
		
		
		for(int lin = 0; lin < 3; lin++){
			
			for(int col = 0; col < 3; col++)
				System.out.print(matriz[lin] [col]);
}
		System.out.println();
}
	
	
	@Override
	public void paintComponent(Graphics g2){
	
		Graphics2D g = (Graphics2D) g2.create();
		
		System.out.println();
for(int lin = 0; lin < 3; lin++){
			
			for(int col = 0; col < 3; col++){
				System.out.print(matriz[lin] [col]);
}
		System.out.println();
}
			
			if (jogarNov) {
				 int jogarNovamente = new JOptionPane().showConfirmDialog(this, "Deseja jogar novamente?");
				 if (jogarNovamente == JOptionPane.OK_OPTION) {
				 jogarNov = false;
				 reiniciarJogo ();
 }				else {
	 		System.exit(1);
 }
}

		g.setFont(minhaFontGrande);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 600, 600);
		
		g.setStroke(new BasicStroke(5));
		g.setColor(Color.BLUE);
		g.drawLine(0, 200, 600, 200);
		g.drawLine(0, 400, 600, 400);
		
		g.drawLine(200, 0, 200, 600);
		g.drawLine(400, 0, 400, 600);
		
			for(int lin = 0; lin < 3; lin++){
			
			for(int col = 0; col < 3; col++) {
				
			if (matriz[lin][col] == 1) {
				g.setColor(cor1);
				g.drawString("o", 80 + col*200, 120 + lin*200);
} 			else if (matriz[lin][col] == 2) {
				g.setColor(Color.RED);
			g.drawString("x", 80 + col*200, 120 +lin*200);
			
 }	
}
			if (ganhador != 0 ) {
			
				if (ganhador == 3) {
					g.setColor(Color.BLACK);
					g.setFont(minhaFontMedia);
					g.drawString("O jogo empatou!" , 180, 180);
				} else {
				
					if (ganhador == 1)
						g.setColor(cor1);
					else if (ganhador == 2)
						g.setColor(Color.red);
				
				
				g.setFont(minhaFontMedia);
					g.drawString("O jogador " + ganhador + " venceu!" , 150, 190);
		
  }
				jogarNov = true;
				repaint();
			}}
			g.setFont(minhaFontPeq);
			g.setColor(cor1);
			g.drawString("Vitórias: " + v1, 60, 20);
			
			g.setColor(Color.red);
			g.drawString("Vitórias: " + v2, 450, 20);
			
			g.setColor(Color.MAGENTA);
			g.drawString("Empates: " + empates, 270, 20);
		
			}
			


	@Override
	public void mouseClicked(MouseEvent e) {

		//System.out.println(e.getX() + " , " + e.getY());
			
				int linha = e.getY()/200;	
				int coluna = e.getX()/200;
				System.out.println("Clicou na linha " + linha);
				System.out.println("Clicou na coluna " + coluna);
			
				if(jogador == 1 && matriz[linha][coluna] == 0) {
				matriz[linha][coluna] = 1;
				jogador = 2;
	}			else if (jogador == 2 && matriz[linha][coluna] == 0) {
			jogador = 1;
			matriz[linha][coluna] = 2;	
}
		
				verificaGanhador();
				repaint();
		
}
			private void reiniciarJogo() {
				for (int lin = 0; lin < 3; lin++){
					for (int col = 0; col < 3; col++){					
						matriz [lin][col] = 0;
						ganhador = 0;
  }				
 }			
}

		private void verificaGanhador (){
			for(int lin = 0; lin < 3; lin++) {	
				
					if (matriz[lin][0] == matriz[lin][1] && matriz[lin][0] == matriz[lin][2] && matriz[lin][0] != 0) {
						System.out.println("Houve ganhador!");
						ganhador = matriz[lin][0];
						break;
					
 }		
}
			
			for(int col = 0; col < 3; col++) {	
				
				if (matriz[0][col] == matriz[1][col] && matriz[0][col] == matriz[2][col] && matriz[0][col] != 0) {
					System.out.println("Houve ganhador!");
					ganhador = matriz[0][col];
					break;
 }	
}
			if (matriz[0][0] == matriz [1][1] && matriz[0][0] == matriz [2][2] && matriz[0][0] != 0) {
				System.out.println("Houve um ganhador!");
				ganhador = matriz[0][0];
				
}
			 
			if (matriz[0][2] == matriz [1][1] && matriz[0][2] == matriz [2][0] && matriz[0][2] != 0) {
				System.out.println("Houve um ganhador!");
				ganhador = matriz[0][2];
				
}
			
			if (ganhador == 1) {
				v1++;
			}	else if (ganhador == 2) {
					v2++;
 }			else {
	 			
	 
	 			boolean cheia = true;
	 			for (int lin = 0; lin < 3; lin++) {
	 				
	 				for (int col = 0; col < 3; col++) {
	 					if (matriz[lin][col] == 0 )
	 						cheia = false;
	 				}
	 			}
	 			
	 			if (cheia) {
	 				ganhador = 3;
	 				empates++;
}
}
}
			
			
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
 }
}
