import java.util.*;
import CommonTypes.*; 

public class Model extends Observable
{
	String language;
	DisplaySize displaySize;
	Map<String, LinkedList<String> > imageList;
	String repertory;

	public Model()
	{
		language = null;
		displaySize = DisplaySize.BIG;
		imageList = null;
		repertory = "/";
	}

	public String getLanguage()
	{
		return this.language;
	}

	public void setLanguage(String lang)
	{
		this.language = lang;
		notifyObservers("language");
	}

	public DisplaySize getSize()
	{
		return this.displaySize;
	}

	public void setSize(DisplaySize size)
	{
		this.displaySize = size;
		notifyObservers("size");
	}

	public LinkedList<String> getTags(String name)
	{
		return imageList.get(name);
	}

	public void setTags(String name, LinkedList<String> tags)
	{
		imageList.remove(name);
		imageList.put(name, tags);
		notifyObservers("tags");
	}

	public String setName(String old, String newN)
	{
		LinkedList<String> temp = imageList.get(old);
		imageList.remove(old);
		imageList.put(newN, temp);
		notifyObservers("name");
	}

	public String getRepertory()
	{
		return repertory;
	}

	public void setRepertory(String rep)
	{
		this.repertory = rep;
		notifyObservers("repertory");
	}
}
