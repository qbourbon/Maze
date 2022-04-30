package ihm.window;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;
import ihm.MazeApp;
import ihm.options.ButtonsPanel;
import maze.MazeReadingException;

public class WindowPanel extends JPanel {
	
	private static final long serialVersionUID = 6643690277443499513L;
	private final MazePanel mazePanel;
	private final ButtonsPanel buttonsPanel;
	
	public WindowPanel(MazeApp mazeApp) throws MazeReadingException {
		
		super();
		
		setLayout(new BorderLayout());
		
		add(mazePanel = new MazePanel(mazeApp, "data/labyrinthe.txt"), BorderLayout.CENTER);
		add(buttonsPanel = new ButtonsPanel(mazeApp), BorderLayout.SOUTH);
	}
	
	/** Prévient d'un changement à la vue du labyrinthe et aux cases gérant les options
	 * 
	 * @throws MazeReadingException En aucun cas ici
	 */
	public final void notifyForUpdate() throws MazeReadingException {
		mazePanel.notifyForUpdate();
		buttonsPanel.notifyForUpdate();
	}
 
	/** Renvoie l'entité qui contient toutes les options
	 * 
	 * @return L'entité qui contient toutes les options
	 */
	public final ButtonsPanel getButtonsPanel() {
		return buttonsPanel;
	}
	
	/** Renvoie l'interface graphique du labyrinthe en lui-même
	 * 
	 * @return L'interface graphique du labyrinthe
	 */
	public final MazePanel getMazePanel() {
		return mazePanel;
	}
	
}
