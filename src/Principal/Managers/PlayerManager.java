package Principal.Managers;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import Entities.Player.GamePlayer;
import Input.PlayerActions.PlayerActions;
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
	updatePlayer (List<PlayerActions> actions)
	{
		for (int i = 0; i < actions.size(); ++i)
		{
			actions.get(i).execute(this.player);
		}
		
	}
	
	public void
	drawPlayer(Graphics2D pencil)
	{
		// DESENHANDO JOGADOR
		pencil.setColor(Color.WHITE);
		pencil.fillRect(this.player.getPositionX(), this.player.getPositionY(), Config.TILE_SIZE, Config.TILE_SIZE);
		// DESENHANDO JOGADOR
	}

	public GamePlayer getPlayer() { return this.player; }
}
