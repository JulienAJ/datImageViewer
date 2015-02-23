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
		//this.m = m;
		//m.addObserver(this);
		this.update(m, "setup");
	}

	public void update(Observable o, Object arg)
	{
		String updated = (String)arg;
		m = (Model)o;
		if(updated.equals("name") || updated.equals("tags") || updated.equals("repertory") || updated.equals("size") || updated.equals("setup"))
		{
			//String rpt = m.getRepertory();
			String rpt = "/home/julien/img";
			if(rpt == null)
			{
				this.add(new JTextField("Veuillez sélectionner un répertoire"));
			}

			else
			{
				//DisplaySize size = m.getSize();
				DisplaySize size = DisplaySize.BIG;
				File repertory = new File(rpt);
				File[] files = repertory.listFiles();
				//if(files == null)
				//	return null; // THROW SMTHG

				for(File f : files)
				{
					try
					{
						Thumbnail thumb = new Thumbnail(f.getAbsolutePath(), size);
						thumbs.add(thumb);
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
			}
		}
	}
}
