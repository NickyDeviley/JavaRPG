package Principal.Managers;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import Entities.Player.GamePlayer;
import Entities.Player.States.States;
import Input.GameCommands;
import Principal.Config;

public class PlayerManager {
	/**
		Classe exclusivamente para gerenciar o personagem do jogador
	*/
	private GamePlayer player;
	
	public PlayerManager ()
	{
		this.player = new GamePlayer();
	}

	public void 
	updatePlayerState (List<GameCommands> actions)
	{
		// Aqui nós vamos identificar o estado atual do jogador e
		// chamar os métodos do próprio estado para executar suas tarefas.
		
		//this.player.setPlayerState(States.IDLE);
		//this.player.setPlayerSecondState(States.IDLE);
		
		for (int i = 0; i < actions.size(); ++i)
		{
			actions.get(i).execute(player);
		}
	}
	
	public void
	drawPlayer(Graphics2D pencil)
	{
		// DESENHANDO JOGADOR
		pencil.setColor(Color.WHITE);
		pencil.fillRect(this.player.getScreenPositionX(), 
						this.player.getScreenPositionY(), 
						Config.TILE_SIZE, Config.TILE_SIZE);
		// DESENHANDO JOGADOR
	}

	public GamePlayer getPlayer() { return this.player; }
}
