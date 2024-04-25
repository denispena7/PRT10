package es.studium.Ejercicios;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import es.studium.Ejemplos.Rectangulo;

public class Ejercicio2 extends Frame implements WindowListener
{
	private static final long serialVersionUID = 1L;
	public Ejercicio2()
	{
		setTitle("Dibujando");
		addWindowListener(this);
		setSize(200,100);
		setVisible(true); // --> repaint()-->update()-->paint()
	}
	
	public void paint(Graphics g)
	{
		g.drawRect(50, 50, 50, 20);
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
	public static void main(String[] args)
	{
		new Rectangulo();
	}
}