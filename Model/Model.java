package Model;
import java.util.*;
import CommonTypes.*; 

public class Model extends Observable
{
	String language;
	DisplaySize displaySize;
	Map<String, LinkedList<String> > imageList;
	String repertory;
	String selected;

	public Model()
	{
		language = null;
		displaySize = DisplaySize.BIG;
		imageList = null;
		repertory = "/";
		selected = null;
	}

	public String getLanguage() { return this.language; }

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

	public void setSelected(String name) { this.selected = name; }

	public String getRepertory()
	{
		return repertory;
	}

	public void setRepertory(String rep)
	{
		this.repertory = rep;
		notifyObservers(new ChangeClass(ChangeType.REPERTORY));
	}
}
