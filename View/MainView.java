import javax.swing.*;
import java.awt.*;
import View.*;
import Model.Model;

public MainView extends JFrame
{
	private:
		Model m = new Model();
		JFrame window = new JFrame("datImageViewer");

	public ImageDataPanel(Model m)
	{
		window.setJMenuBar(new MainMenu());
		window.setSize(1200, 800);
		window.setMinimumSize(new Dimension(900,600));
	}

}
