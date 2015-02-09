import java.awt.*;

public class MainMenu extends MenuBar
{
	public MainMenu()
	{
		Menu repertory = new Menu("Répertoire");
		repertory.add(new MenuItem("Changer de répertoire"));

		Menu display = new Menu("Affichage");
		display.add(new MenuItem("Grand"));
		display.add(new MenuItem("Moyen"));
		display.add(new MenuItem("Petit"));

		Menu languages = new Menu("Langues");
		languages.add(new MenuItem("Français"));
		languages.add(new MenuItem("Anglais"));
		languages.add(new MenuItem("Russe"));

		this.add(repertory);
		this.add(display);
		this.add(languages);
	}
}
