package Entities.Player.States;

import Entities.Player.GamePlayer;

public enum States {

	// FIRST STATS
	IDLE { public void update(GamePlayer player) { player.idleState(); }},
	WALK { public void update(GamePlayer player) { player.movePlayer(); }},
	
	// SECOND STATS
	RUNNING { public void update(GamePlayer player) {}};
													  
	
	public abstract void update(GamePlayer player);
}
