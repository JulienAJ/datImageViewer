package Controller;

import Model.Model;
import CommonTypes.*;
import View.*;
import java.awt.event.*;
import javax.swing.*;

public class Controller implements ActionListener
{
	private Model m;
	private MainView v;

	public Controller(Model m, MainView v)
	{
		this.m = m;
		this.v = v;
		v.addListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		// MainMenu
		if(e.getSource() == v.getChangeRepertoryItem())
			v.displayChangeRepertory();

		else if(e.getSource() == v.getBigDisplayItem())
			m.setSize(DisplaySize.BIG);

		else if(e.getSource() == v.getMediumDisplayItem())
			m.setSize(DisplaySize.MEDIUM);

		else if(e.getSource() == v.getSmallDisplayItem())
			m.setSize(DisplaySize.SMALL);

		else if(e.getSource() == v.getFrenchItem())
			m.setLanguage("fr");

		else if(e.getSource() == v.getEnglishItem())
			m.setLanguage("en");

		else if(e.getSource() == v.getRussianItem())
			m.setLanguage("ru");

		// Repertory Panel
		else if(e.getSource() == v.getBrowseButton())
			v.displayChangeRepertory();
			
		// Image Data Panel
		else if(e.getSource() == v.getRenameButton())
		{
			String old = m.getSelected();
			String newN = (String)JOptionPane.showInputDialog(
					v,
					"Choose a new name\n",
					"Rename",
					JOptionPane.PLAIN_MESSAGE,
					null,
					null,
					old);
			if(newN != null && !old.equals(newN))
				m.setName(old, newN);
		}

		else if(e.getSource() == v.getTagsButton())
			v.displayTagFrame();

		// Top Bar
		else if(e.getSource() == v.getSearchButton())
			m.search(v.getSearchKey());

		else if(e.getSource() == v.getDisplayBox())
			m.setSize(v.getSelectedSize());

		// Image Panel
		else if(e.getSource() == v.getNext())
			m.nextImage();

		else if(e.getSource() == v.getPrevious())
			m.previousImage();

		else if(e.getSource() == v.getClose())
			v.closeImagePanel();

		// Browse Frame
		else if (e.getSource() == v.getChooser())
			m.setRepertory(v.getPathChooser());

		// Rename Frame

		else if(e.getSource() == v.getValidateRenameFrame())
			m.setName(m.getSelected(), v.getNewNameRenameFrame());

		else if(e.getSource() == v.getCancelRenameFrame())
			v.hideRenameFrame();
	}
}
