package Entities;

import Entities.Direction.Direction;

public abstract class Entity {
	/**
		Classe molde para as entidades
	*/

	protected int ID;
	protected String name;
	protected short life;
	protected byte speed;
	protected int worldPositionX;
	protected int worldPositionY;
	protected Direction actualDirection;

	public Entity(int ID, String name, short life, byte speed, int worldPositionX, int worldPositionY)
	{
		this.ID = ID;
		this.name = name;
		this.life = life;
		this.speed = speed;
		this.worldPositionX = worldPositionX;
		this.worldPositionY = worldPositionY;
	}

	public int getID() { return this.ID; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public short getLife() { return life; }
	public void setLife(short life) { this.life = life; }

	public byte getSpeed() { return speed; }
	public void setSpeed(byte speed) { this.speed = speed; }

	public int getWorldPositionX() { return this.worldPositionX; }
	public void setWorldPositionX(int worldPositionX) { this.worldPositionX = worldPositionX; }

	public int getWorldPositionY() { return this.worldPositionY; }
	public void setWorldPositionY(int worldPositionY) { this.worldPositionY = worldPositionY; }

	public Direction getActualDirection() { return this.actualDirection; }
	public void setActualDirection(Direction actualDirection) { this.actualDirection = actualDirection; }
}
