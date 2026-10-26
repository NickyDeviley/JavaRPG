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
	
}
