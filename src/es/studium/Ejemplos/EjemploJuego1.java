package es.studium.Ejemplos;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EjemploJuego1 extends Frame implements WindowListener, KeyListener
{
	private static final long serialVersionUID = 1L;
	int posX, posY;
	public EjemploJuego1()
	{
		posX = 50;
		posY = 50;
		addWindowListener(this);
		addKeyListener(this);
		setTitle("Moviendo…");
		setSize(220,220);
		setVisible(true);
	}
	public void paint(Graphics g)
	{
		g.drawOval(posX, posY, 20, 20);
	}
	public void windowActivated(WindowEvent we) {}
	public void windowClosed(WindowEvent we) {}
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent we) {}
	public void windowDeiconified(WindowEvent we) {}
	public void windowIconified(WindowEvent we) {}
	public void windowOpened(WindowEvent we) {}
	public void keyPressed(KeyEvent ke)
	{
		// Pulsamos cursor izquierda
		if(ke.getKeyCode()==37)
		{
			if(posX>=9)
			{
				posX-=5;
			}
		}
		// Pulsamos cursor arriba
		if(ke.getKeyCode()==38)
		{
			if(posY>=31)
			{
				posY-=5;
			}
		}
		// Pulsamos cursor derecha
		if(ke.getKeyCode()==39)
		{
			if(posX<=190)
			{
				posX+=5;
			}
		}
		// Pulsamos cursor abajo
		if(ke.getKeyCode()==40)
		{
			if(posY<=190)
			{
				posY+=5;
			}
		}
		repaint();
	}
	public void keyReleased(KeyEvent ke) {}
	public void keyTyped(KeyEvent ke) {}
	public static void main(String[] args)
	{
		new EjemploJuego1();
	}
}