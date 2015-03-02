package View;

import Model.Model;
import CommonTypes.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.io.*;
import java.awt.*;
import java.util.*;

public class BrowseFrame extends JFrame implements Observer
{
	private JTree tree;
	private FileSystemModel fileSystemModel;
	private JButton validate;
	private JButton cancel;
	private File path;

	public BrowseFrame(Model m)
	{
		super("Ouvrir");
		this.fileSystemModel = new FileSystemModel(new File("/"));
		this.tree = new JTree(fileSystemModel);
		this.tree.setEditable(true);
		this.validate = new JButton("Valider");
		this.cancel = new JButton("Annuler");
		this.path = m.getRepertory();

		this.setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 2;
		gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.NORTH;
		JScrollPane scroll = new JScrollPane(tree);
		//scroll.add(tree);
		this.add(scroll, gc);

		gc.weightx = 1;
		gc.gridwidth = 1;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.SOUTH;
		this.add(cancel, gc);
		gc.gridx = 1;
		this.add(validate, gc);

		this.setVisible(true);
		this.setSize(new Dimension(300, 300));
		this.pack();
	}

	//public void show() { this.setVisible(true); }

	//public void hide() { this.setVisible(false); }

	public File getPath()
	{ 
		File file = (File) tree.getLastSelectedPathComponent();
		return file;
	}

	public JButton getValidate() { return this.validate; }
	
	public JButton getCancel() { return this.cancel; }

	public void update(Observable o, Object arg)
	{
		Model m = (Model)o;
		ChangeClass changes = (ChangeClass)arg;

		// CHANGE SELECTED DIR
	}
}

class FileSystemModel implements TreeModel
{
	private File root;
	private Vector listeners = new Vector();

	public FileSystemModel(File rootDirectory) { root = rootDirectory; }

	public Object getRoot() { return root; }

	public Object getChild(Object parent, int index)
	{
		File directory = (File) parent;
		String[] children = directory.list();
		return new TreeFile(directory, children[index]);
	}

	public int getChildCount(Object parent)
	{
		File file = (File) parent;
		if(file.isDirectory())
		{
			String[] fileList = file.list();
			if(fileList != null)
				return file.list().length;
		}
		return 0;
	}

	public void addTreeModelListener(TreeModelListener listener) { listeners.add(listener);	}

	public void removeTreeModelListener(TreeModelListener listener) { listeners.remove(listener); }

	public boolean isLeaf(Object node)
	{
		File file = (File) node;
		return file.isFile();
	}

	public int getIndexOfChild(Object parent, Object child)
	{
		File directory = (File) parent;
		File file = (File) child;
		String[] children = directory.list();
		for(int i = 0; i < children.length; i++)
			if(file.getName().equals(children[i]))
				return i;
		return -1;
	}

	public void valueForPathChanged(TreePath path, Object value)
	{
		File oldFile = (File) path.getLastPathComponent();
		String fileParentPath = oldFile.getParent();
		String newFileName = (String) value;
		File targetFile = new File(fileParentPath, newFileName);
		oldFile.renameTo(targetFile);
		File parent = new File(fileParentPath);
		int[] changedChildrenIndices = { getIndexOfChild(parent, targetFile) };
		Object[] changedChildren = { targetFile };
		fireTreeNodesChanged(path.getParentPath(), changedChildrenIndices, changedChildren);

	}

	private void fireTreeNodesChanged(TreePath parentPath, int[] indices, Object[] children)
	{
		TreeModelEvent event = new TreeModelEvent(this, parentPath, indices, children);
		Iterator iterator = listeners.iterator();
		TreeModelListener listener = null;
		while(iterator.hasNext())
		{
			listener = (TreeModelListener) iterator.next();
			listener.treeNodesChanged(event);
		}
	}

	private class TreeFile extends File
	{
		public TreeFile(File parent, String child) { super(parent, child); }
		public String toString() { return getName(); }
	}
}
