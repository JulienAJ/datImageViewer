package View;

import Model.Model;
import CommonTypes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;

public class TopBar extends JPanel implements Observer
{
	JComboBox displayBox;
	JTextField searchField;
	JButton searchButton;

	String displayBig;
	String displayMedium;
	String displaySmall;

	public TopBar()
	{
		// SETUP
		super();
		displayBox = new JComboBox();
		searchField = new JTextField(15);
		searchButton = new JButton("Rechercher");
		this.setBorder(BorderFactory.createTitledBorder("TRUC"));
		this.setLayout(new GridBagLayout());

		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new GridBagLayout());

		// DISPLAY MENU
		displayBig = "Grand";
		displayMedium = "Moyen";
		displaySmall = "Petit";

		displayBox.addItem(displayBig);
		displayBox.addItem(displayMedium);
		displayBox.addItem(displaySmall);

		displayBox.setSelectedItem(displayBig);

		// DISPLAY
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.WEST;
		gc.weightx = 1.0;
		gc.gridx = 0;
		gc.gridy = 0;
		this.add(displayBox, gc);

		gc.anchor = GridBagConstraints.EAST;
		gc.weightx = 1.0;
		gc.gridx = 1;
		gc.gridy = 0;
		gc.gridwidth = 1;
		searchPanel.add(searchButton, gc);

		gc.anchor = GridBagConstraints.EAST;
		gc.weightx = 1.0;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 1;
		//gc.gridx = GridBagConstraints.RELATIVE;
		searchPanel.add(searchField, gc);

		gc.anchor = GridBagConstraints.EAST;
		gc.weightx = 2.0;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 3;
		this.add(searchPanel, gc);
	}

	public JComboBox getDisplayBox() { return this.displayBox; }

	public String getSelectedLanguage() { return (String)this.displayBox.getSelectedItem(); }

	public String getSearchKey() { return this.searchField.getText(); }

	public JButton getSearchButton() { return this.searchButton; }

	public void addListener(ActionListener l)
	{
		this.displayBox.addActionListener(l);
		this.searchField.addActionListener(l);
		this.searchButton.addActionListener(l);
	}

	public void update(Observable o, Object arg)
	{
		ChangeClass changes = (ChangeClass)arg;
		Model m = (Model)o;

		if(changes.getType() == ChangeType.DISPLAYSIZE)
		{
			DisplaySize newSize = m.getSize();
			if(newSize == DisplaySize.BIG)
				this.displayBox.setSelectedItem(displayBig);

			else if(newSize == DisplaySize.MEDIUM)
				this.displayBox.setSelectedItem(displayMedium);

			else if(newSize == DisplaySize.SMALL)
				this.displayBox.setSelectedItem(displaySmall);
		}
	}
}
