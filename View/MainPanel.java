package View;

import javax.swing.*;
import java.awt.*;
import View.*;
import Model.Model;

public class MainPanel extends JPanel
{
	public MainPanel()
	{
			super();
			this.setPreferredSize(new Dimension(1200,775));
			this.setLayout(new GridBagLayout());
			this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	}
}
