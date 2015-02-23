package View;
import javax.swing.*;
import CommonTypes.*;
import java.io.*;

public class Thumbnail extends JPanel
{
	private java.awt.image.BufferedImage largeImg;
	private ImageIcon icon;
	private String name;
	private String path;

	public Thumbnail(String path, DisplaySize size)
	{
		super();
		this.path = path;

		int maxHeight = 0;
		int maxWidth = 0;

		if(size == DisplaySize.BIG)
		{
			maxWidth = 100;
			maxHeight = 80;
		}

		else if(size == DisplaySize.MEDIUM)
		{
			maxWidth = 80;
			maxHeight = 60;
		}

		else if(size == DisplaySize.SMALL)
		{
			maxWidth = 60;
			maxHeight = 40;
		}
		
		try
		{
			largeImg = javax.imageio.ImageIO.read(new File(path));
			icon = new ImageIcon(largeImg.getScaledInstance(maxWidth, maxHeight, java.awt.Image.SCALE_FAST));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
