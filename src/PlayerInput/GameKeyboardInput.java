package PlayerInput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Principal.Managers.InputManager;

public class GameKeyboardInput implements KeyListener {
	
	private int size = 256;
	private boolean[] keys;
	
	public GameKeyboardInput()
	{
		this.keys = new boolean[size];
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void 
	keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() < size)
		{
			keys[e.getKeyCode()] = true;
		}
	}

	@Override
	public void 
	keyReleased(KeyEvent e) 
	{	
		if (e.getKeyCode() < size)
		{
			keys[e.getKeyCode()] = false;
		}	
	}

	public boolean[] getKeys() { return this.keys; }
	
}
