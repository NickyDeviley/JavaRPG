package Principal.Managers;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import Entities.Player.GamePlayer;
import Principal.Config;
import Tiles.StaticTiles.StaticTile;
import WorldInput.WorldInput;

public class WorldManager {
	/*
		Classe que gerencia o mundo do jogo, ele renderiza os
		tiles e guarda informações do mundo.
	*/

	private TileManager tileM;
	private WorldInput worldI;
	private GamePlayer player;
	
	private ArrayList<StaticTile> tiles;
	private int[][] map;

	public WorldManager(TileManager tileM, WorldInput worldI, PlayerManager playerM)
	{
		this.tileM = tileM;
		this.worldI = worldI;
		this.player = playerM.getPlayer();

		this.updateMap();
		this.tiles = tileM.getActualMap();
	}

	public void
	drawWorld(Graphics2D pencil)
	{
		for (int i = 0; i < 50; ++i)
		{
			for (int j = 0; j < 50; ++j )
			{
				int tileWorldX = j * Config.TILE_SIZE;
				int tileWorldY = i * Config.TILE_SIZE;

				int tileScreenX = tileWorldX - this.player.getWorldPositionX() + this.player.getScreenPositionX();
				int tileScreenY = tileWorldY - this.player.getWorldPositionY() + this.player.getScreenPositionY();

				if (tileScreenX > (-Config.TILE_SIZE) && 
					tileScreenX < Config.SCREEN_WIDTH)
				{
					if (tileScreenY > (-Config.TILE_SIZE) && 
						tileScreenY < Config.SCREEN_WIDTH)
					{
						pencil.drawImage(this.tiles.get(map[j][i]).getSprite(),
										 tileScreenX, tileScreenY,
										 Config.TILE_SIZE, Config.TILE_SIZE,
										 null); 
					}
				}
			}
		}
	}

	public void
	updateMap()
	{
		this.map = this.worldI.loadMap();
	}

}
