import javax.swing.*;
import java.util.*;

public class MainView implements Observer
{
	private ViewerModel vm;
	// contains sub views

	public MainView(ViewerModel vm)
	{
		this.vm = vm;
	}

	public void update(Observable o, Object arg)
	{
		// stuff to do when updated
	}
}
