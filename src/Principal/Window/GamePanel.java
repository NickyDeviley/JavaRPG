package Principal.Window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import PlayerInput.GameKeyboardInput;
import Principal.Config;
import Principal.Managers.EntityManager;
import Principal.Managers.PlayerManager;
import Principal.Managers.WorldManager;

public class GamePanel extends JPanel {
	/**
		Classe que representa o painel onde pintamos
		os gráficos do jogo.
	*/

// PENDÊNCIAS
	private PlayerManager playerM;
	private EntityManager entityM;
	private WorldManager worldM;

	public GamePanel(WorldManager worldM, PlayerManager playerM, EntityManager entityM, GameKeyboardInput keyboardI)
	{
		this.setScreenSize(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyboardI);

		this.playerM = playerM;
		this.entityM = entityM;
		this.worldM = worldM;
	}

	@Override
	public void
	paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D pencil = (Graphics2D) g;
		
		// Mundo
		this.worldM.drawWorld(pencil);

		// Entidades
		this.entityM.drawEntities(pencil);

		// Jogador
		this.playerM.drawPlayer(pencil);

		pencil.dispose();
	}

	private void
	setScreenSize(short Width, short Height)
	{
		Dimension size = new Dimension(Width, Height);
		this.setMinimumSize(size);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
	}
}
