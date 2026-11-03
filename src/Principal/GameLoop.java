package Principal;

import PlayerInput.GameKeyboardInput;
import Principal.Managers.CommandManager;
import Principal.Managers.EntityManager;
import Principal.Managers.InputManager;
import Principal.Managers.PlayerManager;
import Principal.Managers.TileManager;
import Principal.Managers.WorldManager;
import Principal.Window.GamePanel;
import Principal.Window.GameWindow;
import Tiles.TileInfoInput;
import Tiles.TileSpriteInput;
import WorldInput.WorldInput;

public class GameLoop {
	/**
	 	Principal classe do projeto, onde todos os recursos do
	 	jogo são gerenciados e onde o GameLoop é implementado.
	*/

// CONSTANTES
	private final byte FPS = 60;
	private final byte UPS = 120;
	private final double NANOSEG = 1000000000.0;

// OBJETOS
	private Thread gameThread;	// Thread onde roda o gameloop

	// window
	private GamePanel panel;
	private GameWindow window;

	// Managers
	private InputManager inputM;
	private PlayerManager playerM;
	private EntityManager entityM;
	private CommandManager commandM;
	private TileManager tileM;
	private WorldManager worldM;

	// Inputs
	private GameKeyboardInput keyboardI;
	private TileInfoInput tileInfoI;
	private TileSpriteInput tileSpriteI;
	private WorldInput worldI;

// VARIAVEIS
	private boolean running = false;

	public GameLoop()
	{
		// Inputs
		this.keyboardI = new GameKeyboardInput();
		this.tileInfoI = new TileInfoInput();
		this.tileSpriteI = new TileSpriteInput();
		this.worldI = new WorldInput();

		// Managers
		this.inputM = new InputManager(this.keyboardI);
		this.playerM = new PlayerManager();
		this.entityM = new EntityManager();
		this.commandM = new CommandManager(this.inputM, this.playerM);
		this.tileM = new TileManager(this.tileInfoI, this.tileSpriteI);
		this.worldM = new WorldManager(this.tileM, this.worldI, this.playerM);

		// window
		this.panel = new GamePanel(this.worldM, this.playerM, this.entityM, this.keyboardI);
		this.window = new GameWindow(this.panel);

		this.startGameLoop();
	}

	private void
	startGameLoop()
	{
		// Iniciamos a nova thread enviando o método
		// que será executado dentro do runnable utilizando
		// uma ArrowFunction ou Expressão Lambda
		this.gameThread = new Thread(() -> gameLoop());
		this.running = true;
		this.gameThread.start();
	}

	private void
	gameLoop()
	{
		/**
			Método responsável pelo gameloop
		*/
		double deltaTimeFPS = this.NANOSEG / this.FPS;	// Taxa de atualização de quadros
		double deltaTimeUPS = this.NANOSEG / this.UPS;	// Taxa de atualização da lógica

		long timePassedF = 0;
		long timePassedU = 0;
		long actualTime = 0;
		long lastFrame = System.nanoTime();
		long lastUpdate = System.nanoTime();

		long nextEvent = 0;
		long timeRemaining = 0;


	// GAMELOOP
		while (this.running)
		{
			actualTime = System.nanoTime();
			timePassedF = actualTime - lastFrame;
			timePassedU = actualTime - lastUpdate;

			// Atualiza a lógica
			if (timePassedU >= deltaTimeUPS)
			{
				this.update();					// Atualiza a lógica do jogo
				lastUpdate += deltaTimeUPS;
			}

			// Repinta a tela
			if (timePassedF >= deltaTimeFPS)
			{
				this.panel.repaint();
				lastFrame += deltaTimeFPS;
			}

			nextEvent = (long) Math.min(lastUpdate + deltaTimeUPS, lastFrame + deltaTimeFPS);
			timeRemaining = nextEvent - System.nanoTime();

			if (timeRemaining >= 2000000)
			{
				try
				{
					Thread.sleep(timeRemaining / 1000000 - 1);
				}
				catch (InterruptedException e)
				{
					System.out.println("A thread não conseguiu dormir! " + e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}

	private void
	update()
	{
		/**
			Método que atualiza a lógica de movimentação do jogador
			e a inteligência artificial dos inimigos.
		*/

		// ENTRADAS DO JOGADOR
		this.commandM.playerInputUpdate();

		// CÉREBRO DO PLAYER
		this.playerM.getPlayer().updatePlayerLogic();

		// IA de entidades
		//this.entityM.updateEntities();
	}

}
