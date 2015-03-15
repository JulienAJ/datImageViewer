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
	private SwingWorker<Void, Thumbnail> imageWorker = null;
	private JScrollPane scrollPane;
	private DefaultListModel<Thumbnail> imagesListModel;
	private JList<Thumbnail> imagesList;

	public ImageBrowserPanel(Model m)
	{
		super();
		this.m = m;
		this.path = m.getRepertory();
		createImages();

		imagesListModel = new DefaultListModel<Thumbnail>();
		imagesList = new JList<Thumbnail>(imagesListModel);
		imagesList.setCellRenderer(new ThumbListCellRenderer());
		imagesList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		imagesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		imagesList.setVisibleRowCount(-1);

		scrollPane = new JScrollPane(imagesList);
		scrollPane.setPreferredSize(new Dimension(500, 500));

		this.setLayout(new BorderLayout());
		this.add(scrollPane, BorderLayout.CENTER);

		m.addObserver(this);
	}

	public JList<Thumbnail> getList()
	{
		return this.imagesList;
	}

	public void addListener(ListSelectionListener l)
	{
		imagesList.addListSelectionListener(l);
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
		if(path == null && !m.isSearch())
			return;

		if(imageWorker != null)
			imageWorker.cancel(true);

		if(m.isSearch())
			new ImageWorker(m.getSearchResults(), Util.getPathFromFile(m.getRepertory())).execute();
		else
			new ImageWorker(m.getImageMap(), Util.getPathFromFile(m.getRepertory())).execute();
	}

	private class ImageWorker extends SwingWorker<Void, Thumbnail>
	{
		private File[] files;

		public ImageWorker(Map<String, List<String> > map, String repertory)
		{
			if(imageWorker != null)
				imageWorker.cancel(true);

			imageWorker = this;

			int i = 0;
			files = new File[map.size()];
			for(String key : map.keySet())
			{
				files[i] = new File(key);
				++i;
			}
		}

		@Override
		protected Void doInBackground()
		{
			imagesListModel.clear();

			if(files == null)
				return null;

			for (File file : files)
			{
				if (isCancelled())
					return null;

				if(Util.isImage(file))
				{
					try
					{
						Thumbnail thumb = new Thumbnail(file.getAbsolutePath(), m.getSize());
						publish(thumb);
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
		protected void process(List<Thumbnail> thumbsList)
		{
			if(!isCancelled())
			{
				for(Thumbnail thumb : thumbsList)
				{
					imagesListModel.addElement(thumb);
					if (thumb.getName().equals(m.getSelected()))
						imagesList.setSelectedValue(thumb, true);
				}
			}
		}
	}
}
