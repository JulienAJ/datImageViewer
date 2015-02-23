package View;
import javax.swing.*;
import java.util.*;

public class TopPanel extends JPanel implements Observer
{
	JTextField pathField;
	JButton browseButton;
	JButton browseButton;

	public ImageDataPanel()
	{
		pathField = new JTextField("rechercher");
		browseButton = new JButton("Go");

		this.setBorder(BorderFactory.createTitledBorder("Bandeau"));
		this.add(pathField);
		this.add(browseButton);
	}

	public void update(Observable o, Object obj)
	{
		// TO DO
	}
}
