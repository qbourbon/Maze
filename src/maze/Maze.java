package maze;

import java.io.BufferedReader;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;

public class Maze implements GraphInterface {

	private MBox[][] cells;
	private int height;
	private int width;
	
	// Initialise le labyrinthe avec que des W
	public Maze(int height, int width) {
		
		this.height = height;
		this.width = width ;
		this.cells = new MBox[height][width];
		fillWithWalls();		
	}
	
	/** Remplie le labyrinthe avec des murs
	 * 
	 */
	public final void fillWithWalls() {
			
		for (int line=0; line < height; line++) {
			
			for (int column=0; column < width; column++) {
				
				cells[line][column] = new WBox(line, column);
			
			}
		}
	}
	
	/** Renvoie la matrice des cellules
	 * 
	 * @return Matrice des cellules
	 */
	public final MBox[][] getCells() {
		return cells;
	}
	
	/** Renvoie la Hauteur
	 * 
	 * @return Hauteur
	 */
	public final int getHeight() {
		return height;
	}
	
	/** Change la hauteur du labyrinthe et le réinitialise qu'avec des murs
	 * 
	 * @param height La hauteur souhaitée
	 */
	public final void setHeight(int height) {
		this.height = height;
		this.cells = new MBox[height][width];
		fillWithWalls();
	}

	/** Renvoie la largeur
	 * 
	 * @return Largeur
	 */
	public final int getWidth() {
		return width;
	}
	
	/** Change la largeur du labyrinthe et le réinitialise qu'avec des murs
	 * 
	 * @param width La largeur souhaitée
	 */
	public final void setWidth(int width) {
		this.width = width;
		this.cells = new MBox[height][width];
		fillWithWalls();
	}
	
	@Override
	public final ArrayList<VertexInterface> getAllVertices() {
		
		ArrayList<VertexInterface> allVertices = new ArrayList<VertexInterface>();
		
		for(int line = 0; line < height; line++) {
			
			for (int column = 0; column < width; column++) {
				
				allVertices.add((VertexInterface) cells[line][column]);
			
			}
		}
		
		return allVertices;
	}
	
	@Override
	public final ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
        
		MBox box = (MBox) vertex;
        int line = box.getLine();
        int column = box.getColumn();

        ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>();

        try {
            MBox voisinG = cells[line][column-1];
            if (voisinG.getLabel() != "W")
            	successors.add((VertexInterface) voisinG);
        } catch (Exception e) {}

        try {
            MBox voisinD = cells[line][column+1];
            if (voisinD.getLabel() != "W")
            	successors.add((VertexInterface) voisinD);
        } catch (Exception e) {}

        try {
            MBox voisinH = cells[line-1][column];
            if (voisinH.getLabel() != "W")
            	successors.add((VertexInterface) voisinH);
        } catch (Exception e) {}

        try {
            MBox voisinB = cells[line+1][column];
            if (voisinB.getLabel() != "W")
            	successors.add((VertexInterface) voisinB);
        } catch (Exception e) {}

