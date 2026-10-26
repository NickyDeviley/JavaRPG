package Input.PlayerActions.WalkCharacter;

import Entities.Player.GamePlayer;
import Entities.util.Direction;
import Input.PlayerActions.PlayerActions;

public class WalkUp implements PlayerActions {

	private Direction direction = Direction.UP;
	
	@Override
	public void 
	execute(GamePlayer player) 
	{
		player.walk(this.direction);
	}

	public Direction getDirection() { return direction; }

}
