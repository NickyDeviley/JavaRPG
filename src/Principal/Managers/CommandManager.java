package Principal.Managers;

import java.util.ArrayList;

import Entities.Player.States.States;
import Input.GameCommands;

public class CommandManager {
	/**
		Classe que gerencia as entradas do jogador
	*/
	
	// PENDÊNCIAS
	private InputManager inputM;
	private PlayerManager playerM;
	
	public CommandManager(InputManager inputM, PlayerManager playerM)
	{
		this.inputM = inputM;
		this.playerM = playerM;
	}
	
	public void
	playerInputUpdate()
	{	
		ArrayList<GameCommands> commands = this.inputM.getActionsForPressedKeys();
		
		this.playerM.getPlayer().setPlayerState(States.IDLE);
		
		for (int i = 0; i < commands.size(); ++i)
		{
			commands.get(i).execute(this.playerM.getPlayer());
		}
		
		/*
			Aqui nós vamos passar por toda a lista e chamar os métodos 
			execute() dos objetos na lista.
			
			Sendo que os comandos relacionados ao jogador vão trocar
			seu estado.
		*/
		
	}
	
}
