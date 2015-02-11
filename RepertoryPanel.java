import javax.swing.*;
import java.util.*;

public class RepertoryPanel extends JPanel implements Observer
{
	JTextField pathField;
	JButton browseButton;

	public RepertoryPanel()
	{
		pathField = new JTextField("./");
		browseButton = new JButton("...");

		this.setBorder(BorderFactory.createTitledBorder("Répertoire"));
		this.add(pathField);
		this.add(browseButton);
	}

	public void update(Observable o, Object obj)
	{
		// TO DO
	}
}
