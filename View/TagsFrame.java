package View;

import Model.Model;
import CommonTypes.*;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.util.Observer;
import java.util.Observable;
import java.awt.event.ActionListener;

public class TagsFrame extends JFrame implements Observer
{
	private static final long serialVersionUID = 5328223983428042194L;

	private JTextArea tags;
	private JButton validate;
	private JButton cancel;

	public TagsFrame(Model m)
	{
		super("Changer Tags");
		this.tags = new JTextArea(m.getTagsArea(m.getSelected()));
		this.validate = new JButton("Valider");
		this.cancel = new JButton("Annuler");

		this.setLayout(new GridBagLayout());
		this.setVisible(true);
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 2;
		gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		this.add(tags, gc);
		
		gc.weightx = 1;
		gc.gridwidth = 1;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.NONE;
		this.add(cancel, gc);

		gc.gridx = 1;
		this.add(validate, gc);
		//this.setSize(new Dimension(300, 300));

		this.pack();

		m.addObserver(this);
	}

	public void addListener(ActionListener l)
	{
		this.validate.addActionListener(l);
		this.cancel.addActionListener(l);
	}
	//public void show() { this.setVisible(true); }

	//public void hide() { this.setVisible(false); }

	public String getNewTags() { return this.tags.getText(); }

	public JButton getValidate() { return this.validate; }
	
	public JButton getCancel() { return this.cancel; }

	public void update(Observable o, Object arg)
	{
		Model m = (Model)o;
		ChangeClass changes = (ChangeClass)arg;

		if(changes.getType() == ChangeType.IMAGENAME || changes.getType() == ChangeType.SELECTED)
			this.tags.setText(m.getTagsArea(m.getSelected()));

	}
}
