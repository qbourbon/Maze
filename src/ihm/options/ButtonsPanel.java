package ihm.options;

import java.awt.*;
import ihm.*;
import javax.swing.*;

public class ButtonsPanel extends JPanel {

	private static final long serialVersionUID = 5352493043680798116L;
	//private final BlockIndicator blockIndicator;
	private final WallButton wallButton;
	private final DepartureButton departureButton;
	private final ArrivalButton arrivalButton;
	private final EmptyButton emptyButton;
	private final SizeChooser sizeChooser;
	private final GenerateButton generateButton;
	private final SolveButton solveButton;
	private final ResetButton resetButton;
	
	public ButtonsPanel(MazeApp mazeApp) {
		
		super();
		setLayout(new GridLayout(2, 8));
				
		add(sizeChooser = new SizeChooser(mazeApp));
		add(resetButton = new ResetButton(mazeApp));
		add(generateButton = new GenerateButton(mazeApp));
		add(solveButton = new SolveButton(mazeApp));
		add(departureButton = new DepartureButton(mazeApp));
		add(arrivalButton = new ArrivalButton(mazeApp));
		add(wallButton = new WallButton(mazeApp));
		add(emptyButton = new EmptyButton(mazeApp));
	}
	
	/** Informe la case indiquant le bloc sélectionné qu'elle doit peut-être changée
	 * 
	 */
	public void notifyForUpdate() {
		arrivalButton.notifyForUpdate();
		departureButton.notifyForUpdate();
		emptyButton.notifyForUpdate();
		wallButton.notifyForUpdate();

	}

	/** Renvoie l'entité qui choisit la taille du labyrinthe
	 * 
	 * @return L'entité qui choisit la taille du labyrinthe
	 */
	public final SizeChooser getSizeChooser() {
		return sizeChooser;
	}
	
	
	
}
