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
	DefaultListModel<String> tagsModel;
	JScrollPane tagPane;
	JButton editTags;
	JLabel noSelection;

	public ImageDataPanel(Model m)
	{
		super();
		imageName = new JTextField();
		imageName.setEditable(false);

		rename = new JButton("Renommer");
		tags = new JList<String>();
		setupList(m);
		tags.setVisibleRowCount(10);
		tags.setFixedCellHeight(15);
		tags.setFixedCellWidth(100);
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
			java.util.List<String> tempList = m.getTags(selected);
			if(tempList != null)
				tags.setListData((String[])(tempList.toArray()));
			//tags.setListData((String[])(m.getTags(selected).toArray())); 
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

	private void setupList(Model m)
	{
		tagsModel = new DefaultListModel<String>();
		java.util.List<String> list = m.getTags(m.getRepertoryPath() + m.getSelected());
		if(tags == null)
			tags = new JList<String>();

		if(list != null)
			for(String str : list)
				tagsModel.addElement(str);

		tags.setModel(tagsModel);
	}

	@Override
	public void update(Observable o, Object obj)
	{
		Model m = (Model)o;
		ChangeClass changes = (ChangeClass)obj;

		if(changes.getType() == ChangeType.SELECTED
		|| changes.getType() == ChangeType.IMAGENAME
		|| changes.getType() == ChangeType.IMAGETAGS)
		{
			// HANDLE TAGS CHANGE
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
				setupList(m);
				imageName.setVisible(true);
				rename.setVisible(true);
				tags.setVisible(true);
				editTags.setVisible(true);
				noSelection.setVisible(false);
			}
		}
	}
}
