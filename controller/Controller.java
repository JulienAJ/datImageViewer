package controller;

import model.Model;
import commonTypes.*;
import view.*;
import util.Util;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Controller implements ActionListener, ListSelectionListener
{
	private Model m;
	private MainView v;

	public Controller(Model m, MainView v)
	{
		this.m = m;
		this.v = v;
		v.addListener(this);
		v.addListListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		Thumbnail t = v.getImageList().getSelectedValue();
		if(t != null)
		{
			m.setSelected(t.getPath());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// MainMenu
		if(e.getSource() == v.getChangeRepertoryItem())
			changeRep();

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

		else if(e.getSource() == v.getChineseItem())
			m.setLanguage("ru");

		// Repertory Panel
		else if(e.getSource() == v.getBrowseButton())
			changeRep();

		// Image Data Panel
		else if(e.getSource() == v.getRenameButton())
		{
			String old = Util.basename(m.getSelected());
			String newN = (String)JOptionPane.showInputDialog(
					v,
					"Choose a new name\n",
					"Rename",
					JOptionPane.PLAIN_MESSAGE,
					null,
					null,
					old);
			if(newN != null)
			{
				newN = Util.basename(newN);
				if(!old.equals(newN))
				{
					String path = Util.repFromImg(m.getSelected());
					m.setName(path + old, path + newN);
				}
			}
		}

		else if(e.getSource() == v.getTagsButton())
		{
			String old = Util.listToString(m.getTags(m.getSelected()));
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
				m.setTags(m.getSelected(), Util.stringToList(newTags));
			}
		}

		// Top Bar
		else if(e.getSource() == v.getSearchButton())
			m.search(v.getSearchKey(), v.repertorySearch());

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

	private void changeRep()
	{
		JFileChooser chooser = new JFileChooser();
		chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = chooser.showOpenDialog(v);
		if(returnVal == JFileChooser.APPROVE_OPTION)
		{
			m.setRepertory(chooser.getSelectedFile());
			m.setSelected(null, null);
			m.setSearch(false);
			v.hideImagePanel();
		}
	}
}
