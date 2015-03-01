package View;

import javax.swing.*;
import java.awt.*;
import View.*;
import Model.Model;

public class MainView extends JFrame
{
	Model m;
	MainPanel mainPanel;
	RepertoryPanel repertoryPanel;
	TopBar topBar;
	ImageDataPanel imageDataPanel;
	ImagePanel imagePanel;

	public MainView()
	{
		super("datImageViewer");

		this.setJMenuBar(new MainMenu(m));
		this.setSize(1200, 800);
		this.setMinimumSize(new Dimension(900,600));
		this.setVisible(true);
		this.addWindowListener(new MyWindowListener());
		
		mainPanel = new MainPanel();
		m = new Model();
		repertoryPanel = new RepertoryPanel(m);
		imageDataPanel = new ImageDataPanel(m);
		topBar = new TopBar();
		imagePanel = new ImagePanel(m);
	}

	// RepertoryPanel

	public JButton getBrowseButton()
	{
		return this.repertoryPanel.getBrowseButton();
	}
	
	//ImageDataPanel

	public JButton getRenameButton()
	{
		return this.imageDataPanel.getRename();
	}

	public JButton getTagsButton()
	{
		return this.imageDataPanel.getTagsButton();
	}

	//TopBar

	public JButton getSearchButton()
	{
		return this.topBar.getSearchButton();
	}

	// Add and Constraint

	public void setup()
	{
		// MainPanel
		this.add(mainPanel);

		//RepertoryPanel
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.gridwidth = 1;
		gbc.gridheight= 1;
		this.mainPanel.add(repertoryPanel,gbc);

		//ImageDataPanel
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 3.0;
		gbc.gridwidth = 1;
		gbc.gridheight= 3;
		this.mainPanel.add(imageDataPanel,gbc);

		//TopBar
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 4.0;
		gbc.weighty = 1.0;
		gbc.gridwidth = 4;
		gbc.gridheight= 1;
		//gbc.ipady = 0;
		//gbc.ipadx = 850;
		this.mainPanel.add(topBar, gbc);

		//ImagePanel
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 4.0;
		gbc.weighty = 3.0;
		gbc.gridwidth = 4;
		gbc.gridheight= 3;
		//gbc.ipady = 540;
		//gbc.ipadx = 850;
		this.mainPanel.add(imagePanel, gbc);
	}

	public static void main(String[] args)
	{
		MainView m = new MainView();
		m.setup();
	}

}
