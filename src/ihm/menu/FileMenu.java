package ihm.menu;

import ihm.*;
import javax.swing.*;

public class FileMenu extends JMenu {

	private static final long serialVersionUID = -7031333409817503608L;
	private final QuitMenuItem quitMenuItem;
	private final GenerateMenuItem generateMenuItem;
	private final ResetMenuItem resetMenuItem;
	private final SolveMenuItem solveMenuItem;
	private final ImportMenuItem importMenuItem;
	private final ExportMenuItem exportMenuItem;
	
	public FileMenu(MazeApp mazeApp) {
		
		super("File");
		
		add(importMenuItem = new ImportMenuItem(mazeApp));
		add(exportMenuItem = new ExportMenuItem(mazeApp));
		add(solveMenuItem = new SolveMenuItem(mazeApp));
		add(resetMenuItem = new ResetMenuItem(mazeApp));
		add(generateMenuItem = new GenerateMenuItem(mazeApp));
		add(quitMenuItem = new QuitMenuItem(mazeApp));
	}
}
