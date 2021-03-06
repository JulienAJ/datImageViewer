package view;
import javax.swing.*;
import java.util.*;
import commonTypes.*;
import model.Model;
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
		pathField = new JTextField(5);
		pathField.setText(m.getRepertory().getAbsolutePath());
		pathField.setEditable(false);
		browseButton = new JButton("...");

		this.setBorder(BorderFactory.createTitledBorder(m.getString("repertory")));
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

	@Override
	public void update(Observable o, Object obj)
	{
		ChangeType change = (ChangeType)obj;
		Model m = (Model)o;

		if(change == ChangeType.REPERTORY)
		{
			pathField.setText(m.getRepertory().getAbsolutePath());
		}
		else if(change == ChangeType.LANGUAGE)
		{
			this.setBorder(BorderFactory.createTitledBorder(m.getString("repertory")));
		}
	}
}
