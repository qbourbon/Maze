package maze;

import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileNameException extends FileNotFoundException {

	private static final long serialVersionUID = -1490513428424454817L;
	
	public FileNameException(String fileName) {
		super(fileName + " n'est pas un fichier texte repr�sentant un labyrinthe.");
	}
	
	/** Affiche les possibles raisons d'un import impossible de labyrinthe
	 * 
	 */
	public final void importMaze() {
		JFrame jFrame = new JFrame();
		JOptionPane.showMessageDialog(jFrame, "Le fichier repr�sente un labyrinthe ?\n"
											+ "Faute de frappe du nom du fichier ?\n"
											+ "Les dimensions du labyrinthe actuel sont �gales ou plus grandes � celle du labyrinthe � importer ?");
	}
}
