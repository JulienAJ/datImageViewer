package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import Model.Model;
import CommonTypes.*;

public class ImageDataPanel extends JPanel implements Observer
{
	private static final long serialVersionUID = -5739904207491916450L;

	JTextField imageName;
	JButton rename;
	JList<String> tags;
	JButton editTags;
	JLabel noSelection;

	public ImageDataPanel(Model m)
	{
		super();
		// SET FIXED SIZE
		imageName = new JTextField();
		imageName.setEditable(false);

		rename = new JButton("Renommer");
		tags = new JList<String>();
		editTags = new JButton("Modifier");
		noSelection = new JLabel("Aucune Image selectionnée");
		this.setBorder(BorderFactory.createTitledBorder("Données"));
		this.setLayout(new GridBagLayout());

		String selected = m.getSelected();
		if(selected == null)
		{
			imageName.setVisible(false);
			rename.setVisible(false);
			tags.setVisible(false);
			editTags.setVisible(false);
			noSelection.setVisible(true);
		}
		else
		{
			imageName.setText(selected);
			tags.setListData((String[])(m.getTags(selected).toArray())); 
			imageName.setVisible(true);
			rename.setVisible(true);
			tags.setVisible(true);
			editTags.setVisible(true);
			noSelection.setVisible(false);
		}

		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.CENTER;
		gc.weightx = 1.0;
		gc.gridx = 0;
		gc.gridy = 0;
		this.add(imageName, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		this.add(rename, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		this.add(tags, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		this.add(editTags, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		this.add(noSelection, gc);


		m.addObserver(this);
	}

	public JButton getRename() { return this.rename; }

	public JButton getTagsButton() { return this.editTags; }

	public void addListener(ActionListener l)
	{
		this.rename.addActionListener(l);
		this.editTags.addActionListener(l);
	}

	public void update(Observable o, Object obj)
	{
		Model m = (Model)o;
		ChangeClass changes = (ChangeClass)obj;

		if(changes.getType() == ChangeType.SELECTED)
		{
			String selected = m.getSelected();
			if(selected == null)
			{
				imageName.setVisible(false);
				rename.setVisible(false);
				tags.setVisible(false);
				editTags.setVisible(false);
				noSelection.setVisible(true);
			}

			else
			{
				imageName.setText(selected);
				tags.setListData((String[])(m.getTags(selected).toArray())); 
				imageName.setVisible(true);
				rename.setVisible(true);
				tags.setVisible(true);
				editTags.setVisible(true);
				noSelection.setVisible(false);
			}
		}
	}
}
