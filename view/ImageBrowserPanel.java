package view;
import javax.swing.*;
import java.util.List;
import java.awt.FlowLayout;
import java.awt.Component;
import java.util.Observable;
import java.util.Observer;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.awt.Dimension;
import java.awt.BorderLayout;
import model.Model;
import commonTypes.*;
import util.Util;
import java.io.*;
import javax.swing.event.ListSelectionListener;

public class ImageBrowserPanel extends JPanel implements Observer
{
	private static final long serialVersionUID = -7122515010903319043L;

	private Model m;

	private File path;

	private JScrollPane scroll;

	private DefaultListModel<Thumbnail> iconListModel;
	private JList<Thumbnail> iconList;

	private SwingWorker<Void, Thumbnail> loadImageWorker = null;

	public ImageBrowserPanel(Model m)
	{
		super();
		this.m = m;
		iconListModel = new DefaultListModel<Thumbnail>();
		iconList = new JList<Thumbnail>(iconListModel);
		iconList.setCellRenderer(new iconListCellRenderer());
		iconList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		iconList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		iconList.setVisibleRowCount(-1);

		this.path = m.getRepertory();
		createImages();

		scroll = new JScrollPane(iconList);
		scroll.setPreferredSize(new Dimension(500, 500));

		setLayout(new BorderLayout());
		add(scroll, BorderLayout.CENTER);

		m.addObserver(this);
	}

	public JList<Thumbnail> getList() { return this.iconList; }

	public void addListener(ListSelectionListener l)
	{
		iconList.addListSelectionListener(l);
	}

	@Override
	public void update(Observable o, Object arg)
	{
		Model m = (Model)o;
		ChangeType change = (ChangeType)arg;

		if(change == ChangeType.REPERTORY)
		{
			this.path = m.getRepertory();
			createImages();
		}

		else if(change == ChangeType.SEARCH
				|| change == ChangeType.DISPLAYSIZE
				|| change == ChangeType.IMAGENAME)
		{
			createImages();
		}
	}

	public void createImages()
	{
		if (path == null && !m.isSearch())
			return;

		if(m.isSearch())
			new imageLoader(m.getSearchResults(), m.getRepertoryPath()).execute();
		else
			new imageLoader(m.getImageMap(), m.getRepertoryPath()).execute();
	}

	private class iconListCellRenderer extends JLabel implements ListCellRenderer<Thumbnail>
	{
		private static final long serialVersionUID = -3419410645297544425L;

		public iconListCellRenderer()
		{
			setOpaque(true);
		}

		public Component getListCellRendererComponent(JList<? extends Thumbnail> list, Thumbnail value, int index, boolean isSelected, boolean cellHasFocus)
		{
			ImageIcon image = value.getImage();
			if(image != null)
			{
				setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight() + 20));

				setText(value.getName());
				setVerticalTextPosition(JLabel.BOTTOM);
				setHorizontalTextPosition(JLabel.CENTER);

				setIcon(value.getImage());
				setHorizontalAlignment(JLabel.CENTER);

				if(isSelected)
				{
					setBackground(list.getSelectionBackground());
					setForeground(list.getSelectionForeground());
				}
				else
				{
					setBackground(list.getBackground());
					setForeground(list.getForeground());
				}
			}

			return this;
		}
	}

	private class imageLoader extends SwingWorker<Void, Thumbnail>
	{
		private File[] files;

		public imageLoader(Map<String, List<String> > map, String repertory)
		{
			if(loadImageWorker != null)
				loadImageWorker.cancel(true);

			loadImageWorker = this;

			int i = 0;
			files = new File[map.size()];
			for(String key : map.keySet())
			{
				files[i] = new File(key);
				++i;
			}
		}

		@Override
		protected Void doInBackground() throws Exception
		{
			iconListModel.clear();
			if (files == null)
				return null;

			for (File f : files)
			{
				if (isCancelled())
					return null;

				if(Util.isImage(f))
				{
					try
					{
						Thumbnail t = new Thumbnail(f.getAbsolutePath(), m.getSize());
						publish(t);
					}
					catch(Exception e)
					{
						System.err.println(e);
					}
				}
			}

			return null;
		}

		@Override
		protected void process(List<Thumbnail> chunks)
		{
			if (!isCancelled()) {
				for (Thumbnail t : chunks) {
					iconListModel.addElement(t);
					if (t.getName().equals(m.getSelected()))
						iconList.setSelectedValue(t, true);
				}
			}
		}
	}
}
