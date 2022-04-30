package ihm.menu;

import ihm.*;
import maze.MazeReadingException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SolveMenuItem extends JMenuItem implements ActionListener {

	private static final long serialVersionUID = 2942557122707805101L;
	private final MazeApp mazeApp;
	
	public SolveMenuItem(MazeApp mazeApp) {
		
		super("Solve");
		
		this.mazeApp = mazeApp;
		
		addActionListener(this);
	}
	
	@Override
	public final void actionPerformed(ActionEvent evt) {

		if (mazeApp.getMazeAppModel().isMazeSolved())
			return;
		
		try {
			mazeApp.getMazeAppModel().solve();
		} catch (MazeReadingException e) {
			
		}
	}
}