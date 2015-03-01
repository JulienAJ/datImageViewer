package View;

import Model.Model;
import CommonTypes.*;
import javax.swing.*;
import java.util.Observer;
import java.awt.image.*;
import java.util.Observable;

public class ImagePanel extends JPanel implements Observer
{
	private BufferedImage image;
	private JButton next;
	private JButton previous;
	private JButton close;
	private JLabel name;

	public ImagePanel(Model m)
	{
		super();
		
		image = m.getSelectedImage();
		previous = new JButton("<");
		next = new JButton(">");
		close = new JButton("X");
		name = new JLabel();
		this.setVisible(false);
	}

	public JButton getNext() { return this.next; }

	public JButton getPrevious() { return this.previous; }

	public JButton getClose() { return this.close; }

	public void addListener(ActionListener l)
	{
		this.next.addActionListener(l);
		this.previous.addActionListener(l);
		this.close.addActionListener(l);
	}

	public void update(Observable o, Object arg)
	{
		Model m = (Model)o;
		ChangeClass changes = (ChangeClass)arg;
		
		if(changes.getType() == ChangeType.SELECTED)
		{
			if(m.getSelected() == null)
				this.setVisible(false);
			else
			{
				image = m.getSelectedImage();
				name = m.getSelected();
				this.setVisible(true);
			}
		}
	}
}

