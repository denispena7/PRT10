package es.studium.Ejemplos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ArchivosMp3
{
	public static void main(String[] args)
	{
		try
		{
			Player apl = new Player(new FileInputStream("CHROMALUME I_ Adagio for Strings and Singers (Samuel Barber)_QUpufizcr7M.mp3"));
			apl.play();
		}
		catch(FileNotFoundException | JavaLayerException ex)
		{}
	}
}