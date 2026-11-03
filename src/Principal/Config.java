package Principal;

public class Config {
	/**
		Classe que guarda configurações gerais do projeto
	*/

	public static final String nomeJogo = "GameEngine em Java Puro";

	public static final byte ORIGINAL_TILE_SIZE = 16;
	public static final byte SCALE = 4;
	public static final byte TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;	// 64

	public static final byte QTD_TILES_X = 20;
	public static final byte QTD_TILES_Y = 12;
	public static final short SCREEN_WIDTH = QTD_TILES_X * TILE_SIZE;	// 1280
	public static final short SCREEN_HEIGHT = QTD_TILES_Y * TILE_SIZE;	// 768

	public static final int SPRITESHEET_WIDTH = 112;
	public static final int SPRITESHEET_HEIGHT = 80;
	public static final int SPRITESHEET_WIDTH_SIZE = SPRITESHEET_WIDTH * SCALE;
	public static final int SPRITESHEET_HEIGHT_SIZE = SPRITESHEET_HEIGHT * SCALE;

	public static final String TILES_ASSET_PATH = "/Assets/TilesAssets/TileSet.png";
	public static final String TILES_INFO_PATH = "/Assets/TilesAssets/TilesInfo.txt";
	public static final String WORLDS_PATH = "/world/worldtest.txt";
}
