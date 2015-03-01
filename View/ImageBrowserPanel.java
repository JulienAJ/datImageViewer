package View;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;
import Model.Model;
import CommonTypes.*;
import java.io.*;

public class ImageBrowserPanel extends JScrollPane implements Observer
{
	private Model m;
	private JList<Thumbnail> thumbs;

	//public ImageBrowserPanel(Model m)
	public ImageBrowserPanel()
	{
		super();
	}

	public void update(Observable o, Object arg)
	{
	}
}
