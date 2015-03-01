package View;
import javax.swing.*;
import java.util.*;

public class ImageDataPanel extends JPanel implements Observer
{
	JTextField imageName;
	JButton rename;
	JList<String> tags;
	JButton editTags;
	boolean selected = false;

	public ImageDataPanel()
	{
		super();
	}

	public void update(Observable o, Object obj)
	{
		// TO DO
	}
}
