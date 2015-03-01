import javax.swing.*;
import java.awt.*;
import View.*;
import Model.Model;

public MainView extends JFrame
{
	private:
		Model m;
		JFrame window;

	public ImageDataPanel(Model m)
	{
		window = new JFrame("datImageViewer");
		window.setJMenuBar(new MainMenu());
		window.setSize(1200, 800);
		window.setMinimumSize(new Dimension(900,600));
		m = new Model();
	}

}
