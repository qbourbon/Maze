package ihm.options;

import ihm.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class WallButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 6438962573874276494L;
	private final MazeApp mazeApp;
	
	public WallButton(MazeApp mazeApp) {
		
		super("Wall");
		
		this.mazeApp = mazeApp;
		
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mazeApp.getMazeAppModel().setCurrentBlock(ColorCell.wall);
		mazeApp.getMazeAppModel().setEditedMode(true);
		setBackground(ColorCell.wall);
		setForeground(Color.PINK);
	}
	
	/** Change la couleur pour montrer qu'elle est le bloc sélectionné
	 * 
	 */
	public final void notifyForUpdate() {
		if (mazeApp.getMazeAppModel().getCurrentBlock() != ColorCell.wall) {
			setBackground(null);
			setForeground(Color.BLACK);
		}
	}
}
