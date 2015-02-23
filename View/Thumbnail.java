package View;
import javax.swing.*;

public class Thumbnail extends Jpanel
{
	public Thumbnail(DisplaySize size, String path)
	{
		int maxHeight, maxWidth;

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


	}
}
