package View;
import javax.swing.*;
import java.util.*;
import CommonTypes.*;
import Model.Model;
import java.awt.event.*;
import java.awt.*;

public class RepertoryPanel extends JPanel implements Observer
{
	private static final long serialVersionUID = 5333598550833277804L;

	JTextField pathField;
	JButton browseButton;

	public RepertoryPanel(Model m)
	{
		this.setLayout(new GridBagLayout());
		// GET REPERTORY
		pathField = new JTextField(5);
		pathField.setText("./");
		pathField.setEditable(false);
		browseButton = new JButton("...");

		this.setBorder(BorderFactory.createTitledBorder("Répertoire"));
		this.add(pathField);
		this.add(browseButton);

		m.addObserver(this);
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
			//pathField.setText(m.getRepertory());
		}
	}
}
