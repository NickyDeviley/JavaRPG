package Principal.Window;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Principal.Config;

public class GameWindow extends JFrame {
	/**
		Classe que gera a janela
	*/

	public GameWindow(GamePanel panel)
	{
		this.setTitle(Config.nomeJogo);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.add(panel);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
