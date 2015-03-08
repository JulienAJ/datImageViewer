package View;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import View.*;
import CommonTypes.*;
import Model.Model;
import java.awt.event.ActionListener;

public class MainView extends JFrame
{
	private static final long serialVersionUID = -2484854926097045983L;

	Model m;
	MainMenu mainMenu;
	RepertoryPanel repertoryPanel;
	TopBar topBar;
	ImageDataPanel imageDataPanel;
	ImagePanel imagePanel;
	BrowseFrame browseFrame;
	RenameFrame renameFrame;
	TagsFrame tagsFrame;
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
		this.imageBrowserPanel = new ImageBrowserPanel(m);
		setup();
	}

	public void displayChangeRepertory()
	{
		// BrowseFrame
	}

	public void displayRename()
	{
		//RenameFrame
	}

	// MainMenu
	public JMenuItem getChangeRepertoryItem() { return mainMenu.getChangeRepertoryItem(); }
	public JRadioButtonMenuItem getBigDisplayItem() { return mainMenu.getBigDisplayItem(); }
	public JRadioButtonMenuItem getMediumDisplayItem() { return mainMenu.getMediumDisplayItem(); }
	public JRadioButtonMenuItem getSmallDisplayItem() { return mainMenu.getSmallDisplayItem(); }
	public JRadioButtonMenuItem getFrenchItem() { return mainMenu.getFrenchItem(); }
	public JRadioButtonMenuItem getEnglishItem() { return mainMenu.getEnglishItem(); }
	public JRadioButtonMenuItem getRussianItem() { return mainMenu.getRussianItem(); }

	// RepertoryPanel
	public JButton getBrowseButton() { return this.repertoryPanel.getBrowseButton(); }
	
	//ImageDataPanel
	public JButton getRenameButton() { return this.imageDataPanel.getRename(); }
	public JButton getTagsButton() { return this.imageDataPanel.getTagsButton(); }

	//TopBar
	public JButton getSearchButton() { return this.topBar.getSearchButton(); }
	public JComboBox<String> getDisplayBox() { return this.topBar.getDisplayBox(); }
	public DisplaySize getSelectedSize() { return this.topBar.getSelectedSize(); }

	public String getSearchKey() { return this.topBar.getSearchKey(); }

	//ImagePanel
	public JButton getNext() { return this.imagePanel.getNext(); }
	public JButton getPrevious() { return this.imagePanel.getPrevious(); }
	public JButton getClose() {	return this.imagePanel.getClose(); }
	
	//BrowseFrame
	public JFileChooser getChooser()
	{
		if(browseFrame == null)
			return null;

		return this.browseFrame.chooser;
	}

	public File getPathChooser()
	{
		if(browseFrame == null)
			return null;

		return this.browseFrame.getPath();
	}

	//RenameFrame
	public String getNewNameRenameFrame()
	{
		if(renameFrame == null)
			return null;

		return renameFrame.getNewName();
	}

	public JButton getValidateRenameFrame()
	{
		if(renameFrame == null)
			return null;

		return this.renameFrame.getValidate();
	}
	
	public JButton getCancelRenameFrame()
	{
		if(renameFrame == null)
			return null;

		return this.renameFrame.getCancel();
	}

	// TO DO
	
	public void displayTagFrame() {}
	public void hideRenameFrame() {}
	public void closeImagePanel() {}

	public void addListener(ActionListener l)
	{
		if(browseFrame != null)
			browseFrame.addListener(l);

		if(renameFrame != null)
			renameFrame.addListener(l);

		if(tagsFrame != null)
			tagsFrame.addListener(l);

		imagePanel.addListener(l);
		mainMenu.addListener(l);
		repertoryPanel.addListener(l);
		imageDataPanel.addListener(l);
		topBar.addListener(l);
		// TO DO ADD LISTENER TO IMG BROWSER PANEL
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
		gbc.ipady = 20;
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
		gbc.ipady = 540;
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
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 4.0;
		gbc.weighty = 3.0;
		gbc.gridwidth = 4;
		gbc.gridheight= 3;
		gbc.ipadx = 890;
		gbc.ipady = 0;
		mainPanel.add(imagePanel, gbc);
		//ImageBrowserPanel
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.gridwidth = 1;
		gbc.gridheight= 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		mainPanel.add(imageBrowserPanel, gbc);

		// MainPanel
		this.add(mainPanel);
		this.setSize(1201, 801);
		this.setSize(1200, 800);
	}

	/*public static void main(String[] args)
	{
		new MainView();
	}*/

}
