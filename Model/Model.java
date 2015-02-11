import java.util.*;

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
}
