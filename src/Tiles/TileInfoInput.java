package Tiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Principal.Config;

public class TileInfoInput {
	/**
		Classe que lê as informações dos tiles do arquivo de texto

		O arquivo TXT esta dividido em linhas e cada linha está dividida dessa forma:

		ID ; ignorar ; Nome do Tile ; posX ; posY
	*/

	public TileInfoInput()
	{}

	public ArrayList<String[]>
	getTilesInfo()
	{
		ArrayList<String[]> tiles = new ArrayList<>();

		try (InputStream is = getClass().getResourceAsStream(Config.TILES_INFO_PATH);
			 BufferedReader br = new BufferedReader(new InputStreamReader(is)))
		{
			String linha = "";
			while ((linha = br.readLine()) != null)
			{
				if (linha.isBlank())
				{
					continue;
				}
				tiles.add(linha.split(";"));
			}
		}
		catch (IOException e)
		{
			System.out.println("Erro ao carregar as informações dos tiles!");
			e.printStackTrace();
		}

		return tiles;
	}

}
