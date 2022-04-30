package ihm.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ihm.MazeApp;

public class ExportMenuItem extends JMenuItem implements ActionListener {

	private static final long serialVersionUID = 3462023761460056642L;
	private final MazeApp mazeApp;
	
	public ExportMenuItem(MazeApp mazeApp) {
		
		super("Export");
		
		this.mazeApp = mazeApp;
		
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame jFrame = new JFrame();
        String fileName = JOptionPane.showInputDialog(jFrame, "Enter the file name (with the extension .txt !) to export in data : fileName");
        // Vérifie que le nom n'est pas le même que celui qui initialise le labyrinthe au lancement de l'application
        if (fileName.compareTo("labyrinthe.txt") == 0) {
        	JFrame jFrame2 = new JFrame();
    		JOptionPane.showMessageDialog(jFrame2,"Vous ne pouvez pas choisir ce nom de fichier à défaut de tout casser. Merci de changer.");
    		return;
        }
        mazeApp.getMazeAppModel().exportMaze("data/" + fileName);
	}
	
}
