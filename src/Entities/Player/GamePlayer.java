package Entities.Player;

import Entities.Entity;
import Entities.util.Direction;

public class GamePlayer extends Entity {

	private byte runningSpeed;
	
	public GamePlayer() 
	{
		super("Jogador", (short) 100, (byte) 4, 0, 0);
	}
	
	public void 
	walk(Direction direction)
	{	
		switch (direction)
		{
			case Direction.LEFT: {
				this.positionX--;
			} break;
			case Direction.RIGHT: {
				this.positionX++;
			}break;
			case Direction.UP: {
				this.positionY--;
			} break;
			case Direction.DOWN: {
				this.positionY++;
			} break;
			default: {
				
			} break;
		}
	}
	
	public void setRunningSpeed(byte runningSpeed) { this.runningSpeed = runningSpeed; }
	public byte getRunningSpeed() { return this.runningSpeed; }
	
}
