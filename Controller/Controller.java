package Controller;

import Model.Model;
import View.*;
import java.awt.event.*;

public class Controller implements ActionListener
{
	private Model m;
	private MainView v;

	public Controller(Model m, MainView v)
	{
		this.m = m;
		this.v = v;
	}

	public void actionPerformed(ActionEvent e)
	{
		// e.getSource
	}
}
