package es.studium.Ejemplos;

import java.io.IOException;

public class Ayuda
{
	public static void main(String[] args)
	{
		try
		{
			Runtime.getRuntime().exec("hh.exe Segundo.chm");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
} 