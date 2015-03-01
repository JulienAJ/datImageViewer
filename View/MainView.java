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
		this.setJMenuBar(new MainMenu());
		this.setSize(1200, 800);
		this.setMinimumSize(new Dimension(900,600));
		m = new Model();
	}

	public static void main(String[] args)
	{
		MainMenu m = new MainMenu();

	}

}
