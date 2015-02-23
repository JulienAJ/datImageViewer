package View;
import javax.swing.*;
import java.util.*;

public class ImageDataPanel extends JPanel implements Observer
{
	JTextField pathField;
	JButton browseButton;

	public ImageDataPanel()
	{
		super();
		pathField = new JTextField("onche");
		browseButton = new JButton("OK");

		this.setBorder(BorderFactory.createTitledBorder("Données Image"));
		this.add(pathField);
		this.add(browseButton);
	}

	public void update(Observable o, Object obj)
	{
		// TO DO
	}
}
