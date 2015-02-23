import javax.swing.*;
import java.awt.*;
import View.*;

public class Demo
{
	public static void main(String[] args)
	{
		JFrame window = new JFrame("datImageViewer");
		window.setJMenuBar(new MainMenu());
		window.setSize(1200, 800);

		JPanel Main =new JPanel();
		Main.setPreferredSize(new Dimension(1200,775));
		Main.setLayout( new BoxLayout(Main, BoxLayout.X_AXIS) );

		window.add(Main);
		window.addWindowListener(new MyWindowListener());

		JPanel LeftPanel =new JPanel();
		LeftPanel.setLayout( new BoxLayout(LeftPanel,BoxLayout.Y_AXIS) );
		LeftPanel.setPreferredSize(new Dimension(300,775));
		LeftPanel.setMaximumSize(new Dimension(300,775));

		JPanel RightPanel =new JPanel();
		RightPanel.setLayout( new BoxLayout(RightPanel,BoxLayout.Y_AXIS) );
		RightPanel.setPreferredSize(new Dimension(900,775));

		Main.add(LeftPanel);
		Main.add(RightPanel);

 		RepertoryPanel Rp = new RepertoryPanel();
		Rp.setAlignmentY(100);
		Rp.setMinimumSize(new Dimension(300,130));
		Rp.setMaximumSize(new Dimension(300,130));
		Rp.setPreferredSize(new Dimension(300,130));
		Rp.setLayout( new BoxLayout(Rp, BoxLayout.X_AXIS));

		//JScrollPane JsP = new JScrollPane();
		JPanel IDP = new ImageDataPanel();
		IDP.setMinimumSize(new Dimension(300,430));
		IDP.setMaximumSize(new Dimension(300,645));
		IDP.setPreferredSize(new Dimension(300,545));
		IDP.setLayout( new BoxLayout(IDP, BoxLayout.Y_AXIS));

		LeftPanel.add(Rp);
		LeftPanel.add(IDP);

		window.setVisible(true);

		//window.add(new JLabel("Contenu"));
		//window.pack();
	}
}
