import model.*;
import view.*;
import controller.*;

public class DatImageViewer
{
	public static void main(String[] args)
	{
		Model model = new Model();
		MainView view = new MainView(model);
		javax.swing.SwingUtilities.invokeLater(new Runnable()
				{
					@Override
					public void run()
					{
						view.setup();
					}
				}
				);
		Controller controller = new Controller(model, view);
	}
}
