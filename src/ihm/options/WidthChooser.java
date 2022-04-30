package ihm.options;

import ihm.*;
import java.awt.GridLayout;
import javax.swing.*;

public class WidthChooser extends JPanel {

	private static final long serialVersionUID = 525442064565840285L;
	private final WidthLabel widthLabel;
	private WidthField widthField;
	
	public WidthChooser(MazeApp mazeApp) {
		
		super();
		
		setLayout(new GridLayout(1,2));
			
		add(widthLabel = new WidthLabel(mazeApp));
		add(widthField = new WidthField(mazeApp));
	}	
}
