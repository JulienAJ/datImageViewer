package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import CommonTypes.*;

public class Model extends Observable
{
	Locale language;
	DisplaySize displaySize;
	File repertory;
	Map<String, List<String> > imageList;
	Map<String, List<String> > results;
	String selected;
	BufferedImage selectedImage;

	public Model()
	{
		language = Locale.FRENCH;
		displaySize = DisplaySize.BIG;
		repertory = new File("/");
		setImageList();
		results = null;
		selected = null;
		selectedImage = null;
	}

	// Language
	public String getLanguage()
	{
		if(this.language == Locale.FRENCH)
			return "fr";
		if(this.language == Locale.ENGLISH)
			return "en";
		if(this.language == Locale.CHINESE)
			return "ru";

		return "fr";
	}

	public void setLanguage(String lang)
	{
		if(lang.equals("fr"))
			this.language = Locale.FRENCH;
		if(lang.equals("en"))
			this.language = Locale.ENGLISH;
		if(lang.equals("ru"))
			this.language = Locale.CHINESE;

		setChanged();
		notifyObservers(new ChangeClass(ChangeType.LANGUAGE));
	}

	// Size
	public DisplaySize getSize()
	{
		return this.displaySize;
	}

	public void setSize(DisplaySize size)
	{
		this.displaySize = size;
		setChanged();
		notifyObservers(new ChangeClass(ChangeType.DISPLAYSIZE));
	}

	// Repertory
	public File getRepertory()
	{
		return repertory;
	}

	public void setRepertory(File rep)
	{
		this.repertory = rep;
		setImageList();
		setChanged();
		notifyObservers(new ChangeClass(ChangeType.REPERTORY));
	}

	// Image List
	private void setImageList()
	{
		File[] files = repertory.listFiles();
		for(File file : files)
		{
			if(isImage(file))
			{
				String imagePath = file.getAbsolutePath();
				List<String> tags = DatabaseHandler.getTags(imagePath);
				imageList.put(imagePath, tags);
			}
		}
	}

	private boolean isImage(File f)
	{
		String fpath = f.getAbsolutePath();
		int dot = fpath.lastIndexOf('.');
		String extension = fpath.substring(dot + 1).toLowerCase();
		if(extension.equals("jpg") || extension.equals("jpeg")
				|| extension.equals("gif") || extension.equals("bmp")
				|| extension.equals("png"))
		{
			return true;
		}
		return false;
	}

	// Name
	public void setName(String old, String newN)
	{
		List<String> temp = imageList.get(old);
		imageList.remove(old);
		imageList.put(newN, temp);
		String repertoryPath = repertory.getAbsolutePath() + "/";
		File file = new File(repertoryPath + old);
		file.renameTo(new File(repertoryPath + newN));
		DatabaseHandler.changePath(repertoryPath + old, repertoryPath + newN);
		setChanged();
		notifyObservers(new ChangeClass(ChangeType.IMAGENAME, old));
	}

	// Tags
	public List<String> getTags(String name)
	{
		return imageList.get(name);
	}

	public String getTagsArea(String name)
	{
		if(imageList == null || imageList.get(name) == null)
			return "";

		return listToString(imageList.get(name));
	}

	public void setTags(String name, List<String> tags)
	{
		imageList.remove(name);
		imageList.put(name, tags);
		DatabaseHandler.setTags(this.repertory.getAbsolutePath() + "/"  + name, tags);
		setChanged();
		notifyObservers(new ChangeClass(ChangeType.IMAGETAGS, name));
	}

	// Selected
	public String getSelected()
	{
		return this.selected;
	}

	public BufferedImage getSelectedImage()
	{
		return this.selectedImage;
	}

	public void setSelected(String name, BufferedImage img)
	{
		this.selected = name;
		this.selectedImage = img;
		setChanged();
		notifyObservers(new ChangeClass(ChangeType.SELECTED));
	}

	public void setSelected(String name)
	{
		this.selected = name;
		loadImage();
		setChanged();
		notifyObservers(new ChangeClass(ChangeType.SELECTED));
	}

	// Actions
	public void search(String searchKey)
	{
		results = new HashMap();
		for(String key : imageList.keySet())
		{
			List<String> list = imageList.get(key);
			int size = list.size();
			for(int i = 0; i < size; ++i)
			{
				if(list.get(i).equals(searchKey))
				{
					results.put(key, list);
					break;
				}
			}
		}
		setChanged();
		notifyObservers(new ChangeClass(ChangeType.SEARCH));
	}

	public void nextImage()
	{
		String[] keys = (String[])(imageList.keySet().toArray());
		int size = keys.length;
		for(int i = 0; i < size; ++i)
		{
			if(keys[i].equals(this.selected))
			{
				if(i == (size - 1))
					selected = keys[0];
				else
					selected = keys[i + 1];
				break;
			}
		}
		loadImage();
		setChanged();
		notifyObservers(new ChangeClass(ChangeType.SEARCH));
	}

	public void previousImage()
	{
		String[] keys = (String[])(imageList.keySet().toArray());
		int size = keys.length;
		for(int i = 0; i < size; ++i)
		{
			if(keys[i].equals(this.selected))
			{
				if(i == 0)
					selected = keys[size - 1];
				else
					selected = keys[i - 1];
				break;
			}
		}
		loadImage();
		setChanged();
		notifyObservers(new ChangeClass(ChangeType.SEARCH));
	}

	private void loadImage()
	{
		try
		{
			selectedImage = ImageIO.read(new File(this.repertory.getAbsolutePath() + '/' + this.selected));
		}
		catch(IOException e)
		{
			System.err.println(e.getMessage());
		}
	}

	public String listToString(List<String> list)
	{
		String result = null;
		int size = list.size();
		for(int i = 0; i < size; ++i)
		{
			if(result == null)
				result = list.get(i);

			else
				result = result + ';' + (list.get(i));
		}
		return result;
	}
}
