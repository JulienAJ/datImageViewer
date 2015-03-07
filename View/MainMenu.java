package View;
import javax.swing.*;
import java.util.*;
import Model.Model;
import java.awt.event.*;
import CommonTypes.*;

public class MainMenu extends JMenuBar implements Observer
{
	private static final long serialVersionUID = -4846840192135882562L;

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

	public MainMenu(Model m)
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

		m.addObserver(this);
	}

	public JMenuItem getChangeRepertoryItem(){ return this.changeRepertoryItem; }

	public JRadioButtonMenuItem getBigDisplayItem(){ return this.bigDisplayItem; }
	public JRadioButtonMenuItem getMediumDisplayItem(){ return this.mediumDisplayItem; }
	public JRadioButtonMenuItem getSmallDisplayItem(){ return this.smallDisplayItem; }

	public JRadioButtonMenuItem getFrenchItem(){ return this.frenchItem; }
	public JRadioButtonMenuItem getEnglishItem(){ return this.englishItem; }
	public JRadioButtonMenuItem getRussianItem(){ return this.russianItem; }

	public void addListener(ActionListener l)
	{
		this.changeRepertoryItem.addActionListener(l);

		this.bigDisplayItem.addActionListener(l);
		this.mediumDisplayItem.addActionListener(l);
		this.smallDisplayItem.addActionListener(l);

		this.frenchItem.addActionListener(l);
		this.englishItem.addActionListener(l);
		this.russianItem.addActionListener(l);
	}

	@Override
	public void update(Observable o, Object arg)
	{
		ChangeClass changes = (ChangeClass)arg;
		Model m = (Model)o;
		if(changes.getType() == ChangeType.LANGUAGE)
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
		if(changes.getType() == ChangeType.DISPLAYSIZE)
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
