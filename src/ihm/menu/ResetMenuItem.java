package ihm.menu;

import ihm.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ResetMenuItem extends JMenuItem implements ActionListener {

	private static final long serialVersionUID = -5279257094789991424L;
	private final MazeApp mazeApp;
	
	public ResetMenuItem(MazeApp mazeApp) {
		
		super("Reset");
		
		this.mazeApp = mazeApp;
		
		addActionListener(this);
	}
	
	@Override
	public final void actionPerformed(ActionEvent evt) {
		mazeApp.getMazeAppModel().setModified(true);
		mazeApp.getMazeAppModel().reset();
	}
}
