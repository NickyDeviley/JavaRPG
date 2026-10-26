package Entities;

public abstract class Entity {
	/**
		Classe molde para as entidades
	*/
	
	protected String name;
	protected short life;
	protected byte speed;
	protected int positionX;
	protected int positionY;
	
	public Entity(String name, short life, byte speed, int positionX, int positionY)
	{
		this.name = name;
		this.life = life;
		this.speed = speed;
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public short getLife() { return life; }
	public void setLife(short life) { this.life = life; }

	public byte getSpeed() { return speed; }
	public void setSpeed(byte speed) { this.speed = speed; }

	public int getPositionX() { return positionX; }
	public void setPositionX(int positionX) { this.positionX = positionX; }

	public int getPositionY() { return positionY; }
	public void setPositionY(int positionY) { this.positionY = positionY; }
	
	
	
}
