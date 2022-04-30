package ihm.options;

import ihm.*;

import java.awt.GridLayout;

import javax.swing.*;

public class SizeChooser extends JPanel {

	private static final long serialVersionUID = 1030239839028034197L;
	private final HeightChooser heightChooser;
	private final WidthChooser widthChooser;
	
	public SizeChooser(MazeApp mazeApp) {
		
		super();
		
		setLayout(new GridLayout(2, 1));
		
		add(heightChooser = new HeightChooser(mazeApp));
		add(widthChooser = new WidthChooser(mazeApp));
	}

	public final HeightChooser getHeightChooser() {
		return heightChooser;
	}

	public final WidthChooser getWidthChooser() {
		return widthChooser;
	}
	
	
}
