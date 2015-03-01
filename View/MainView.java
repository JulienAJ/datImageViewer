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

		GridBagConstraints gbc = new GridBagConstraints();

		//RepertoryPanel
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = 0.2;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight= 1;
		this.mainPanel.add(repertoryPanel,gbc);

		//ImageDataPanel
	}

	public static void main(String[] args)
	{
		MainView m = new MainView();
		m.setup();

	}

}
