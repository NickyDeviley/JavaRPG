package PlayerInput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameKeyboardInput implements KeyListener {
	
	private ArrayList<Integer> keys;
	
	public GameKeyboardInput()
	{
		this.keys = new ArrayList<Integer>();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void 
	keyPressed(KeyEvent e) 
	{
		Integer pressedKey = e.getKeyCode();
		if (!this.keys.contains(pressedKey))
		{
			this.keys.add(pressedKey);
		}
	}

	@Override
	public void 
	keyReleased(KeyEvent e) 
	{	
		Integer releasedKey = e.getKeyCode();
		this.keys.remove(releasedKey);
	}

	public ArrayList<Integer> getKeys() { return this.keys; }
	
}
