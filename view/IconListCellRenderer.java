package view;

import javax.swing.*;
import java.awt.*;

public class IconListCellRenderer extends JLabel implements ListCellRenderer<Thumbnail>
{
	private static final long serialVersionUID = -3419410645297544425L;

	public IconListCellRenderer()
	{
		setOpaque(true);
	}

	public Component getListCellRendererComponent(JList<? extends Thumbnail> list, Thumbnail value, int index, boolean isSelected, boolean cellHasFocus)
	{
		ImageIcon image = value.getImage();
		if(image != null)
		{
			setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight() + 20));

			setText(value.getName());
			setVerticalTextPosition(JLabel.BOTTOM);
			setHorizontalTextPosition(JLabel.CENTER);

			setIcon(value.getImage());
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
