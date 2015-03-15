package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import commonTypes.*;
import util.Util;

public class Model extends Observable
{
	ResourceBundle rb;
	Locale language;
	DisplaySize displaySize;
	File repertory;
	Map<String, List<String> > imageList;
	Map<String, List<String> > results;
	String selected;
	BufferedImage selectedImage;
	boolean isSearch;

	public Model()
	{
		language = Locale.FRENCH;
		rb = ResourceBundle.getBundle("ressources.strings", this.language);
		displaySize = DisplaySize.BIG;
		repertory = new File(System.getProperty("user.home"));
		setImageList();
		results = null;
		selected = null;
		selectedImage = null;
		isSearch = false;
		loadImage();
	}

	// Language
	public String getLanguage()
	{
		if(this.language == Locale.FRENCH)
			return "fr";
		if(this.language == Locale.ENGLISH)
			return "en";
		if(this.language == Locale.CHINESE)
			return "ch";

		return "ch";
	}

	public void setLanguage(String lang)
	{
		if(lang.equals("fr"))
			this.language = Locale.FRENCH;
		if(lang.equals("en"))
			this.language = Locale.ENGLISH;
		if(lang.equals("ch"))
			this.language = Locale.CHINESE;

		rb = ResourceBundle.getBundle("ressources.strings", this.language);
		setChanged();
		notifyObservers(ChangeType.LANGUAGE);
	}

	public String getString(String key)
	{
		try
		{
			return new String(rb.getString(key).getBytes("ISO-8859-1"), "UTF-8");
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
			return "Error";
		}
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
		notifyObservers(ChangeType.DISPLAYSIZE);
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
		notifyObservers(ChangeType.REPERTORY);
	}

	// Image List
	private void setImageList()
	{
		if(imageList == null)
			imageList = new HashMap<String, List<String> >();
		else
			imageList.clear();
		File[] files = repertory.listFiles();
		for(File file : files)
		{
			if(Util.isImage(file))
			{
				String imagePath = file.getAbsolutePath();
				String tagsString = DatabaseHandler.getTags(imagePath);
				List<String> tags = Util.stringToList(tagsString);
				imageList.put(imagePath, tags);
			}
		}
	}

	public Map<String, List<String> > getImageMap()
	{
		return this.imageList;
	}

	public Map<String, List<String> > getSearchResults()
	{
		return this.results;
	}

	// Name
	public void setName(String old, String newN)
	{
		List<String> temp = imageList.get(old);
		imageList.remove(old);
		imageList.put(newN, temp);
		File file = new File(old);
		file.renameTo(new File(newN));
		DatabaseHandler.changePath(old, newN);
		setSelected(newN);

		setChanged();
		notifyObservers(ChangeType.IMAGENAME);
	}

	// Tags
	public List<String> getTags(String name)
	{
		return imageList.get(name);
	}

	public void setTags(String name, List<String> tags)
	{
		imageList.remove(name);
		imageList.put(name, tags);
		DatabaseHandler.setTags(name, Util.listToString(tags));
		setChanged();
		notifyObservers(ChangeType.IMAGETAGS);
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
		notifyObservers(ChangeType.SELECTED);
	}

	public void setSelected(String name)
	{
		this.selected = name;
		loadImage();
		setChanged();
		notifyObservers(ChangeType.SELECTED);
	}

	// Actions
	public void search(String searchKey, boolean dirSearch)
	{
		results = new HashMap<String, List<String> >();
		if(searchKey.equals(""))
		{
			for(String key : imageList.keySet())
			{

				List<String> list = imageList.get(key);
				if(list != null)
				{
					int size = list.size();
					for(int i = 0; i < size; ++i)
					{
							results.put(key, list);
							break;
					}
				}
			}
		}
		else
		{
			if(dirSearch)
			{
				for(String key : imageList.keySet())
				{
					List<String> list = imageList.get(key);
					if(list != null)
					{
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
				}
			}
			else
			{
				Map<String, String> dbResults = DatabaseHandler.search(searchKey);
				for(String key : dbResults.keySet())
				{
					results.put(key, Util.stringToList(dbResults.get(key)));
				}
			}
			this.isSearch = true;
			setSelected(null);
			setChanged();
			notifyObservers(ChangeType.SEARCH);
		}
	}

	public void nextImage()
	{
		Set<String> keySet;
		if(isSearch)
			keySet = results.keySet();
		else
			keySet = imageList.keySet();
		String[] keys = (keySet.toArray(new String[keySet.size()]));
		int size = keys.length;
		for(int i = 0; i < size; ++i)
		{
			if(keys[i].equals(this.selected))
			{
				if(i == (size - 1))
					setSelected(keys[0]);
				else
					setSelected(keys[i + 1]);
				break;
			}
		}
	}

	public void previousImage()
	{
		Set<String> keySet;
		if(isSearch)
			keySet = results.keySet();
		else
			keySet = imageList.keySet();
		String[] keys = (keySet.toArray(new String[keySet.size()]));
		int size = keys.length;
		for(int i = 0; i < size; ++i)
		{
			if(keys[i].equals(this.selected))
			{
				if(i == 0)
					setSelected(keys[size - 1]);
				else
					setSelected(keys[i - 1]);
				break;
			}
		}
	}

	private void loadImage()
	{
		if(selected == null)
			return;

		try
		{
			selectedImage = ImageIO.read(new File(this.selected));
		}
		catch(IOException e)
		{
			System.err.println(e.getMessage());
		}
	}

	// searchStatus
	public boolean isSearch() { return this.isSearch; }
	public void setSearch(boolean s)
	{
		this.isSearch = s;
		setChanged();
		notifyObservers(ChangeType.REPERTORY);
	}
}
