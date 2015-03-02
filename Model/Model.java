package Model;
import java.util.*;
import java.awt.image.*;
import CommonTypes.*; 
import java.io.File;

public class Model extends Observable
{
	String language;
	DisplaySize displaySize;
	Map<String, LinkedList<String> > imageList;
	File repertory;
	String selected;
	BufferedImage selectedImage;

	public Model()
	{
		language = null;
		displaySize = DisplaySize.BIG;
		imageList = new HashMap();
		repertory = new File("/");
		selected = null;
		selectedImage = null;
	}

	public String getLanguage() { return this.language; }

	public void search(String searchKey)
	{
		Map<String, LinkedList<String> > results = new HashMap();
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
	}

	public void nextImage()
	{
		// Change selected and notify
	}
	
	public void previousImage()
	{
		// Change selected and notify
	}

	public void setLanguage(String lang)
	{
		this.language = lang;
		notifyObservers(new ChangeClass(ChangeType.LANGUAGE));
	}

	public DisplaySize getSize() { return this.displaySize; }

	public void setSize(DisplaySize size)
	{
		this.displaySize = size;
		notifyObservers(new ChangeClass(ChangeType.DISPLAYSIZE));
	}

	public LinkedList<String> getTags(String name)
	{
		return imageList.get(name);
	}

	public void setTags(String name, LinkedList<String> tags)
	{
		imageList.remove(name);
		imageList.put(name, tags);
		notifyObservers(new ChangeClass(ChangeType.IMAGETAGS, name));
	}

	public void setName(String old, String newN)
	{
		LinkedList<String> temp = imageList.get(old);
		imageList.remove(old);
		imageList.put(newN, temp);
		// TO DO change actual image name in folder
		notifyObservers(new ChangeClass(ChangeType.IMAGENAME, old));
	}

	public String getSelected() { return this.selected; }

	public void setSelected(String name, BufferedImage img)
	{
		this.selected = name;
		this.selectedImage = img;
		notifyObservers(new ChangeClass(ChangeType.SELECTED));
	}

	public File getRepertory()
	{
		return repertory;
	}

	public void setRepertory(File rep)
	{
		this.repertory = rep;
		notifyObservers(new ChangeClass(ChangeType.REPERTORY));
	}

	public BufferedImage getSelectedImage() { return this.selectedImage; }
}
