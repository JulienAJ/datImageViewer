package View;

import Model.Model;
import CommonTypes.*;
import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class TopBar extends JPanel implements Observer
{
	JComboBox displayBox;
	JTextField searchField;
	JButton searchButton;

	public TopBar()
	{
		super();
		displayBox = new JComboBox();
		searchField = new JTextField(15);
		searchButton = new JButton("Rechercher");

		this.setBorder(BorderFactory.createTitledBorder("TRUC"));
		this.setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.WEST;
		gc.weightx = 0.5;
		gc.gridx = 0;
		gc.gridy = 0;
		this.add(displayBox, gc);

		gc.anchor = GridBagConstraints.EAST;
		//gc.weightx = 0.25;
		gc.gridx = 1;
		gc.gridy = 0;
		//gc.gridwidth = 1;
		this.add(searchField, gc);
		//gc.anchor = GridBagConstraints.WEST;
		gc.gridx = GridBagConstraints.RELATIVE;
		this.add(searchButton, gc);
	}

	public void update(Observable o, Object arg)
	{
		// ON PEUT FUTER
	}
}
