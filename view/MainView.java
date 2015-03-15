package view;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import commonTypes.*;
import model.Model;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionListener;

public class MainView extends JFrame
{
	private static final long serialVersionUID = -2484854926097045983L;

	Model m;
	MainMenu mainMenu;
	RepertoryPanel repertoryPanel;
	TopBar topBar;
	ImageDataPanel imageDataPanel;
	ImagePanel imagePanel;
	ImageBrowserPanel imageBrowserPanel;

	public MainView(Model m)
	{
		super("datImageViewer");

		this.m = m;
		mainMenu = new MainMenu(m);
		this.setJMenuBar(mainMenu);
		this.setSize(1200, 800);
		this.setMinimumSize(new Dimension(1000,640));
		this.setVisible(true);
		this.addWindowListener(new MyWindowListener());

		this.repertoryPanel = new RepertoryPanel(m);
		this.imageDataPanel = new ImageDataPanel(m);
		this.topBar = new TopBar(m);
		this.imagePanel = new ImagePanel(m);
		imagePanel.setVisible(false);
		this.imageBrowserPanel = new ImageBrowserPanel(m);
		//setup();
	}

	// MainMenu
	public JMenuItem getChangeRepertoryItem() { return mainMenu.getChangeRepertoryItem(); }
	public JRadioButtonMenuItem getBigDisplayItem() { return mainMenu.getBigDisplayItem(); }
	public JRadioButtonMenuItem getMediumDisplayItem() { return mainMenu.getMediumDisplayItem(); }
	public JRadioButtonMenuItem getSmallDisplayItem() { return mainMenu.getSmallDisplayItem(); }
	public JRadioButtonMenuItem getFrenchItem() { return mainMenu.getFrenchItem(); }
	public JRadioButtonMenuItem getEnglishItem() { return mainMenu.getEnglishItem(); }
	public JRadioButtonMenuItem getChineseItem() { return mainMenu.getChineseItem(); }

	// RepertoryPanel
	public JButton getBrowseButton() { return this.repertoryPanel.getBrowseButton(); }
	
	//ImageDataPanel
	public JButton getRenameButton() { return this.imageDataPanel.getRename(); }
	public JButton getTagsButton() { return this.imageDataPanel.getTagsButton(); }

	//TopBar
	public JButton getSearchButton() { return this.topBar.getSearchButton(); }
	public JButton getCloseSearch() { return this.topBar.getCloseSearch(); }
	public JComboBox<String> getDisplayBox() { return this.topBar.getDisplayBox(); }
	public DisplaySize getSelectedSize() { return this.topBar.getSelectedSize(); }
	public boolean repertorySearch() { return this.topBar.repertoryIsSelected(); }

	public String getSearchKey() { return this.topBar.getSearchKey(); }

	//ImagePanel
	public JButton getNext() { return this.imagePanel.getNext(); }
	public JButton getPrevious() { return this.imagePanel.getPrevious(); }
	public JButton getClose() {	return this.imagePanel.getClose(); }
	public void hideImagePanel() { this.imagePanel.setVisible(false); }
	public void showImagePanel() { this.imagePanel.setVisible(true); }

	//ImageBroserPanel
	public JList<Thumbnail> getImageList() { return this.imageBrowserPanel.getList(); }

	public void addListener(ActionListener l)
	{
		imagePanel.addListener(l);
		mainMenu.addListener(l);
		repertoryPanel.addListener(l);
		imageDataPanel.addListener(l);
		topBar.addListener(l);
	}

	public void addListListener(ListSelectionListener l)
	{
		imageBrowserPanel.addListener(l);
	}
	
	// Add and Constraint

	public void setup()
	{
		// mainPanel
		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(1200,775));
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		//RepertoryPanel
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.gridwidth = 1;
		gbc.gridheight= 1;
		gbc.ipadx = 140;
		gbc.ipady = 35;
		mainPanel.add(repertoryPanel,gbc);

		//ImageDataPanel
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 3.0;
		gbc.gridwidth = 1;
		gbc.gridheight= 3;
		gbc.ipadx = 47;
		gbc.ipady = 490;
		mainPanel.add(imageDataPanel,gbc);

		//TopBar
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 4.0;
		gbc.weighty = 1.0;
		gbc.gridwidth = 4;
		gbc.gridheight= 1;
		gbc.ipadx = 890;
		gbc.ipady = 20;
		mainPanel.add(topBar, gbc);

		//ImagePanel
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		//gbc.weightx = 4.0;
		//gbc.weighty = 3.0;
		gbc.gridwidth = 1;
		gbc.gridheight= 1;
		//gbc.gridwidth = 4;
		//gbc.gridheight= 3;
		gbc.ipadx = 0;
		gbc.ipady = 260;
		mainPanel.add(imagePanel, gbc);

		//ImageBrowserPanel
		gbc.anchor = GridBagConstraints.SOUTH;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.gridwidth = 1;
		gbc.gridheight= 1;
		gbc.ipadx = 890;
		gbc.ipady = 140;
		mainPanel.add(imageBrowserPanel, gbc);

		// MainPanel
		this.add(mainPanel);
		this.setSize(1201, 801);
		this.setSize(1200, 800);
	}
}
