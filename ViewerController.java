import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class ViewerController implements ItemListener
{
	private ViewerModel vm;
	private MainView mv;

	public ViewerController(ViewerModel vm, MainView mv)
	{
		this.vm = vm;
		this.mv = mv;
		mv.addItemListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		// manage event
	}
}
