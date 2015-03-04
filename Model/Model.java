package Model;
import java.util.*;
import java.awt.image.*;
import CommonTypes.*;
import java.io.File;

public class Model extends Observable
{
	String language;
	DisplaySize displaySize;
	File repertory;
	Map<String, LinkedList<String> > imageList;
	Map<String, LinkedList<String> > results;
	String selected;
	BufferedImage selectedImage;

	public Model()
	{
		//get locale
		language = "fr";
		displaySize = DisplaySize.BIG;
		repertory = new File("/");
		imageList = new HashMap();
		selected = null;
		selectedImage = null;
	}

	// Language
	public String getLanguage() { return this.language; }

	public void setLanguage(String lang)
	{
		this.language = lang;
		notifyObservers(new ChangeClass(ChangeType.LANGUAGE));
	}

	// Size
	public DisplaySize getSize() { return this.displaySize; }

	public void setSize(DisplaySize size)
	{
		this.displaySize = size;
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
		notifyObservers(new ChangeClass(ChangeType.REPERTORY));
	}

	// Name
	public void setName(String old, String newN)
	{
		LinkedList<String> temp = imageList.get(old);
		imageList.remove(old);
		imageList.put(newN, temp);
		// TO DO change actual image name in folder
		notifyObservers(new ChangeClass(ChangeType.IMAGENAME, old));
	}

	// Tags
	public LinkedList<String> getTags(String name)
	{
		return imageList.get(name);
	}

	public String getTagsArea(String name)
	{
		if(imageList == null || imageList.get(name) == null)
			return "";

		String result = null;
		LinkedList<String> tags = imageList.get(name);
		int size = tags.size();
		for(int i = 0; i < size; ++i)
		{
			if(result == null)
				result = tags.get(i);
			
			else
				result = result + ';' + (tags.get(i));
		}
		return result;
	}

	public void setTags(String name, LinkedList<String> tags)
	{
		imageList.remove(name);
		imageList.put(name, tags);
		notifyObservers(new ChangeClass(ChangeType.IMAGETAGS, name));
	}

	// Selected
	public String getSelected() { return this.selected; }

	public BufferedImage getSelectedImage() { return this.selectedImage; }

	public void setSelected(String name, BufferedImage img)
	{
		this.selected = name;
		this.selectedImage = img;
		notifyObservers(new ChangeClass(ChangeType.SELECTED));
	}

	// Actions
	public void search(String searchKey)
	{
		results = new HashMap();
		for(String key : imageList.keySet())
		{
			LinkedList<String> list = imageList.get(key);
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
		notifyObservers(new ChangeClass(ChangeType.SEARCH));
	}

	public void nextImage()
	{
		// Change selected and notify
	}
	
	public void previousImage()
	{
		// Change selected and notify
	}
}
