package Tiles;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Principal.Config;
import Util.CropTool;
import Util.RedimensionTool;

public class TileSpriteInput {
	/**
		Classe responsável por carregar a sprite sheet,
		que contém todos os tiles do jogo
	*/

	private RedimensionTool utilityT;
	private CropTool cropT;

	public TileSpriteInput()
	{
		utilityT = new RedimensionTool();
		cropT = new CropTool();
	}

	public ArrayList<BufferedImage>
	tileSpriteSheet(ArrayList<String[]> tileInfo)
	{

		BufferedImage tileSheet = null;
		ArrayList<BufferedImage> tileSprites = new ArrayList<>();

		try 
		{

			// Recebe a spriteSheet com todos os Tiles de um mapa específico
			BufferedImage originalTileSheet = ImageIO.read(getClass().getResourceAsStream(Config.TILES_ASSET_PATH));

			// Redimensiona a imagem para ela ficar na escala correta
			tileSheet = utilityT.scaleImage(originalTileSheet,
											Config.SPRITESHEET_WIDTH_SIZE,
											Config.SPRITESHEET_HEIGHT_SIZE);

			// recorta os sprites
			tileSprites = cropT.crop(tileSheet,
									 tileInfo,
									 tileInfo.size());

		}
		catch (IOException e) 
		{
			System.out.println("Erro ao baixar o tile set!");
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) 
		{
			System.out.println("Não achou o arquivo de imagem!");
			e.printStackTrace();
		}

		return tileSprites;

	}

}
