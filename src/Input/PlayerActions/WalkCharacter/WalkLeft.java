package Input.PlayerActions.WalkCharacter;

import Entities.Player.GamePlayer;
import Entities.util.Direction;
import Input.PlayerActions.PlayerActions;

public class WalkLeft implements PlayerActions {

	private Direction direction = Direction.LEFT;
	
	@Override
	public void 
	execute(GamePlayer player) 
	{
		player.walk(this.direction);
	}

	public Direction getDirection() { return direction; }

}
