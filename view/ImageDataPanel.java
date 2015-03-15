package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import model.Model;
import commonTypes.*;
import util.Util;

public class ImageDataPanel extends JPanel implements Observer
{
	private static final long serialVersionUID = -5739904207491916450L;

	private JTextField imageName;
	private JButton rename;
	private JList<String> tags;
	private DefaultListModel<String> tagsModel;
	private JScrollPane tagPane;
	private JButton editTags;
	private JLabel noSelection;
	private JLabel noTag;

	public ImageDataPanel(Model m)
	{
		super();
		imageName = new JTextField();
		imageName.setEditable(false);

		rename = new JButton(m.getString("renameButton"));
		tags = new JList<String>();
		tags.setVisibleRowCount(10);
		tags.setFixedCellHeight(15);
		tags.setFixedCellWidth(100);
		editTags = new JButton(m.getString("modifyButton"));
		noSelection = new JLabel(m.getString("noImage"));
		noTag= new JLabel(m.getString("noTag"));
		this.setBorder(BorderFactory.createTitledBorder(m.getString("data")));
		this.setLayout(new GridBagLayout());

		String selected = m.getSelected();
		if(selected == null)
		{
			imageName.setVisible(false);
			rename.setVisible(false);
			tags.setVisible(false);
			editTags.setVisible(false);
			noTag.setVisible(false);
			noSelection.setVisible(true);
		}
		else
		{
			selected = Util.basename(selected);
			imageName.setText(selected);
			setupList(m);
			imageName.setVisible(true);
			rename.setVisible(true);
			tags.setVisible(true);
			editTags.setVisible(true);
			noSelection.setVisible(false);
			if (tags.isSelectionEmpty())
			{
				noTag.setVisible(true);
				tags.setVisible(false);
			}
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
		gc.gridy = 2;
		this.add(noTag, gc);
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
		java.util.List<String> list = m.getTags(m.getSelected());
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
		ChangeType change = (ChangeType)obj;

		if(change == ChangeType.SELECTED
				|| change == ChangeType.IMAGENAME
				|| change == ChangeType.IMAGETAGS)
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
				selected = Util.basename(selected);
				imageName.setText(selected);
				setupList(m);
				imageName.setVisible(true);
				rename.setVisible(true);
				tags.setVisible(true);
				editTags.setVisible(true);
				noSelection.setVisible(false);
			}
		}
		else if(change == ChangeType.LANGUAGE)
		{
			rename.setText(m.getString("renameButton"));
			editTags.setText(m.getString("modifyButton"));
			noSelection.setText(m.getString("noImage"));
			noTag.setText(m.getString("noTag"));
			this.setBorder(BorderFactory.createTitledBorder(m.getString("data")));
		}
	}
}
