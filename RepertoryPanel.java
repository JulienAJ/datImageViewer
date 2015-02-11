import javax.swing.*;

public class RepertoryPanel extends JPanel
{
	JTextField PathField;
	JButton BrowseButton;

	public RepertoryPanel()
	{
		PathField = new JTextField("./");
		BrowseButton = new JButton("...");
		setBorder(BorderFactory.createTitledBorder("Répertoire"));
	}
}
