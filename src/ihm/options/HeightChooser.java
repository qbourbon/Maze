package ihm.options;

import ihm.*;

import java.awt.*;

import javax.swing.*;

public class HeightChooser extends JPanel {
	
	private static final long serialVersionUID = -4279548710341100446L;
	private final HeightLabel heightLabel;
	private HeightField heightField;

	
	public HeightChooser(MazeApp mazeApp) {
		
		super();
		
		setLayout(new GridLayout(1,2));
			
		add(heightLabel = new HeightLabel(mazeApp));
		add(heightField = new HeightField(mazeApp));
	}	
}
