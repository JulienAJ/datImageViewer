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
	JRadioButtonMenuItem chineseItem;

	public MainMenu(Model m)
	{
		super();
		m.setLanguage(m.getLanguage());
		// Repertory
		repertoryMenu = new JMenu(m.getString("repertory"));

		changeRepertoryItem = new JMenuItem(m.getString("change"));

		repertoryMenu.add(changeRepertoryItem);

		// Display
		displayMenu = new JMenu(m.getString("display"));

		bigDisplayItem = new JRadioButtonMenuItem(m.getString("big"));
		bigDisplayItem.setSelected(true);
		mediumDisplayItem = new JRadioButtonMenuItem(m.getString("medium"));
		mediumDisplayItem.setSelected(false);
		smallDisplayItem = new JRadioButtonMenuItem(m.getString("small"));
		smallDisplayItem.setSelected(false);

		displayButtonGroup = new ButtonGroup();
		displayButtonGroup.add(bigDisplayItem);
		displayButtonGroup.add(mediumDisplayItem);
		displayButtonGroup.add(smallDisplayItem);

		displayMenu.add(bigDisplayItem);
		displayMenu.add(mediumDisplayItem);
		displayMenu.add(smallDisplayItem);

		// Languages
		languagesMenu = new JMenu(m.getString("languages"));

		frenchItem = new JRadioButtonMenuItem("Français");
		frenchItem.setSelected(true);
		englishItem = new JRadioButtonMenuItem("English");
		englishItem.setSelected(false);
		chineseItem = new JRadioButtonMenuItem("中国");
		chineseItem.setSelected(false);

		ButtonGroup languagesButtonGroup = new ButtonGroup();
		languagesButtonGroup.add(frenchItem);
		languagesButtonGroup.add(englishItem);
		languagesButtonGroup.add(chineseItem);

		languagesMenu.add(frenchItem);
		languagesMenu.add(englishItem);
		languagesMenu.add(chineseItem);

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
	public JRadioButtonMenuItem getChineseItem(){ return this.chineseItem; }

	public void addListener(ActionListener l)
	{
		this.changeRepertoryItem.addActionListener(l);

		this.bigDisplayItem.addActionListener(l);
		this.mediumDisplayItem.addActionListener(l);
		this.smallDisplayItem.addActionListener(l);

		this.frenchItem.addActionListener(l);
		this.englishItem.addActionListener(l);
		this.chineseItem.addActionListener(l);
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
				chineseItem.setSelected(false);
			}
			else if(lang.equals("english"))
			{
				frenchItem.setSelected(false);
				englishItem.setSelected(true);
				chineseItem.setSelected(false);
			}
			else if(lang.equals("chinese"))
			{
				frenchItem.setSelected(false);
				englishItem.setSelected(false);
				chineseItem.setSelected(true);
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

			repertoryMenu.setText(m.getString("repertory"));
			changeRepertoryItem.setText(m.getString("change"));
			
			displayMenu.setText(m.getString("display"));
			bigDisplayItem.setText(m.getString("big"));
			mediumDisplayItem.setText(m.getString("medium"));
			smallDisplayItem.setText(m.getString("small"));
			
			languagesMenu.setText(m.getString("languages"));
		}
	}
}
