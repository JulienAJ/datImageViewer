package View;

import Model.Model;
import javax.swing.*;
import CommonTypes.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.util.Observer;
import java.util.Observable;

public class BrowseFrame extends JFrame implements Observer
{
	private JTree tree;
	private JButton validate;
	private JButton cancel;
	private String path;

	public BrowseFrame(Model m)
	{
		super("Ouvrir");
		this.tree = new JTree();
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
		this.add(tree, gc);

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

	public void show() { this.setVisible(true); }

	public void hide() { this.setVisible(false); }

	public String getPath() { return this.path; }

	public JButton getValidate() { return this.validate; }
	
	public JButton getCancel() { return this.cancel; }

	public void update(Observable o, Object arg)
	{
		Model m = (Model)o;
		ChangeClass changes = (ChangeClass)arg;

		// CHANGE SELECTED DIR
	}
}
