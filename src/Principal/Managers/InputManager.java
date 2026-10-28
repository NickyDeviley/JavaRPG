package Principal.Managers;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Input.GameCommands;
import Input.Game.CloseGame;
import Input.PlayerActions.MovementCharacter.Run;
import Input.PlayerActions.MovementCharacter.WalkDown;
import Input.PlayerActions.MovementCharacter.WalkLeft;
import Input.PlayerActions.MovementCharacter.WalkRight;
import Input.PlayerActions.MovementCharacter.WalkUp;
import PlayerInput.GameKeyboardInput;

public class InputManager {
	/**
		Classe que gerencia as entradas do jogador, identifica qual
		tecla foi pressionada e executa a ação
	*/
	
	// Pendências
	private GameKeyboardInput keyboardI;
	
	private Map<Integer, GameCommands> keyMap;
	
	public InputManager (GameKeyboardInput keyboardI)
	{
		this.keyboardI = keyboardI;
		this.keyMap = new HashMap<>();
	
		assignKeys();
	}
	
	public ArrayList<GameCommands>
	getActionsForPressedKeys ()
	{
		ArrayList<GameCommands> actions = new ArrayList<>();
	
		for (int i = 0; i < 256; ++i)
		{
			if (this.keyboardI.getKeys()[i])
			{
				actions.add(this.keyMap.get(i));
			}
		}
		return actions;
	}
	
	public ArrayList<GameCommands>
	getCommands()
	{
		return null;
	}
	
	private void
	assignKeys()
	{

	// PLAYER MOVEMENT
		// WALK
		this.keyMap.put(KeyEvent.VK_W, new WalkUp());
		this.keyMap.put(KeyEvent.VK_S, new WalkDown());
		this.keyMap.put(KeyEvent.VK_A, new WalkLeft());
		this.keyMap.put(KeyEvent.VK_D, new WalkRight());
		
		// RUN
		this.keyMap.put(KeyEvent.VK_SHIFT, new Run());
		
//		System.out.println("Shift: " + KeyEvent.VK_SHIFT);
//		System.out.println("Baixo: " + KeyEvent.VK_S);
//		System.out.println("Direita: " + KeyEvent.VK_D);
		
	// GAME
		//this.keyMap.put(KeyEvent.VK_ESCAPE, new CloseGame());
		
	}
	
}
