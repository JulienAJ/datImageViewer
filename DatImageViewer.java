import model.*;
import view.*;
import controller.*;

public class DatImageViewer
{
	public static void main(String[] args)
	{
		Model model = new Model();
		MainView view = new MainView(model);
		Controller controller = new Controller(model, view);
	}
}
