package Commands.PlayerActions.MovementCharacter;

import Commands.GameCommands;
import Entities.Direction.Direction;
import Entities.Player.GamePlayer;
import Entities.Player.States.States;

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
