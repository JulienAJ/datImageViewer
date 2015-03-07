package View;

import Model.Model;
import CommonTypes.*;
import javax.swing.*;
import java.util.Observer;
import java.awt.image.*;
import java.awt.event.*;
import java.util.Observable;

public class ImagePanel extends JPanel implements Observer
{
	private static final long serialVersionUID = 5810558813893534136L;

	private BufferedImage image;
	private JButton next;
	private JButton previous;
	private JButton close;
	private JLabel name;

	public ImagePanel(Model m)
	{
		super();
		this.setBorder(BorderFactory.createTitledBorder("Images"));
		image = m.getSelectedImage();
		previous = new JButton("<");
		next = new JButton(">");
		close = new JButton("X");
		name = new JLabel();
		this.setVisible(false);

		m.addObserver(this);
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
				name.setText(m.getSelected());
				this.setVisible(true);
			}
		}
	}
}

