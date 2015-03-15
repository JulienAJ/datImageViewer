package view;

import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import commonTypes.DisplaySize;
import util.Util;

public class Thumbnail
{
	private BufferedImage original;
	private ImageIcon image;
	private String name;
	private String path;

	public Thumbnail(String path, DisplaySize size)
	{
		// DEFAULT IS BIG
		int maxWidth = 300;
		int maxHeight = 300;

		if(size == DisplaySize.MEDIUM)
		{
			maxWidth = 200;
			maxHeight = 200;
		}

		else if(size == DisplaySize.SMALL)
		{
			maxWidth = 100;
			maxHeight = 100;
		}

		this.path = path;
		Path p = Paths.get(path);
		name = Util.basename(path);

		try
		{
			original = ImageIO.read(new File(path));
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		if (original != null)
		{
			int imgWidth = original.getWidth();
			int imgHeight = original.getHeight();

			double maxRatio = (double)maxWidth / maxHeight;
			double imgRatio = (double)imgWidth / imgHeight;
			double scale = (imgRatio > maxRatio) ?  (double)maxWidth / imgWidth : (double)maxHeight / imgHeight;

			int newWidth = (int)(imgWidth * scale);
			int newHeight = (int)(imgHeight * scale);

			image = new ImageIcon(original.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_FAST));
		}
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPath()
	{
		return path;
	}

	public ImageIcon getImage()
	{
		return image;
	}
}

