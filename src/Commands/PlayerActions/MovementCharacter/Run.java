package Commands.PlayerActions.MovementCharacter;

import Commands.GameCommands;
import Entities.Player.GamePlayer;
import Entities.Player.States.States;

public class Run implements GameCommands {

	@Override
	public void
	execute(GamePlayer player)
	{
		//	Esse método muda o estado do jogador
		player.setPlayerSecondState(States.RUNNING);

	}
}
