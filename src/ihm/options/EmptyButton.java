package ihm.options;

import ihm.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmptyButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final MazeApp mazeApp;
	
	public EmptyButton(MazeApp mazeApp) {
		
		super("Empty");
		
		this.mazeApp = mazeApp;
		
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mazeApp.getMazeAppModel().setCurrentBlock(ColorCell.empty);
		mazeApp.getMazeAppModel().setEditedMode(true);
		setBackground(ColorCell.empty);
		setForeground(Color.PINK);
	}
	
	/** Change la couleur pour montrer qu'elle est le bloc sélectionné
	 * 
	 */
	public final void notifyForUpdate() {
		if (mazeApp.getMazeAppModel().getCurrentBlock() != ColorCell.empty) {
			setBackground(null);
			setForeground(Color.BLACK);
		}
	}
}
