package es.studium.Ejemplos;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

public class EjemploJuego2 extends Frame implements WindowListener, MouseListener
{
	private static final long serialVersionUID = 1L;
	// Las coordenadas del cuadrado
	int posX, posY;
	// Las coordenadas del lugar donde pulse
	int pulX, pulY;
	// Las vidas
	int vidas;
	// Los puntos
	int puntos = 0;
	// Tamaño cuadrado
	int lado;
	
	Random rnd = new Random();
	
	public EjemploJuego2()
	{
		vidas = 3;
		lado = 20;
		setTitle("Más pequeño…");
		// Obtener los valores iniciales del cuadrado
		obtenerPosicion();
		addWindowListener(this);
		addMouseListener(this);
		setSize(220,220);
		setVisible(true);
	}	

	public void obtenerPosicion()
	{
		// Obtenemos los valores teniendo en cuenta los límites del escenario
		posX = rnd.nextInt(186) + 8;
		posY = rnd.nextInt(130) + 32;
	}
	
	public void paint(Graphics g)
	{
		g.drawRect(posX, posY, lado, lado);
		g.drawString("Vidas: "+ vidas, 8, 40);
		g.drawString("Puntos: " + puntos, 150, 41);
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
		new EjemploJuego2();
	}
	
	public void mouseClicked(MouseEvent me)
	{
		// Obtenemos las coordenadas del lugar donde se ha pulsado con el ratón
		pulX = me.getX();
		pulY = me.getY();
		// Comprobamos si las coordenadas del ratón están entre las del cuadrado
		if((posX <= pulX)&&(pulX <= posX + lado)&&(posY <= pulY)&&(pulY <= posY + lado))
		{
			if(lado != 1)
			{
				lado--;
			}
			puntos++;
			// Obtenemos una nueva posición del cuadrado
			obtenerPosicion();
			
		}
		else
		{
			vidas--;
			if(vidas == 0)
			{
				// Deshabilitamos el MouseListener pues se ha acabado el juego
				this.removeMouseListener(this);
			}
		}
		repaint();
	}
	
	public void mouseEntered(MouseEvent me) {}
	public void mouseExited(MouseEvent me) {}
	public void mousePressed(MouseEvent me) {}
	public void mouseReleased(MouseEvent me) {}
}