package es.studium.Ejemplos;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EjemploImagen extends Frame implements WindowListener
{
	private static final long serialVersionUID = 1L;
	// Declarar el objeto Image
	Image imagen;
	// Declarar el objeto Toolkit para manejo de imágenes
	Toolkit herramienta;
	public EjemploImagen()
	{
		setLocation(250,250);
		setSize(300,220);
		setResizable(false);
		addWindowListener(this);
		// Establecer el método de trabajo con imágenes
		herramienta = getToolkit();
		// Especificar la ruta de la imagen
		// Si ponemos ruta OJO con los \\
		imagen = herramienta.getImage("img\\imagen.jpg");
		setVisible(true); // --> repaint()-->update()-->paint()
	}
	
	public static void main(String[] args)
	{
		new EjemploImagen();
	}
	
	public void paint(Graphics g)
	{
		// Dibujar la imagen
		g.drawImage(imagen,4,23,this);
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
}
