package View;

import Model.Model;
import CommonTypes.*;
import javax.swing.*;
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
		searchField = new JTextField();
		searchButton = new searchButton();
	}

	public void update(Observable o, Object arg)
	{
		// ON PEUT
	}
}
