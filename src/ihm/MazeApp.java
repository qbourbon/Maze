package ihm;

import ihm.menu.MenuBar;
import java.awt.*;

import ihm.window.WindowPanel;
import maze.MazeReadingException;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MazeApp extends JFrame implements ChangeListener {
	
	private static final long serialVersionUID = -4074559541806171130L;
	private final MenuBar menuBar;
	private final WindowPanel windowPanel;
	private MazeAppModel mazeAppModel = new MazeAppModel("data/labyrinthe.txt");
	
	public MazeApp() throws MazeReadingException {
		
		super("Maze application");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(windowPanel = new WindowPanel(this));
		setJMenuBar(menuBar = new MenuBar(this));
		Image icon = Toolkit.getDefaultToolkit().getImage("data/logo.png");  
		setIconImage(icon);
		mazeAppModel.addObserver(this);
		
		pack();
		setVisible(true);
	}

	/** Renvoie le model
	 * 
	 * @return Le model
	 */
	public final MazeAppModel getMazeAppModel() {
		return mazeAppModel;
	}
	
	/** Renvoie le windowPanel
	 * 
	 * @return Le windowPanel
	 */
	public final WindowPanel getWindowPanel() {
		return windowPanel;
	}
	
	@Override
	public void stateChanged(ChangeEvent evt) {
		try {
			windowPanel.notifyForUpdate();
		} catch (MazeReadingException e) {
			e.printStackTrace();
		}
	}	
}
