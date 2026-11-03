package Entities.Player.States;

import Entities.Player.GamePlayer;

public enum States {

	// FIRST STATS
	IDLE { @Override
	public void update(GamePlayer player) { player.idleState(); }},
	WALK { @Override
	public void update(GamePlayer player) { player.movePlayer(); }},

	// SECOND STATS
	RUNNING { @Override
	public void update(GamePlayer player) {}};


	public abstract void update(GamePlayer player);
}
