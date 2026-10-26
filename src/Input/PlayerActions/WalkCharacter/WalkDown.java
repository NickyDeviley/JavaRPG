package Input.PlayerActions.WalkCharacter;

import Entities.Player.GamePlayer;
import Entities.util.Direction;
import Input.PlayerActions.PlayerActions;

public class WalkDown implements PlayerActions {

	private Direction direction = Direction.DOWN;
	
	@Override
	public void 
	execute(GamePlayer player) 
	{
		player.walk(this.direction);
	}

	public Direction getDirection() { return direction; }
	
}
