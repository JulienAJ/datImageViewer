package View;

import Model.Model;
import CommonTypes.*;
import javax.swing.*;
import java.util.Observer;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.util.Observable;

public class ImagePanel extends JPanel implements Observer
{
	private static final long serialVersionUID = 5810558813893534136L;

	private BufferedImage image;
	private JLabel imageLabel;
	private JButton next;
	private JButton previous;
	private JButton close;
	private JLabel name;

	public ImagePanel(Model m)
	{
		super();
		this.setBorder(BorderFactory.createTitledBorder(m.getString("images")));
		this.setLayout(new BorderLayout());
		image = m.getSelectedImage();
		if(image != null)
			imageLabel = new JLabel(new ImageIcon(image));

		previous = new JButton("<");
		next = new JButton(">");
		close = new JButton("X");
		name = new JLabel();
		name.setText(m.getSelected());
		//this.setVisible(false);

		this.add(name, BorderLayout.SOUTH);
		JPanel left = new JPanel(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		left.add(close, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weighty = 3.0;
		left.add(previous,gc);
		this.add(left, BorderLayout.WEST);
		
		JPanel right = new JPanel(new GridBagLayout());
		right.add(next);
		this.add(right, BorderLayout.EAST);
		
		//JPanel top = new JPanel(new GridBagLayout());
		//GridBagConstraints gc = new GridBagConstraints();
		/*gc.weightx = 1;
		gc.anchor = GridBagConstraints.WEST;
		top.add(close, gc);
		this.add(top, BorderLayout.NORTH);*/
		
		//this.add(imageLabel, BorderLayout.CENTER);
		
		m.addObserver(this);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(image != null)
		{
			int x, y, width, height, maxWidth, maxHeight, scale;
			maxWidth = getWidth();
			maxHeight = getHeight();
			width = image.getWidth();
			height = image.getHeight();
			scale = width/height;
			x = maxWidth / 4; // On place l'image au milieu
			y = 7;
			if (x*2 > width || maxHeight > height)
			{
				x = maxWidth /4 + width;
				y = maxHeight /4;
				g.drawImage(image, x, y, width, height, this);
			}
			else
			{
				g.drawImage(image, x, y, x*2, maxHeight, this);
			}
		}
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

	@Override
	public void update(Observable o, Object arg)
	{
		Model m = (Model)o;
		ChangeClass changes = (ChangeClass)arg;
		
		if(changes.getType() == ChangeType.SELECTED
				|| changes.getType() == ChangeType.IMAGENAME)
		{
			if(m.getSelected() == null)
				this.setVisible(false);
			else
			{
				image = m.getSelectedImage();
				imageLabel = new JLabel(new ImageIcon(image));
				repaint();
				name.setText(m.getSelected());
				this.setVisible(true);
			}
		}
		else if(changes.getType() == ChangeType.LANGUAGE)
		{
			this.setBorder(BorderFactory.createTitledBorder(m.getString("images")));
		}
	}
}

