package ihm.menu;

import ihm.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class QuitMenuItem extends JMenuItem implements ActionListener {
	
	private static final long serialVersionUID = 2844484715175601802L;
	private final MazeApp mazeApp;
	
	public QuitMenuItem(MazeApp mazeApp) {
		
		super("Quit");
		
		this.mazeApp = mazeApp;
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
