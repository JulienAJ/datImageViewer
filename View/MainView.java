import javax.swing.*;
import java.awt.*;
import View.*;
import Model.Model;

public class MainView extends JFrame
{
	Model m;
	Jpanel repertoryPanel;
	Jpanel topBar;
	Jpanel imageDataPanel;
	Jpanel imagePanel;

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
		imagePanel = new ImagePanel();
	}
	
	public void setup() // add and constraint
	{
		//this.add(rp,c);
	}

	public static void main(String[] args)
	{
		MainView m = new MainView();

	}

}
