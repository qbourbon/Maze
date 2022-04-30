package maze;

import dijkstra.VertexInterface;

public abstract class MBox implements VertexInterface{
	
	private final int line;
	private final int column;
	private String label;
	private Boolean visited = false; 
	
	public MBox(int line, int column, String label, Boolean isReachable) {
		super();
		this.line = line;
		this.column = column;
		this.label = label;
	}

	/** Renvoie la ligne de la case 
	 * 
	 * @return La ligne de la case
	 */
	public final int getLine() {
		return line;
	}

	/** Renvoie la colone de la case 
	 * 
	 * @return La colone de la case
	 */
	public final int getColumn() {
		return column;
	}

	/** Renvoie la nature de la case
	 * 
	 * @return La nature de la case
	 */
	public final String getLabel() {
		return label;
	}
	
	/** Change la nature de la case
	 * 
	 * @param label La nature de la case
	 */
	public final void setLabel(String label) {
		this.label = label;
	}
	
	/** Renvoie si la case a déjà été visitée (utile pour la génération de labyrinthe)
	 * 
	 * @return Si la case a déjà été visitée
	 */
	public final Boolean isVisited() {
		return visited;
	}

	/** Change la valeur pour savoir si la case a déjà été visitée (utile pour la génération de labyrinthe)
 	 * 
	 * @param visited Si la case a déjà été visitée
	 */
	public final void setVisited(Boolean visited) {
		this.visited = visited;
	}
}
