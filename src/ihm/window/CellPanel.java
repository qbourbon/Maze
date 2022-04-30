package ihm.window;

import javax.swing.*;

import ihm.ColorCell;
import ihm.MazeApp;

import java.awt.event.*;

import maze.MBox;
import java.awt.*;

public class CellPanel extends JButton implements ActionListener {

	private static final long serialVersionUID = 1929713874021594356L;
	private MBox cell;
	private final MazeApp mazeApp;


	public CellPanel(MBox cell, MazeApp mazeApp) {
		
		super();
		
		this.mazeApp = mazeApp;
		this.cell = cell;
		addActionListener(this);
		setBorderPainted(false);
	}
	
	/** Change le label d'une case par rapport à sa couleur
	 * 
	 * @param color La couleur de la case 
	 */
	private final void changeLabel(Color color) {
		if (color == ColorCell.wall)
			cell.setLabel("W");
		else if (color == ColorCell.empty)
			cell.setLabel("E");
		else if (color == ColorCell.departure)
			cell.setLabel("D");
		else if (color== ColorCell.arrival) 
			cell.setLabel("A");
		else if (color == ColorCell.path)
			cell.setLabel("P");
	}
	
	@Override 
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		switch (cell.getLabel()) {
		
		case "W" : 
			g.setColor(ColorCell.wall);
	        revalidate();
			break;
		
		case "E":
			g.setColor(ColorCell.empty);
	        revalidate();
			break;
		
		case "D":
			g.setColor(ColorCell.departure);
	        revalidate();
			break;
		
		case "A":
			g.setColor(ColorCell.arrival);
	        revalidate();
			break;
		
		case "P":
			g.setColor(ColorCell.path);
	        revalidate();
			break;
		}
		
		int w = getWidth();
		int h = getHeight();
		
		g.fillRect(0,0,w,h);
		
		g.setColor(Color.BLACK);
		g.drawRect(0,0,w,h);
	}
	
	/** Colorie la case
	 * 
	 */
	public void notifyForUpdate() {
		repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (! mazeApp.getMazeAppModel().isEditedMode()) 
			return;
		// On teste si il existe déjà un départ ou une arrivée dans le labyrinthe courant
		if (mazeApp.getMazeAppModel().getCurrentBlock() == ColorCell.departure 
			&& mazeApp.getMazeAppModel().getMaze().getDeparture() != null) 
		{
			MBox oldDeparture = (MBox) mazeApp.getMazeAppModel().getMaze().getDeparture();
			mazeApp.getMazeAppModel().getMaze().getCells()[oldDeparture.getLine()][oldDeparture.getColumn()].setLabel("E");
			mazeApp.getMazeAppModel().stateChanges();
		}
		else if (mazeApp.getMazeAppModel().getCurrentBlock() == ColorCell.arrival 
				&& mazeApp.getMazeAppModel().getMaze().getArrival() != null) 
		{
			MBox oldArrival = (MBox) mazeApp.getMazeAppModel().getMaze().getArrival();
			mazeApp.getMazeAppModel().getMaze().getCells()[oldArrival.getLine()][oldArrival.getColumn()].setLabel("E");
			mazeApp.getMazeAppModel().stateChanges();
		}
		changeLabel(mazeApp.getMazeAppModel().getCurrentBlock());
		notifyForUpdate();
		
	}
}
