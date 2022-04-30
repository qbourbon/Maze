package ihm.options;

import ihm.*;
import maze.Maze;

import javax.swing.*;
import java.awt.event.*;

public class WidthField extends JTextField implements ActionListener {

	private static final long serialVersionUID = -6506054978842732227L;
	private final MazeApp mazeApp;
	
	public WidthField(MazeApp mazeApp) {
		
		super("10");
		
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		Maze maze = mazeAppModel.getMaze();
		
		// Teste si l'entrée est bien positive et pas trop grande 
		if (Integer.parseInt(this.getText()) < 1 || Integer.parseInt(this.getText()) > 200)
			return;
		// Tests si les dimensions ont changé
		if (Integer.parseInt(this.getText()) != maze.getWidth())
		{
			mazeAppModel.setModified(true);
			mazeAppModel.setSizeChanged(true);
			mazeAppModel.getMaze().setWidth(Integer.parseInt(this.getText()));
			mazeAppModel.reset();
			mazeAppModel.setModified(false);
			mazeAppModel.setSizeChanged(false);
		}
	}
}
