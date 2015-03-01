package View;
import javax.swing.*;
import java.util.*;
import CommonTypes.*;
import Model.Model;
import java.awt.event.*;

public class RepertoryPanel extends JPanel implements Observer
{
	JTextField pathField;
	JButton browseButton;

	public RepertoryPanel()
	{
		pathField = new JTextField("./");
		pathField.setEditable(false);
		browseButton = new JButton("...");

		this.setBorder(BorderFactory.createTitledBorder("Répertoire"));
		this.add(pathField);
		this.add(browseButton);
	}

	public JButton getBrowseButton() { return this.browseButton; }

	public void addListener(ActionListener l)
	{
		this.pathField.addActionListener(l);
		this.browseButton.addActionListener(l);
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
