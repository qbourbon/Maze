package ihm.window;

import ihm.*;
import java.awt.*;
import maze.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MazePanel extends JPanel implements ChangeListener {

	private static final long serialVersionUID = 4410592278126850327L;
	private final MazeApp mazeApp;
	private Maze maze;
	private CellPanel[][] cellPanel;
	
	public MazePanel(MazeApp mazeApp, String fileName) throws MazeReadingException {
		
		super(new GridLayout(mazeApp.getMazeAppModel().getMaze().getHeight(),
				mazeApp.getMazeAppModel().getMaze().getWidth()));
		
		this.mazeApp = mazeApp;
		
		setBackground(Color.WHITE);
				
		setPreferredSize(new Dimension(500,500));
				
		fillCells();
	}
	
	/** Créer et remplie la fenêtre du labyrinthe
	 * 
	 */
	public void fillCells() {
        removeAll();
		maze = mazeApp.getMazeAppModel().getMaze();
		int height = maze.getHeight();
		int width = maze.getWidth();
		MBox[][] cells = maze.getCells();
		cellPanel = new CellPanel[height][width];
		setLayout(new GridLayout(height, width));
		
		for (int line=0; line < height; line++) {
			for (int column=0; column < width; column++) {
				cellPanel[line][column] = new CellPanel(cells[line][column], mazeApp);
				add(cellPanel[line][column]);
		        revalidate();
				cellPanel[line][column].notifyForUpdate();
			}
		}
	}
	
	/** Prévient la case (CellPanel) pour qu'elle se colorie
	 * 
	 * @throws MazeReadingException En aucun cas ici
	 */
	public void notifyForUpdate() throws MazeReadingException {
		this.maze = mazeApp.getMazeAppModel().getMaze();
		fillCells();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		
		if (! mazeAppModel.isModified())
			return;
		
		this.maze = mazeAppModel.getMaze();
		int height = maze.getHeight();
		int width = maze.getWidth();
				
		for (int line=0; line < height; line++) {
			for (int column=0; column < width; column++) {
				cellPanel[line][column].notifyForUpdate();
			}
		}
		
		mazeAppModel.setModified(false);
	}
}