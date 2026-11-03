package Principal.Managers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Tiles.TileInfoInput;
import Tiles.TileSpriteInput;
import Tiles.StaticTiles.StaticTile;

public class TileManager {
	/**
		Classe responsável por gerenciar os Tiles do jogo,
		ela instancia os tiles somente dos mapas próximos.
	*/

	private TileInfoInput tileInfoI;
	private TileSpriteInput tileSpriteI;

//	private ArrayList<StaticTile> previousMap;
	private ArrayList<StaticTile> actualMap;
//	private ArrayList<StaticTile> nextMap;

	public TileManager(TileInfoInput tileInfoI, TileSpriteInput tileSpriteI)
	{
		this.tileInfoI = tileInfoI;
		this.tileSpriteI = tileSpriteI;
		this.actualMap = new ArrayList<>();
		this.loadTiles();
	}

	public void
	loadTiles()
	{
		// Acessa as classes "TileInfoInput" e "TileSpriteInput" e
		// recupera as informações e os Sprites para instanciar os
		// tiles.

		ArrayList<String[]> tilesInfo = this.tileInfoI.getTilesInfo();
		ArrayList<BufferedImage> tileSprite = this.tileSpriteI.tileSpriteSheet(tilesInfo);

		byte ID = 0;

		for (int qtdTiles = 0; qtdTiles < tilesInfo.size(); ++qtdTiles)
		{
			ID = Byte.parseByte(tilesInfo.get(qtdTiles)[0]);
			this.actualMap.add(new StaticTile(ID,
											  tilesInfo.get(qtdTiles)[2],
											  false,
											  tileSprite.get(qtdTiles)));
		}
	}

	public ArrayList<StaticTile> getActualMap() { return actualMap; }
	public void setActualMap(ArrayList<StaticTile> actualMap) { this.actualMap = actualMap; }
}