        return successors;
    }
	
	/** Change le type d'une case en un autre
	 * 
	 * @param line Ligne de la case à changer
	 * @param column Colonne de la case à changer
	 * @param letter Le type de case qu'on veut  
	 */
	private final void setCell(int line, int column, String letter) {
		
		switch(letter) {
		
		case "A": 
			cells[line][column] = new ABox(line, column);
			break;
			
		case "E":
			cells[line][column] = new EBox(line, column);
			break;
			
		case "D":
			cells[line][column] = new DBox(line, column);
			break;
			
		case "W":
			cells[line][column] = new WBox(line, column);
			break;
		
		case "P":
			cells[line][column] = new PBox(line, column);
			break;
			
		default:
			System.out.println("Caractère inconnu");
			break;
		}
	}
	
	/** Change le type d'une case en un autre
	 * 
	 * @param line Ligne de la case à changer
	 * @param column Colonne de la case à changer
	 * @param letter Le type de case qu'on veut  
	 */	
	private final void setCell(int line, int column, char letter) {
		setCell(line, column, Character.toString(letter)); // Overload avec char
	}
		
	/** Initialise le labyrinthe avec un fichier texte
	 * 
	 * @param fileName Fichier texte sur lequel il y a le labyrinthe
	 * @throws MazeReadingException Si le labyrinthe du texte n'est pas un rectangle
	 */
	public final void initFromTextFile(String fileName) throws MazeReadingException {
		
		BufferedReader br = null;
		
		try {
			String currentLine;
			br = new BufferedReader(new FileReader(fileName));
			
			int line = 0;
			while ((currentLine = br.readLine()) != null) {
				for (int column=0; column < currentLine.length(); column++) {
					try {
						this.setCell(line, column, currentLine.charAt(column));
					} catch (Exception e) {
						throw new MazeReadingException(fileName, line);
					}
				}
				System.out.println();
				line++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {}
		} 
		
	}
	
	/** Sauvegarde l'état du labyrinthe dans un fichier texte
	 * 
	 * @param fileName
	 */
	public final void saveToTextFile(String fileName) {
		
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(new FileOutputStream(fileName));
			for (int line=0; line < height; line++) {
				for (int column=0; column < width; column++) {
					pw.print(cells[line][column].getLabel());
				}
				pw.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				pw.close();
			} catch (Exception e) {} ; 
		}
	}
	
	/** Retourne le début du labyrinthe et null sinon
	 * 
	 * @return Début du labyrinthe
	 */
	public final VertexInterface getDeparture() {
		
		for( int j=0; j < width; j++) {
			
			for(int i=0; i < height; i++) {
				
				String label = cells[i][j].getLabel();
				
				if (label.compareTo("D") == 0) {
					return cells[i][j];
				}
			}
		}
		
		return null;
	}
	
	/** Retourne la fin du labyrinthe 
	 * 
	 * @return Fin du labyrinthe
	 */
	public final VertexInterface getArrival() {
		
		for( int j=0; j < width; j++) {
			
			for(int i=0; i < height; i++) {
				
				String label = cells[i][j].getLabel();
				
				if (label.compareTo("A") == 0) {
					return cells[i][j];
				}
			}
		}
		
		return null;
	}
	
	/** Sauvegarde l'état du labyrinthe en mettant P pour le chemin dans un fichier texte
	 * 
	 * @param fileName Fichier dans lequel est enregistré le labyrinthe
	 * @param path ArrayList du chemin
	 */
	public final void saveWithPath(String fileName, ArrayList<VertexInterface> path) {
		
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(new FileOutputStream(fileName));
			for (int line=0; line < height; line++) {
				for (int column=0; column < width; column++) {
					if (path.contains(cells[line][column]) && cells[line][column].getLabel() != "D" && cells[line][column].getLabel() != "A") 
						pw.print("P");
					else
						pw.print(cells[line][column].getLabel());
				}
				pw.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				pw.close();
			} catch (Exception e) {} ; 
		}
	}
	
	
	
	/* Génération de labyrinthe DFS
	 * 1) initialiser le labyrinthe avec un quadrillage 
	 * 2) choisir aléatoirement une case de départ (parmis les emptys) et le mettre sur la pile
	 * 3) Tant qu'il y a une cellule dans la pile :
	 *  - prendre la cellule en haut de la pile
	 *  - connecter-la à celle actuelle et visiter toutes les voisines disponibles
	 *  - sélectionner au hasard celle qui se retrouvera en haut de la pile et y 
	 *    introduire les autres.
	 */
	
	
	/** Retourne les cases voisines pour la génération aléatoire
	 * 
	 * @param cell La case qu'on désire connaitre ses voisins
	 * @return Voisin de cell
	 */
	private final ArrayList<MBox> getNeighbors(MBox cell) {
		int line = cell.getLine();
        int column = cell.getColumn();

        ArrayList<MBox> neighbors = new ArrayList<MBox>();

        try {
            MBox voisinG = cells[line][column-2];
            neighbors.add(voisinG);
        } catch (Exception e) {}

        try {
            MBox voisinD = cells[line][column+2];
            neighbors.add(voisinD);
        } catch (Exception e) {}

        try {
            MBox voisinH = cells[line-2][column];
            neighbors.add(voisinH);
        } catch (Exception e) {}

        try {
            MBox voisinB = cells[line+2][column];
            neighbors.add(voisinB);
        } catch (Exception e) {}

        return neighbors;
	}
	
	/** Initialise le quadrilage
	 * 
	 */
	private final void initialize() {
		for (int line=0; line < height; line++) {
			for (int column=0; column < width; column++) {
				if (line%2 == 0)
					setCell(line, column, "W");
				else if (column%2 == 0) 
					setCell(line, column, "W");
				else
					setCell(line, column, "E");
			}
		}
	}
	
	/** Choisit aléatoirement le départ et la renvoie 
	 * 
	 * @return Le départ
	 */
	private final MBox chooseDeparture() {
		int lineDeparture = (int) (Math.random() * (height/2));
		int columnDeparture = (int) (Math.random() * (width/2));
		setCell(lineDeparture * 2 + 1, columnDeparture * 2 + 1, "D");
		return cells[lineDeparture * 2 + 1][columnDeparture * 2 + 1];
	}
	
	/** Connecte 2 cases en cassant le mur entre les deux
	 * 
	 * @param cell1 Première case
	 * @param cell2 Seconde case
	 */
	private final void connect(MBox cell1, MBox cell2) {
		int line1 = cell1.getLine();
		int column1 = cell1.getColumn();
		
		int line2 = cell2.getLine();
		int column2 = cell2.getColumn();
		
		setCell((line1+line2)/2, (column1+column2)/2, "E");
	}
	
	/** Effectue l'algorithme de propagation en profondeur
	 * 
	 * @return Les cases accessibles (ie tout sauf les murs)
	 */
	private final ArrayList<MBox> propagation() {
		MBox departure = chooseDeparture();
		Stack<MBox> stack = new Stack<MBox>();
		ArrayList<MBox> emptyCases = new ArrayList<MBox>();
		stack.push(departure);
		departure.setVisited(true);
		
		while (!stack.empty()) {
			MBox currentCell = (MBox) stack.pop();
			ArrayList<MBox> neighbors = getNeighbors(currentCell);
			
			// On choisit aléatoirement par quelle case on commence le parcours en profondeur
			int randomIndex = (int) (Math.random() * neighbors.size());
			
			for (int i=0; i < neighbors.size(); i++) {
				
				if (! neighbors.get(i).isVisited()) {
					
					connect(currentCell, neighbors.get(i));
					emptyCases.add(neighbors.get(i));
					
					if (i != randomIndex) {
						stack.push(neighbors.get(i));
						neighbors.get(i).setVisited(true);
					}
				}
			}

			if (! neighbors.get(randomIndex).isVisited()) {
				stack.push(neighbors.get(randomIndex));
				neighbors.get(randomIndex).setVisited(true);
			}
		}
		
		return emptyCases;
	}
	
	/** Choisit l'arrivée aléatoirement parmis les cases accessibles
	 * 
	 */
	private final void chooseArrival() {
		ArrayList<MBox> emptyCells = propagation();
		MBox arrival = emptyCells.get((int) (Math.random() * emptyCells.size()));
		setCell(arrival.getLine(), arrival.getColumn(), "A");
	}
	
	/** Génère aléatoirement le labyrinthe
	 * 
	 */
	public final void generateMaze() {
		initialize();
		chooseArrival();
	}
	
	/** Renvoie si le labyrinthe est déjà résolu ou non
	 * 
	 * @return Labyrinthe déjà résolu
	 */
	public final Boolean isSolved() {
		for (int line=0; line < height; line++) {
			for (int column=0; column < width; column++) {
				if (cells[line][column].getLabel() == "P") {
					return true;
				}
			}
		}
		return false;
	}	
}