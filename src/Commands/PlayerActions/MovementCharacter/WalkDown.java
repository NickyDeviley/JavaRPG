package Commands.PlayerActions.MovementCharacter;

import Commands.GameCommands;
import Entities.Direction.Direction;
import Entities.Player.GamePlayer;
import Entities.Player.States.States;

public class WalkDown implements GameCommands {

	private Direction direction = Direction.DOWN;

	@Override
	public void
	execute(GamePlayer player)
	{
		player.setActualDirection(this.direction);
		player.setPlayerState(States.WALK);
	}
}
