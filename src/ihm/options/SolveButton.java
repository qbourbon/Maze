package ihm.options;

import ihm.*;
import maze.MazeReadingException;

import java.awt.event.*;
import javax.swing.*;

public class SolveButton extends JButton implements ActionListener {

	private static final long serialVersionUID = -8458228155537171224L;
	private final MazeApp mazeApp;
	
	public SolveButton(MazeApp mazeApp) {
		
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
		} catch (MazeReadingException e) {} 
	}
}
