package View;
import javax.swing.*;
import java.util.*;
import Model.Model;
import CommonTypes.*;

public class MainMenu extends JMenuBar implements Observer
{
	JMenu repertoryMenu;
	JMenu displayMenu;
	JMenu languagesMenu;

	ButtonGroup displayButtonGroup;
	ButtonGroup languagesButtonGroup;

	JMenuItem changeRepertoryItem;

	JRadioButtonMenuItem bigDisplayItem;
	JRadioButtonMenuItem mediumDisplayItem;
	JRadioButtonMenuItem smallDisplayItem;

	JRadioButtonMenuItem frenchItem;
	JRadioButtonMenuItem englishItem;
	JRadioButtonMenuItem russianItem;

	public MainMenu()
	{
		super();
		// Repertory
		repertoryMenu = new JMenu("Répertoire");

		changeRepertoryItem = new JMenuItem("Changer de répertoire");

		repertoryMenu.add(changeRepertoryItem);

		// Display
		displayMenu = new JMenu("Affichage");

		bigDisplayItem = new JRadioButtonMenuItem("Grand");
		bigDisplayItem.setSelected(true);
		mediumDisplayItem = new JRadioButtonMenuItem("Moyen");
		mediumDisplayItem.setSelected(false);
		smallDisplayItem = new JRadioButtonMenuItem("Petit");
		smallDisplayItem.setSelected(false);

		displayButtonGroup = new ButtonGroup();
		displayButtonGroup.add(bigDisplayItem);
		displayButtonGroup.add(mediumDisplayItem);
		displayButtonGroup.add(smallDisplayItem);

		displayMenu.add(bigDisplayItem);
		displayMenu.add(mediumDisplayItem);
		displayMenu.add(smallDisplayItem);

		// Languages
		languagesMenu = new JMenu("Langues");

		frenchItem = new JRadioButtonMenuItem("Français");
		frenchItem.setSelected(true);
		englishItem = new JRadioButtonMenuItem("English");
		englishItem.setSelected(false);
		russianItem = new JRadioButtonMenuItem("русский");
		russianItem.setSelected(false);

		ButtonGroup languagesButtonGroup = new ButtonGroup();
		languagesButtonGroup.add(frenchItem);
		languagesButtonGroup.add(englishItem);
		languagesButtonGroup.add(russianItem);

		languagesMenu.add(frenchItem);
		languagesMenu.add(englishItem);
		languagesMenu.add(russianItem);

		// Main Menu
		this.add(repertoryMenu);
		this.add(displayMenu);
		this.add(languagesMenu);
	}

	public void update(Observable o, Object arg)
	{
		String updated = (String)arg;
		Model m = (Model)o;
		if(updated.equals("language"))
		{
			String lang = m.getLanguage();
			if(lang.equals("french"))
			{
				frenchItem.setSelected(true);
				englishItem.setSelected(false);
				russianItem.setSelected(false);
			}
			else if(lang.equals("english"))
			{
				frenchItem.setSelected(false);
				englishItem.setSelected(true);
				russianItem.setSelected(false);
			}
			else if(lang.equals("russian"))
			{
				frenchItem.setSelected(false);
				englishItem.setSelected(false);
				russianItem.setSelected(true);
			}
		}
		else if(updated.equals("size"))
		{
			DisplaySize size = m.getSize();
			if(size == DisplaySize.BIG)
			{
				bigDisplayItem.setSelected(true);
				mediumDisplayItem.setSelected(false);
				smallDisplayItem.setSelected(false);
			}
			else if(size == DisplaySize.MEDIUM)
			{
				bigDisplayItem.setSelected(false);
				mediumDisplayItem.setSelected(true);
				smallDisplayItem.setSelected(false);
			}
			else if(size == DisplaySize.SMALL)
			{
				bigDisplayItem.setSelected(false);
				mediumDisplayItem.setSelected(false);
				smallDisplayItem.setSelected(true);
			}
		}
	}
}
