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
		this.setMinimumSize(new Dimension(1000,640));
		this.setVisible(true);
		this.addWindowListener(new MyWindowListener());
		
		this.mainPanel = new MainPanel();
		this.m = new Model();
		this.repertoryPanel = new RepertoryPanel(m);
		this.imageDataPanel = new ImageDataPanel(m);
		this.topBar = new TopBar();
		this.imagePanel = new ImagePanel(m);

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

		//RepertoryPanel
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.gridwidth = 1;
		gbc.gridheight= 1;
		gbc.ipadx = 100;
		gbc.ipady = 20;
		this.mainPanel.add(repertoryPanel,gbc);

		//ImageDataPanel
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 3.0;
		gbc.gridwidth = 1;
		gbc.gridheight= 3;
		gbc.ipadx = 7;
		gbc.ipady = 540;
		this.mainPanel.add(imageDataPanel,gbc);

		//TopBar
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.gridwidth = 4;
		gbc.gridheight= 1;
		gbc.ipadx = 750;
		gbc.ipady = 20;
		this.mainPanel.add(topBar, gbc);

		//ImagePanel
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 3.0;
		gbc.gridwidth = 4;
		gbc.gridheight= 3;
		gbc.ipadx = 750;
		gbc.ipady = 0;
		this.mainPanel.add(imagePanel, gbc);

		// MainPanel
		this.add(mainPanel);
		this.setSize(1201, 801);
		this.setSize(1200, 800);
	}

	public static void main(String[] args)
	{
		MainView m = new MainView();
		m.setup();
	}

}
