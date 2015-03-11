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
		{
			JFileChooser chooser = new JFileChooser();
			chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = chooser.showOpenDialog(v);
			if(returnVal == JFileChooser.APPROVE_OPTION)
				m.setRepertory(chooser.getSelectedFile());
		}

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
		{
			JFileChooser chooser = new JFileChooser();
			chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = chooser.showOpenDialog(v);
			if(returnVal == JFileChooser.APPROVE_OPTION)
				m.setRepertory(chooser.getSelectedFile());
		}
			
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
		{
			String old = m.getTagsArea(m.getRepertoryPath() + m.getSelected());
			String newTags = (String)JOptionPane.showInputDialog(
					v,
					"Add, remove or edit tags\n" +
					"Use ';' as a separator",
					"Tags",
					JOptionPane.PLAIN_MESSAGE,
					null,
					null,
					old);
			if(newTags != null && !old.equals(newTags))
			{
				m.setTags(m.getSelected(), m.stringToList(newTags));
			}
		}

		// Top Bar
		else if(e.getSource() == v.getSearchButton())
			m.search(v.getSearchKey(), false);

		else if(e.getSource() == v.getDisplayBox())
			m.setSize(v.getSelectedSize());

		// Image Panel
		else if(e.getSource() == v.getNext())
			m.nextImage();

		else if(e.getSource() == v.getPrevious())
			m.previousImage();

		else if(e.getSource() == v.getClose())
			v.hideImagePanel();
	}
}
