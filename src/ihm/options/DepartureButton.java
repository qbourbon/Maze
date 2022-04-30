package ihm.options;

import ihm.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class DepartureButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 6785657282698132904L;
	private final MazeApp mazeApp;
	
	public DepartureButton(MazeApp mazeApp) {
		
		super("Departure");
		
		this.mazeApp = mazeApp;
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mazeApp.getMazeAppModel().setCurrentBlock(ColorCell.departure);
		mazeApp.getMazeAppModel().setEditedMode(true);
		setBackground(ColorCell.departure);
		setForeground(Color.PINK);
	}
	
	/** Change la couleur pour montrer qu'elle est le bloc sélectionné
	 * 
	 */
	public final void notifyForUpdate() {
		if (mazeApp.getMazeAppModel().getCurrentBlock() != ColorCell.departure) {
			setBackground(null);
			setForeground(Color.BLACK);
		}
	}
}	
