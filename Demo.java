import javax.swing.*;
import java.awt.*;
import View.*;
import Model.Model;

public class Demo
{
	public static void main(String[] args)
	{
		Model m = new Model();
		JFrame window = new JFrame("datImageViewer");
		window.setJMenuBar(new MainMenu());
		window.setSize(1200, 800);
		window.setMinimumSize(new Dimension(900,600));
		
		//	<----------  Declaration du type de Layout  ---------->
		
		JPanel Main = new JPanel();
		GridBagConstraints c = new GridBagConstraints();
		Main.setPreferredSize(new Dimension(1200,775));
		Main.setLayout(new GridBagLayout());
		Main.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		/*
		JPanel Main =new JPanel();
		Main.setPreferredSize(new Dimension(1200,775));
		Main.setLayout( new BoxLayout(Main, BoxLayout.X_AXIS) );
		*/


		//	<----------  Ajout LeftPanel  ---------->
		
		JPanel LeftPanel = new JPanel();
		LeftPanel.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.WEST;
		c.weightx = 0.2;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight= 2;
		Main.add(LeftPanel, c);

		// <----- RAZ ----->
		c.gridwidth = 1;
		c.gridheight = 1;
		c.ipady = 0;
		c.ipadx = 0;

		//	<----------  Ajout RepertoryPanel  ---------->

 		RepertoryPanel Rp = new RepertoryPanel();
		Rp.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.gridx = 0;
		c.gridy = 0;
		LeftPanel.add(Rp, c);

		//	<----------  Ajout ImageDataPanel  ---------->
		
		JPanel IDP = new ImageDataPanel(m);
		IDP.setLayout( new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.gridwidth = 1;
		c.gridheight = 4;
		c.gridx = 0;
		c.gridy = 1;
		c.ipady = 550;
		c.ipadx = 50;
		LeftPanel.add(IDP, c);

		// <----- RAZ ----->
		c.gridwidth = 1;
		c.gridheight = 1;
		c.ipady = 0;
		c.ipadx = 0;

		//	<----------  Ajout RightPanel  ---------->

		JPanel RightPanel =new JPanel();
		RightPanel.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.EAST;
		c.weightx = 0.8;
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 4;
		c.gridheight= 2;
		Main.add(RightPanel, c);

		// <----- RAZ ----->
		c.gridwidth = 1;
		c.gridheight = 1;

		//	<----------  Ajout TopBar  ---------->
		JPanel TopB = new TopBar();
		//TopB.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.WEST;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 0;
		c.ipadx = 850;
		RightPanel.add(TopB, c);

		//	<----------  Ajout ImagePanel  ---------->
		JPanel ImgP = new ImagePanel();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = 1;
		c.gridheight= 4;
		c.gridx = 0;
		c.gridy = 1;
		c.ipady = 540;
		c.ipadx = 850;
		RightPanel.add(ImgP, c);
		
		/*	

		JPanel LeftPanel =new JPanel();
		LeftPanel.setLayout( new BoxLayout(LeftPanel,BoxLayout.Y_AXIS) );
		LeftPanel.setPreferredSize(new Dimension(300,775));
		LeftPanel.setMaximumSize(new Dimension(300,775));

		//JPanel RightPanel =new JPanel();
		ImageBrowserPanel RightPanel = new ImageBrowserPanel();
		RightPanel.setLayout(new ScrollPaneLayout());
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
		*/
		window.setVisible(true);

		//window.add(new JLabel("Contenu"));
		//window.pack();

		//	<----------  Ajout  ---------->
		window.add(Main);
		window.addWindowListener(new MyWindowListener());
	}
}
