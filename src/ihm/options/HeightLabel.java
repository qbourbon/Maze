package ihm.options;

import ihm.*;
import javax.swing.*;

public class HeightLabel extends JLabel {

	private static final long serialVersionUID = -5497405507853986950L;
	private final MazeApp mazeApp;
	
	public HeightLabel(MazeApp mazeApp) {
		
		super("Height: ");
		
		this.mazeApp = mazeApp;
	}
}
