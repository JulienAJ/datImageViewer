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
		// Repertory Panel
		if(e.getSource() == v.getBrowseButton())
		{
			v.displayChangeRepertory();
		}		

		// Image Data Panel
		else if(e.getSource == v.getRenameButton())
		{
			v.displayRename();
		}

		else if(e.getSource == v.getTagsButton())
		{
			v.displayTagModif();
		}

		// Top Bar
		else if(e.getSource == v.getSearchButton())
		{
			m.search();
		}

		//ImagePanel

		else if(e.getSource == v.getNext())
		{
			m.nextImage();
		}

		else if(e.getSource == v.getPrevious())
		{
			m.previousImage();
		}

		//else if(e.getSource == v.getClose());
	}
}
