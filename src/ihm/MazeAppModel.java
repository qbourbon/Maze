package ihm;

import java.util.ArrayList;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dijkstra.*;
import maze.*;

public class MazeAppModel {
	
	private Maze maze;
	private boolean modified = false;
	private Color currentBlock = Color.BLACK;
	private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();
	private boolean editedMode = false;
	private boolean sizeChanged = true;

	// Initialise le labyrinthe avec un fichier texte
	// Attention à la taille
	public MazeAppModel(String fileName) throws MazeReadingException {
		this.maze = new Maze(10,10);
		maze.initFromTextFile(fileName);
	}
	
	/** Importe un labyrinthe via un fichier texte
	 * 
	 * @param fileName Fichier texte sur lequel il y a le labyrinthe à importer
	 * @throws FileNameException Si le fichier est introuvable
	 * @throws MazeReadingException Si le labyrinthe sur le fichier n'est pas un rectangle
	 */
	public final void importMaze(String fileName) throws FileNameException, MazeReadingException {
		try {
			maze.initFromTextFile(fileName);
		} catch (Exception e) {
			throw new FileNameException(fileName);
		}
		modified = true;
		stateChanges();
	}
	
	/** Exporte le labyrinthe sur un fichier texte
	 * 
	 * @param fileName Nom et emplacement du fichier à exporter
	 */
	public final void exportMaze(String fileName) {
		maze.saveToTextFile(fileName);
	}
	
	/** Renvoie la couleur du bloc séléctionné 
	 * 
	 * @return La couleur du bloc séléctionné
	 */
	public final Color getCurrentBlock() {
		return currentBlock;
	}

	/** Renvoie si on est en train de modifier le labyrinthe
	 * 
	 * @return Si on est en train de modifier le labyrinthe
	 */
	public final boolean isEditedMode() {
		return editedMode;
	}

	/** Change la valeur pour savoir si on est en train de modifier le labyrinthe
	 * 
	 * @param editedMode Si on est en train de modifier le labyrinthe
	 */
	public final void setEditedMode(boolean editedMode) {
		this.editedMode = editedMode;
	}

	/** Change la couleur du bloc sélectionné
	 * 
	 * @param currentBlock La couleur du bloc sélectionné
	 */
	public final void setCurrentBlock(Color currentBlock) {
		this.currentBlock = currentBlock;
		stateChanges(); 
	}

	/** Renvoie le labyrinthe
	 * 
	 * @return Le labyrinthe
	 */
	public final Maze getMaze() {
		return maze;
	}
	
	/** Renvoie si le labyrinthe a été modifié
	 * 
	 * @return Si le labyrinthe a été modifié
	 */
	public final boolean isModified() {
		return modified;
	}

	/** Change la valeur pour savoir si on est en train de modifier le labyrinthe
	 * 
	 * @param modified La valeur pour savoir si on est en train de modifier le labyrinthe
	 */
	public final void setModified(boolean modified) {
		this.modified = modified;
	}
	
	/** Ajoute un listener
	 * 
	 * @param listener 
	 */
	public final void addObserver(ChangeListener listener) {
		listeners.add(listener);
	}
	
	/** Informe aux listeners que le labyrinthe a changé 
	 * 
	 */
	public final void stateChanges() {
		ChangeEvent evt = new ChangeEvent(this);
		for (ChangeListener listener : listeners)
			listener.stateChanged(evt);
	}
	
	/** Résoud le labyrinthe
	 * 
	 * @throws MazeReadingException En aucun cas ici
	 */
	public final void solve() throws MazeReadingException {		
		VertexInterface departure = maze.getDeparture();
		if (departure == null) {
			JFrame jFrame = new JFrame();
			JOptionPane.showMessageDialog(jFrame, "Il manque un départ dans le labyrinthe !");
			return;
		}
		
		VertexInterface arrival = maze.getArrival();
		if (arrival == null) {
			JFrame jFrame = new JFrame();
			JOptionPane.showMessageDialog(jFrame, "Il manque une arrivée dans le labyrinthe !");
			return;
		}
		
		PreviousInterface previous = Dijkstra.dijkstra(maze, maze.getDeparture());
		ArrayList<VertexInterface> path = previous.shortestPath(maze.getArrival());
		if (path.size() == 1) {
			JFrame jFrame = new JFrame();
			JOptionPane.showMessageDialog(jFrame, "Cassez des murs, le pauvre boug ne peut pas atteindre l'arrivée !");
			return;
		}
		maze.saveWithPath("data/solve.txt", path);
		maze.initFromTextFile("data/solve.txt");
		modified = !maze.isSolved();
		stateChanges();
	}
	
	/** Reset le labyrinthe avec que des murs 
	 * 
	 */
	public final void reset() {
		maze.fillWithWalls();
		stateChanges();
	}

	/** Renvoie si le labyrinthe est résolu
	 * 
	 * @return Si le labyrinthe est résolu
	 */
	public final boolean isMazeSolved() {
		return maze.isSolved();
	}
	
	/** Génère un labyrinthe
	 * 
	 */
	public final void generateMaze() {
		int height = maze.getHeight();
		int width = maze.getWidth();
		if (height < 2 || width < 2) {
			JFrame jFrame = new JFrame();
			JOptionPane.showMessageDialog(jFrame, "Pour générer un labyrinthe, celui-ci doit être de largeur ou de hauteur au moins égale à 2");
			return;
		}
		if (height * width < 8) {
			JFrame jFrame = new JFrame();
			JOptionPane.showMessageDialog(jFrame, "Pour générer un labyrinthe, celui-ci doit comporter au moins 8 cases");
			return;
		}
		maze.generateMaze();
		stateChanges();
	}

	/** Renvoie si la taille du labyrinthe a été changée. Utile lorsqu'on change la taille pour éviter un bug d'affichage
	 * 
	 * @return Si la taille du labyrinthe a été changée
	 */
	public final boolean isSizeChanged() {
		return sizeChanged;
	}
	
	/** Change la valeur pour savoir si on est en train de modifier la taille du labyrinthe
	 * 
	 * @param sizeChanged Si on est en train de modifier la taille du labyrinthe
	 */
	public final void setSizeChanged(boolean sizeChanged) {
		this.sizeChanged = sizeChanged;
	}
	
	
}
