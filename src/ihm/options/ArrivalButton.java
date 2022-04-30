package ihm.options;

import ihm.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ArrivalButton extends JButton implements ActionListener {

	private static final long serialVersionUID = -235600301829333396L;
	private final MazeApp mazeApp;
	
	public ArrivalButton(MazeApp mazeApp) {
		
		super("Arrival");
		
		this.mazeApp = mazeApp;
		
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mazeApp.getMazeAppModel().setCurrentBlock(ColorCell.arrival);
		mazeApp.getMazeAppModel().setEditedMode(true);
		setBackground(ColorCell.arrival);
		setForeground(Color.PINK);
 	}
	
	/** Change la couleur pour montrer qu'elle est le bloc sélectionné
	 * 
	 */
	public final void notifyForUpdate() {
		if (mazeApp.getMazeAppModel().getCurrentBlock() != ColorCell.arrival) {
			setBackground(null);
			setForeground(Color.BLACK);
		}
	}
}
