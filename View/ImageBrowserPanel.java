import javax.swing.*;
import Model.Model;

public class ImageBrowserPanel extends JScrollPane implements Observer
{
	private Model m;

	public ImageBrowserPanel(Model m)
	{
		super();
		this.m = m;
		m.addObserver(this);
		this->update(m, "setup");
	}

	public void update(Observable o, Object arg)
	{
		String updated = (String)arg;
		if(updated.equals("name") || updated.equals("tags") || updated.equals("repertory") || updated.equals("size"))
		{

		}
	}
}
