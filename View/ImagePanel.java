package View;

import Model.Model;
import CommonTypes.*;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

public class ImagePanel extends JPanel implements Observer
{
	JTextField searchField;
	JButton searchButton;

	public ImagePanel()
	{
		super();
		searchField = new JTextField("hdjksfhjsdkfghsjgfjq");
		searchButton = new JButton("Test");

		this.setBorder(BorderFactory.createTitledBorder("Images"));
		this.add(searchField);
		this.add(searchButton);
	}

	public void update(Observable o, Object arg)
	{
		// ON PEUT TESTER
	}
}

