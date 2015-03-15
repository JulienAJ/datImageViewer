package view;

import model.Model;
import commonTypes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;

public class TopBar extends JPanel implements Observer
{
	private static final long serialVersionUID = -8063842433285660804L;

	JComboBox<String> displayBox;
	JComboBox<String> searchBox;
	JTextField searchField;
	JButton searchButton;
	private JButton closeSearch;

	String displayBig;
	String displayMedium;
	String displaySmall;

	String repertorySearch;
	String databaseSearch;

	public TopBar(Model m)
	{
		// SETUP
		super();
		//close
		closeSearch = new JButton("X");
		
		//display
		displayBox = new JComboBox<String>();
		searchField = new JTextField(15);
		searchButton = new JButton(m.getString("search"));
		this.setBorder(BorderFactory.createTitledBorder(m.getString("edit")));
		this.setLayout(new GridBagLayout());

		//search
		searchBox = new JComboBox<String>();

		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new GridBagLayout());

		// DISPLAY MENU
		displayBig = m.getString("big");;
		displayMedium = m.getString("medium");
		displaySmall = m.getString("small");

		displayBox.addItem(displayBig);
		displayBox.addItem(displayMedium);
		displayBox.addItem(displaySmall);

		displayBox.setSelectedItem(displayBig);

		//SEARCH MENU
		repertorySearch = m.getString("repertory");
		databaseSearch = m.getString("database");

		searchBox.addItem(repertorySearch);
		searchBox.addItem(databaseSearch);

		searchBox.setSelectedItem(databaseSearch);

		// DISPLAY
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.WEST;
		gc.weightx = 1.0;
		gc.gridx = 0;
		gc.gridy = 0;
		this.add(displayBox, gc);

		gc.anchor = GridBagConstraints.EAST;
		gc.weightx = 1.0;
		gc.gridx = 3;
		gc.gridy = 0;
		gc.gridwidth = 1;
		searchPanel.add(searchButton, gc);

		gc.anchor = GridBagConstraints.EAST;
		gc.weightx = 1.0;
		gc.gridx = 2;
		gc.gridy = 0;
		gc.gridwidth = 1;
		searchPanel.add(searchBox, gc);

		gc.anchor = GridBagConstraints.EAST;
		gc.weightx = 1.0;
		gc.gridx = 1;
		gc.gridy = 0;
		gc.gridwidth = 1;
		//gc.gridx = GridBagConstraints.RELATIVE;
		searchPanel.add(searchField, gc);

		gc.anchor = GridBagConstraints.EAST;
		gc.weightx = 1.0;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 1;
		searchPanel.add(closeSearch, gc);
		
		gc.anchor = GridBagConstraints.EAST;
		gc.weightx = 2.0;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 3;
		this.add(searchPanel, gc);

		m.addObserver(this);
	}

	public JComboBox<String> getDisplayBox() { return this.displayBox; }

	public JComboBox<String> getSearchBox() { return this.searchBox; }

	public boolean repertoryIsSelected()
	{
		String selected = (String)this.searchBox.getSelectedItem();
		if(selected != null)
		{
			if(selected.equals(repertorySearch))
				return true;
		}
		return false;
	}

	public DisplaySize getSelectedSize()
	{
		String selected = (String)this.displayBox.getSelectedItem();
		if(selected != null)
		{
			if(selected.equals(displayBig))
				return DisplaySize.BIG;
			else if(selected.equals(displayMedium))
				return DisplaySize.MEDIUM;
			else if(selected.equals(displaySmall))
				return DisplaySize.SMALL;
		}
		return DisplaySize.BIG;
	}

	public String getSearchKey() { return this.searchField.getText(); }

	public JButton getSearchButton() { return this.searchButton; }
	
	public JButton getCloseSearch() { return this.closeSearch; }

	public void addListener(ActionListener l)
	{
		this.displayBox.addActionListener(l);
		this.searchField.addActionListener(l);
		this.searchButton.addActionListener(l);
	}

	public void update(Observable o, Object arg)
	{
		ChangeType change = (ChangeType)arg;
		Model m = (Model)o;

		if(change == ChangeType.DISPLAYSIZE)
		{
			DisplaySize newSize = m.getSize();
			if(newSize == DisplaySize.BIG)
				this.displayBox.setSelectedItem(displayBig);

			else if(newSize == DisplaySize.MEDIUM)
				this.displayBox.setSelectedItem(displayMedium);

			else if(newSize == DisplaySize.SMALL)
				this.displayBox.setSelectedItem(displaySmall);
		}
		else if(change == ChangeType.LANGUAGE)
		{
			//display
			displayBig = m.getString("big");
			displayMedium = m.getString("medium");
			displaySmall = m.getString("small");
			displayBox.removeAllItems();
			displayBox.addItem(displayBig);
			displayBox.addItem(displayMedium);
			displayBox.addItem(displaySmall);
			//search
			repertorySearch = m.getString("repertory");
			databaseSearch = m.getString("database");
			searchBox.removeAllItems();
			searchBox.addItem(repertorySearch);
			searchBox.addItem(databaseSearch);
			searchButton.setText(m.getString("search"));
			this.setBorder(BorderFactory.createTitledBorder(m.getString("edit")));
		}
	}
}
