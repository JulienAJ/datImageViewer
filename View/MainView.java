import javax.swing.*;
import java.awt.*;
import View.*;
import Model.Model;

public class MainView extends JFrame
{
	Model m;

	public MainView()
	{
		super("datImageViewer");
		m = new Model();

		this.setJMenuBar(new MainMenu(m));
		this.setSize(1200, 800);
		this.setMinimumSize(new Dimension(900,600));
		this.setVisible(true);
		this.addWindowListener(new MyWindowListener());
	}

	public static void main(String[] args)
	{
		MainView m = new MainView();

	}

}
