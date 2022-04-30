package ihm.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

import ihm.MazeApp;
import maze.FileNameException;
import maze.MazeReadingException;

public class ImportMenuItem extends JMenuItem implements ActionListener {

	private static final long serialVersionUID = -3301763254777661941L;
	private final MazeApp mazeApp;
	
	public ImportMenuItem(MazeApp mazeApp) {
		
		super("Import");
		
		this.mazeApp = mazeApp;
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame jFrame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setMultiSelectionEnabled(false);
		fileChooser.setCurrentDirectory(new File("C"));
		fileChooser.showDialog(jFrame, "Import this maze");
		File file = fileChooser.getSelectedFile();
		String fileName = file.getPath();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			mazeApp.getMazeAppModel().importMaze(fileName);
		} catch (FileNameException e1) {
			e1.importMaze();
		} catch (MazeReadingException e1) {
			e1.printStackTrace();
		}
	}
}
