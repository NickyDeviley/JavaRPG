package Entities.Player;

import Entities.Entity;
import Entities.Player.States.States;
import Entities.util.Direction;
import Principal.Config;

public class GamePlayer extends Entity {

	private final byte runningSpeed;
	private byte actualSpeed;
	
	private int screenPositionX;
	private int screenPositionY;
	
	private States playerState;
	private States playerSecondState;
	
	public GamePlayer() 
	{
		super(1, "Jogador", (short) 100, (byte) 4, 0, 0);
		this.screenPositionX = (Config.SCREEN_WIDTH / 2) - (Config.TILE_SIZE / 2);
		this.screenPositionY = (Config.SCREEN_HEIGHT / 2) - (Config.TILE_SIZE / 2);
		this.runningSpeed = (byte) 8;
		this.actualSpeed = this.speed;
		this.playerState = States.IDLE;
		this.playerSecondState = States.IDLE;
		this.actualDirection = Direction.DOWN;
	}
	
	public void
	updatePlayerLogic()
	{
		this.getPlayerState().update(this);
		this.setPlayerState(States.IDLE);
		this.setPlayerSecondState(States.IDLE);
	}
	
	public void 
	movePlayer()
	{
		this.setActualSpeed((this.getPlayerSecondState() == States.RUNNING) ? this.getRunningSpeed() : this.getSpeed());		

//		System.out.print("X: " + this.getWorldPositionX() + "\t");
//		System.out.print("Y: " + this.getWorldPositionY() + "\t");
//		System.out.print("Speed: " + this.getActualSpeed() + "\t");
//		System.out.print("State: " + this.getPlayerState() + "\t");
//		System.out.print("SecondState: " + this.getPlayerSecondState() + "\t");
//		System.out.print("Dir: " + this.actualDirection + "\n");
		
		this.setWorldPositionX(this.worldPositionX + (this.getActualSpeed() * this.getActualDirection().x));
		this.setWorldPositionY(this.worldPositionY + (this.getActualSpeed() * this.getActualDirection().y));	
	}
	
	public void
	idleState()
	{
		// Esse método é chamado apenas pelo estado IDLE, quando o jogador fica parado
		// Sua variaveis modificadas por outros estados voltam ao padrão.	
	}
	
	//public void setRunningSpeed(byte runningSpeed) { this.runningSpeed = runningSpeed; }
	public byte getRunningSpeed() { return this.runningSpeed; }
	
	public void setScreenPositionX(int screenPositionX) { this.screenPositionX = screenPositionX; }
	public int getScreenPositionX() { return this.screenPositionX; }
	
	public void setScreenPositionY(int screenPositionY) { this.screenPositionY = screenPositionY; }
	public int getScreenPositionY() { return this.screenPositionY; }

	public void setActualSpeed(byte actualSpeed) { this.actualSpeed = actualSpeed; }
	public byte getActualSpeed() { return this.actualSpeed; }

	public States getPlayerState() { return playerState; }
	public void setPlayerState(States playerState) { this.playerState = playerState; }

	public States getPlayerSecondState() { return playerSecondState; }
	public void setPlayerSecondState(States playerSecondState) { this.playerSecondState = playerSecondState; }
	
	
	
}