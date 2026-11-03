package WorldInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import Principal.Config;

public class WorldInput {
	/**
		Carrega o mapa do arquivo.
	*/

	public WorldInput() {}

	public int[][]
	loadMap()
	{

		int col = 0;
		int row = 0;

		int[][] map = new int[50][50];

		try (InputStream is = getClass().getResourceAsStream(Config.WORLDS_PATH);
			 BufferedReader br = new BufferedReader(new InputStreamReader(is));)
		{

			while (col < map.length && row < map[0].length) {

				String line = br.readLine();

				while (col < map.length)
				{
					String numbers[] = line.split(" ");

					int num = Integer.parseInt(numbers[col]);

					map[col][row] = num;
					col++;

				}
				if (col == 50)
				{
					col = 0;
					row++;
				}
			}

		}
		catch (IOException e) {

			e.printStackTrace();

		}

		return map;
	}

}
