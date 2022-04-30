package ihm.options;

import ihm.*;
import javax.swing.*;

public class WidthLabel extends JLabel {

	private final MazeApp mazeApp;
	
	public WidthLabel(MazeApp mazeApp) {
		
		super("Width: ");
		
		this.mazeApp = mazeApp;
	}
}
