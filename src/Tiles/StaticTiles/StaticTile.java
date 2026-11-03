package Tiles.StaticTiles;

import java.awt.image.BufferedImage;

public class StaticTile {

	private byte ID;
	private String nome;
	private boolean	hadCollision;
	private BufferedImage sprite;

	public StaticTile(byte ID, String nome,
					  boolean hadCollision,
					  BufferedImage sprite)
	{
		this.ID = ID;
		this.nome = nome;
		this.hadCollision = hadCollision;
		this.sprite = sprite;
	}

	public byte getID() { return ID; }
	public void setID(byte iD) { ID = iD; }



	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public boolean isHadCollision() { return hadCollision; }
	public void setHadCollision(boolean hadCollision) { this.hadCollision = hadCollision; }

	public BufferedImage getSprite() {return sprite; }
	public void setSprite(BufferedImage sprite) { this.sprite = sprite; }
}
