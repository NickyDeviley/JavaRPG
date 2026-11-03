package Principal.Managers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.List;

import Commands.GameCommands;
import Entities.Player.GamePlayer;
import Principal.Config;

public class PlayerManager {
	/**
		Classe exclusivamente para gerenciar o personagem do jogador
	*/
	private GamePlayer player;
	private Font fonte;

	public PlayerManager ()
	{
		this.fonte = new Font("Times New Roman", Font.PLAIN, 25);
		this.player = new GamePlayer();
	}

	public void
	updatePlayerState (List<GameCommands> actions)
	{
		// Aqui nós vamos identificar o estado atual do jogador e
		// chamar os métodos do próprio estado para executar suas tarefas.

		for (GameCommands action : actions) {
			action.execute(player);
		}
	}

	public void
	drawPlayer(Graphics2D pencil)
	{
		pencil.setColor(Color.WHITE);
		pencil.setFont(fonte);
		pencil.drawString("World_X: " + this.player.getWorldPositionX(), 25, 50);
		pencil.drawString("World_Y: " + this.player.getWorldPositionY(), 25, 75);
		//pencil.drawString("Direction: " + this.player.getActualDirection(), 25, 100);

		// DESENHANDO JOGADOR
		pencil.fillRect(this.player.getScreenPositionX(),
						this.player.getScreenPositionY(),
						Config.TILE_SIZE, Config.TILE_SIZE);

		// DESENHANDO JOGADOR
	}

	public GamePlayer getPlayer() { return this.player; }
}
