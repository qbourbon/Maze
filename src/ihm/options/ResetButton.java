package ihm.options;

import ihm.*;
import java.awt.event.*;
import javax.swing.*;

public class ResetButton extends JButton implements ActionListener {

	private static final long serialVersionUID = -9116189616335654467L;
	private final MazeApp mazeApp;
	
	public ResetButton(MazeApp mazeApp) {
		
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
