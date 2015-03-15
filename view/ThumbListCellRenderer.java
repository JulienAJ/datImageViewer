package view;

import javax.swing.*;
import java.awt.*;

public class ThumbListCellRenderer extends JLabel implements ListCellRenderer<Thumbnail>
{
	private static final long serialVersionUID = -3419410645297544425L;

	public ThumbListCellRenderer()
	{
		setOpaque(true);
	}

	public Component getListCellRendererComponent(JList<? extends Thumbnail> list, Thumbnail thumb, int index, boolean isSelected, boolean cellHasFocus)
	{
		ImageIcon image = thumb.getImage();
		if(image != null)
		{
			setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight() + 20));

			setText(thumb.getName());
			setVerticalTextPosition(JLabel.BOTTOM);
			setHorizontalTextPosition(JLabel.CENTER);

			setIcon(thumb.getImage());
			setHorizontalAlignment(JLabel.CENTER);

			if(isSelected)
			{
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			}
			else
			{
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}
		}

		return this;
	}
}
