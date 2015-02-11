import javax.swing.*;
import java.awt.*;

public class Demo
{
	public static void main(String[] args)
	{
		JFrame window = new JFrame("datImageViewer");

		window.setJMenuBar(new MainMenu());
		window.addWindowListener(new MyWindowListener());

		window.setSize(1200, 800);
		window.add(new JSplitPane(1, new RepertoryPanel(), new JScrollPane()));
		window.setVisible(true);
		
		//window.add(new JLabel("Contenu"));
		//window.pack();
	}
}
