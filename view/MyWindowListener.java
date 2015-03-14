package view;
import java.awt.*;
import model.DatabaseHandler;
import java.awt.event.*;


public class MyWindowListener implements WindowListener
{
	public void windowClosing(WindowEvent e)
	{
		DatabaseHandler.closeConnection();
		System.exit(0);
	}

	public void windowClosed(WindowEvent e)
	{}

	public void windowOpened(WindowEvent e)
	{}

	public void windowIconified(WindowEvent e)
	{}

	public void windowDeiconified(WindowEvent e)
	{}

	public void windowActivated(WindowEvent e)
	{}

	public void windowDeactivated(WindowEvent e)
	{}
}
