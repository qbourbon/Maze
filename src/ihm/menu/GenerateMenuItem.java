package ihm.menu;

import ihm.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GenerateMenuItem extends JMenuItem implements ActionListener {
	
	private static final long serialVersionUID = 1052170976349575199L;
	private final MazeApp mazeApp;
	
	public GenerateMenuItem(MazeApp mazeApp) {
		
		super("Generate");
		
		this.mazeApp = mazeApp;
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mazeApp.getMazeAppModel().generateMaze();
	}
}
