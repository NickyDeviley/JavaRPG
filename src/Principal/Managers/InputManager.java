package Principal.Managers;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Input.PlayerActions.PlayerActions;
import Input.PlayerActions.WalkCharacter.WalkDown;
import Input.PlayerActions.WalkCharacter.WalkLeft;
import Input.PlayerActions.WalkCharacter.WalkRight;
import Input.PlayerActions.WalkCharacter.WalkUp;
import PlayerInput.GameKeyboardInput;

public class InputManager {
	/**
		Classe que gerencia as entradas do jogador, identifica qual
		tecla foi pressionada e executa a ação
	*/
	
	// Pendências
	private GameKeyboardInput keyboardI;
	
	private Map<Integer, PlayerActions> keyMap;
	
	public InputManager (GameKeyboardInput keyboardI)
	{
		this.keyboardI = keyboardI;
		this.keyMap = new HashMap<>();
	
		assignKeys();
	}
	
	public ArrayList<PlayerActions>
	getActionsForPressedKeys ()
	{
		ArrayList<PlayerActions> actions = new ArrayList<>();
	
		for (int i = 0; i < 256; ++i)
		{
			if (this.keyboardI.getKeys()[i])
			{
				actions.add(this.keyMap.get(i));
			}
		}
		
		return actions;
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
		
	// GAME
		this.keyMap.put(null, null);
		
	}
	
}
