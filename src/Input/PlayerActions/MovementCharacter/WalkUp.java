package Input.PlayerActions.MovementCharacter;

import Entities.Player.GamePlayer;
import Entities.Player.States.States;
import Entities.util.Direction;
import Input.GameCommands;

public class WalkUp implements GameCommands {

	private Direction direction = Direction.UP;
	
	@Override
	public void 
	execute(GamePlayer player) 
	{
		player.setActualDirection(this.direction);
		player.setPlayerState(States.WALK);
	}

}
