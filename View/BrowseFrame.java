package View;

import Model.Model;
import CommonTypes.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BrowseFrame extends JFrame
{
	JFileChooser chooser;
	File path;

	public BrowseFrame()
	{
		super();
		chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = chooser.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION)
			path = chooser.getSelectedFile();
	}

	public void addListener(ActionListener l)
	{
		chooser.addActionListener(l);
	}

	public JFileChooser getChooser()
	{
		return this.chooser;
	}

	public File getPath()
	{
		return this.path;
	}
}
