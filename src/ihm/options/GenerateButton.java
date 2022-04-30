package ihm.options;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import ihm.*;

public class GenerateButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 3278466854960886332L;
	private final MazeApp mazeApp;
	
	public GenerateButton(MazeApp mazeApp) {
		
		super("Generate a maze");
		
		this.mazeApp = mazeApp;
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mazeApp.getMazeAppModel().generateMaze();
	}
}
