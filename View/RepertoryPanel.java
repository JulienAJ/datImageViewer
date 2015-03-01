package View;
import javax.swing.*;
import java.util.*;
import CommonTypes.*;
import Model.Model;

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
		ChangeClass changes = (ChangeClass)obj;
		Model m = (Model)o;

		if(changes.getType() == ChangeType.REPERTORY)
		{
			pathField.setText(m.getRepertory());
		}
	}
}
