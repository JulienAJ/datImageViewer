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
	JTextField searchField;
	JButton searchButton;

	String displayBig;
	String displayMedium;
	String displaySmall;

	public TopBar(Model m)
	{
		// SETUP
		super();
		displayBox = new JComboBox<String>();
		searchField = new JTextField(15);
		searchButton = new JButton(m.getString("search"));
		this.setBorder(BorderFactory.createTitledBorder(m.getString("edit")));
		this.setLayout(new GridBagLayout());

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

		m.addObserver(this);
	}

	public JComboBox<String> getDisplayBox() { return this.displayBox; }

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
		else if(changes.getType() == ChangeType.LANGUAGE)
		{
			displayBig = m.getString("big");
			displayMedium = m.getString("medium");
			displaySmall = m.getString("small");
			searchButton.setText(m.getString("search"));
			this.setBorder(BorderFactory.createTitledBorder(m.getString("edit")));
			displayBox.removeAllItems();
			//displayBox.getItemAt(1).setText(m.getString("big"));
			displayBox.addItem(displayBig);
			displayBox.addItem(displayMedium);
			displayBox.addItem(displaySmall);
		}
	}
}
