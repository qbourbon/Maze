package ihm.menu;

import java.awt.Color;

import javax.swing.*;

import ihm.*;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 7440687067499098856L;
	private FileMenu fileMenu;
	
	public MenuBar(MazeApp mazeApp) {
		
		super();
		setBackground(Color.PINK);

		add(fileMenu = new FileMenu(mazeApp));
	}
}
