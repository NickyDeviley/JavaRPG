package Util;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Principal.Config;

public class CropTool {
	/**
	 	Classe que corta os tiles da SpriteSheet
	*/

	public CropTool()
	{}

	public ArrayList<BufferedImage>
	crop(BufferedImage spriteSheet, ArrayList<String[]> tileInfo, int qtdSprites)
	{

		ArrayList<BufferedImage> tileSprites = new ArrayList<>();
		int posX = 0;
		int posY = 0;

		for (int i = 0; i < qtdSprites; ++i)
		{
			posX = Integer.parseInt(tileInfo.get(i)[2]) * Config.SCALE;
			posY = Integer.parseInt(tileInfo.get(i)[3]) * Config.SCALE;
			tileSprites.add(spriteSheet.getSubimage(posX,
													posY,
													Config.TILE_SIZE,
													Config.TILE_SIZE));
		}

		return tileSprites;
	}

}
