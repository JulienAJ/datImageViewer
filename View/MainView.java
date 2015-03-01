import javax.swing.*;
import java.awt.*;
import View.*;
import Model.Model;

public class MainView extends JFrame
{
	Model m;
	RepertoryPanel repertoryPanel;
	TopBar topBar;
	ImageDataPanel imageDataPanel;
	ImagePanel imagePanel;

	public MainView()
	{
		super("datImageViewer");
		m = new Model();

		this.setJMenuBar(new MainMenu(m));
		this.setSize(1200, 800);
		this.setMinimumSize(new Dimension(900,600));
		this.setVisible(true);
		this.addWindowListener(new MyWindowListener());
		
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
		//this.add(rp,c);
	}

	public static void main(String[] args)
	{
		MainView m = new MainView();

	}

}
